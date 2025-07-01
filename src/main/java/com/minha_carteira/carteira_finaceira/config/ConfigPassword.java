package com.minha_carteira.carteira_finaceira.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class ConfigPassword {

    @Bean
    public PasswordEncoder passwordConfig() {
        return new BCryptPasswordEncoder();
    }

}
