package com.example.workflow;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    public UserConfigTest configTest() {
        UserConfigTest uct = new UserConfigTest("utku", "güngüt");
        return uct;
    }

}
