package com.example.project.service.config;

import com.example.project.service.CarShopService;
import com.example.project.service.FakeCarShopService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceAutoConfiguration {

    @Bean
    public FakeCarShopService carShopServices() {
        return new CarShopService();
    }
}

