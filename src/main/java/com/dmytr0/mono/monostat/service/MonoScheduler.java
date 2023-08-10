package com.dmytr0.mono.monostat.service;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Log4j2
@Service
@RequiredArgsConstructor
public class MonoScheduler {

    private static final ScheduledExecutorService SCHEDULER = Executors.newScheduledThreadPool(2);

    private final StatementService statementService;

    @PostConstruct
    public void schedule() {
        log.info("TEST TEST TEST");
//        updateStatementsTask().run();
    }

    private Runnable updateStatementsTask(String account) {
        return () -> {
            long latestStatementDate = statementService.getLatestStatementDate();

//            statementService.fetchAndStore()

//            SCHEDULER.schedule(updateStatementsTask(), 1, TimeUnit.DAYS);
        };
    }
}
