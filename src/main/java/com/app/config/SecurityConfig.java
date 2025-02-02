package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/", "/test", "/css/**", "/js/**", "/images/**", "/static/**", "/favicon.ico", "/login.html", "/register.html", "/main.html", "/profile.html").permitAll()  // 静的リソースとルートパスを許可
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable());

        return http.build();
    }
}
