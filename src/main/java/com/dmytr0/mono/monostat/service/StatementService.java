package com.dmytr0.mono.monostat.service;

import com.dmytr0.mono.monostat.client.MonoApi;
import com.dmytr0.mono.monostat.dto.MonoStatement;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StatementService {

    private final MonoApi monoApi;


    public void test() {
        List<MonoStatement> monoApiStatements = monoApi.getStatements("lW3yw_li85Iyc69fygt2kQ", 1688797978, 1691479978);
        System.out.println(monoApiStatements);
    }
}
