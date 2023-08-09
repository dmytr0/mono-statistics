package com.dmytr0.mono.monostat.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableCaching
public class CacheConfig {

    public static final String ACCOUNTS_CACHE = "accountsCache";
    public static final String ACCOUNTS_CACHE_MANAGER = "accountsCacheManager";

    @Value("${mono.accounts.cache.ttlInMinutes:60}")
    private int cacheTtl;

    @Bean(ACCOUNTS_CACHE_MANAGER)
    public CacheManager myCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();

        CaffeineCache accountsCache = new CaffeineCache(ACCOUNTS_CACHE,
                Caffeine.newBuilder()
                        .expireAfterWrite(cacheTtl, TimeUnit.MINUTES)
                        .maximumSize(100)
                        .build()
        );

        cacheManager.setCaches(List.of(accountsCache));
        return cacheManager;
    }
}
