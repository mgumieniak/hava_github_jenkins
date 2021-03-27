package com.example.demo.cache.config;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile({"prod", "default"})
@Configuration
public class ProdCacheConfiguration {

    @Bean
    CacheManager cacheManager() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName("java-github-jenkins");
        clientConfig.getNetworkConfig().addAddress("localhost:5701");
        return new HazelcastCacheManager(HazelcastClient.newHazelcastClient(clientConfig));
    }
}
