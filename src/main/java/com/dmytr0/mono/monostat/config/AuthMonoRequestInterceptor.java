package com.dmytr0.mono.monostat.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.springframework.core.annotation.Order;

@Order(1)
public class AuthMonoRequestInterceptor implements RequestInterceptor {

    private static final String TOKEN_HEADER = "X-Token";

    private final String authToken;

    public AuthMonoRequestInterceptor(String authToken) {
        this.authToken = authToken;
    }

    @Override
    public void apply(final RequestTemplate requestTemplate) {
        requestTemplate.header(TOKEN_HEADER,  authToken);
    }

}
