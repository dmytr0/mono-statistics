package com.dmytr0.mono.monostat.config;

import feign.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MonoConfig {

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }


    @Bean
    public AuthMonoRequestInterceptor requestInterceptor(@Value("${client.mono.auth-token}") final String authToken) {
        return new AuthMonoRequestInterceptor(authToken);
    }
}
