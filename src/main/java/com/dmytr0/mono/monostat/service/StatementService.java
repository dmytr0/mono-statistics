package com.dmytr0.mono.monostat.service;

import com.dmytr0.mono.monostat.client.MonoApi;
import com.dmytr0.mono.monostat.converter.StatementConverter;
import com.dmytr0.mono.monostat.converter.UnixTimeConverter;
import com.dmytr0.mono.monostat.domain.Statement;
import com.dmytr0.mono.monostat.dto.MonoAccount;
import com.dmytr0.mono.monostat.repository.StatementRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static com.dmytr0.mono.monostat.config.CacheConfig.ACCOUNTS_CACHE;
import static com.dmytr0.mono.monostat.config.CacheConfig.ACCOUNTS_CACHE_MANAGER;
import static com.dmytr0.mono.monostat.domain.Currency.UAH;

@Log4j2
@Service
@RequiredArgsConstructor
public class StatementService {

    @Value("${mono.statement.startDateUnix:#{T(java.time.Instant).now().getEpochSecond()}}")
    private long statementStartDate;

    @Value("${mono.statistic.supportedCardType: #{'black.white'.split(',')}")
    private List<String> supportedCardType;

    private final MonoApi monoApi;
    private final StatementRepository repository;
    private final StatementConverter statementConverter;

    @Cacheable(cacheNames = ACCOUNTS_CACHE, cacheManager = ACCOUNTS_CACHE_MANAGER)
    public List<String> getUAHAccountIds() {
        return monoApi.getClientInfo().getAccounts().stream()
                .filter(a -> a.getCurrencyCode() == UAH.getNumericCode())
                .filter(a -> supportedCardType.contains(a.getType()))
                .map(MonoAccount::getId)
                .collect(Collectors.toList());
    }

    public long getLatestStatementDate() {
        return repository.findMaxTime()
                .map(UnixTimeConverter::toUnixTime)
                .orElse(statementStartDate);
    }

    public void fetchAndStore(String account, long from, long to) {
        var monoApiStatements = monoApi.getStatements(account, from, to);
        var statements = monoApiStatements.stream()
                .map(statementConverter::toEntity)
                .collect(Collectors.toList());

        saveAll(statements);
    }

    private void saveAll(List<Statement> statements) {
        for (Statement statement : statements) {
            try {
                repository.saveAndFlush(statement);
            } catch (Exception e) {
                log.error("Error saving statement {}", statement);
            }
        }
    }
}
