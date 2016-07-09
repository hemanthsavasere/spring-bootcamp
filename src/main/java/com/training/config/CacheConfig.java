package com.training.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.CacheErrorHandler;
import org.springframework.cache.interceptor.CacheResolver;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Sandeep.K on 7/9/2016.
 */
@Configuration
@EnableCaching
class CacheConfig implements CachingConfigurer {

    @Bean
    public CacheManager cacheManager() {
        ClientConfig config = new ClientConfig();
        config.getNetworkConfig().addAddress("192.168.100.190:5701");
        HazelcastInstance client = HazelcastClient.newHazelcastClient(config);

        return new HazelcastCacheManager(client);
    }

    @Override
    public CacheResolver cacheResolver() {
        return null;
    }

    @Bean
    public KeyGenerator keyGenerator() {
        return null;
    }

    @Override
    public CacheErrorHandler errorHandler() {
        return null;
    }
}
