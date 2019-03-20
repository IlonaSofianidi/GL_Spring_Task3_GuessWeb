package com.gl.homework.config;

import com.gl.homework.service.impl.GameProperties;
import com.gl.homework.service.impl.GameServiceImpl;
import com.gl.homework.service.impl.NumberGeneratorImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@ComponentScan(basePackages = "com.gl.homework")
@Configuration
public class WebConfig {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

    @Bean
    public NumberGeneratorImpl numberGenerator() {
        return new NumberGeneratorImpl();
    }

    @Bean
    public GameServiceImpl guessService() {
        return new GameServiceImpl();
    }

    @Bean
    public GameProperties gameProperties() {
        return new GameProperties();
    }

}

