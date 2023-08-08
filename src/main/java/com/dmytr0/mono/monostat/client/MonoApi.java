package com.dmytr0.mono.monostat.client;

import com.dmytr0.mono.monostat.config.MonoConfig;
import com.dmytr0.mono.monostat.dto.MonoClientInfo;
import com.dmytr0.mono.monostat.dto.MonoStatement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "mono-client", url = "https://api.monobank.ua/personal", configuration = MonoConfig.class)
public interface MonoApi {

    @GetMapping(
            value = "/statement/{account}/{from}/{to}",
            produces = "application/json")
    List<MonoStatement> getStatements(@PathVariable("account") String account,
                                      @PathVariable("from") long from,
                                      @PathVariable("to") long to);

    @GetMapping(
            value = "/client-info",
            produces = "application/json")
    MonoClientInfo getClientInfo();

}
