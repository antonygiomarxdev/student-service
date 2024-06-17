package com.services.ms.student.student_service.infrastructure.adapters.input.env;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DotenvConfig {

    public static void SetEnv() {
        Dotenv dotenv = Dotenv.load();
        System.setProperty("spring.datasource.url", dotenv.get("DB_URL"));
        System.setProperty("spring.datasource.username", dotenv.get("DB_USER"));
        System.setProperty("spring.datasource.password", dotenv.get("DB_PASSWORD"));
    }

    @Bean
    public Dotenv dotenv() {
        return Dotenv.load();
    }
}