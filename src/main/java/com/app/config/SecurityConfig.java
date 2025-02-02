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
                .requestMatchers("/", "/css/**", "/js/**", "/images/**", "/static/**", "/login.html", "/register.html", "/main.html", "/profile.html").permitAll()  // 静的リソースとルートパスを許可
                .anyRequest().authenticated()  // それ以外のリクエストを認証
            )
            .csrf(csrf -> csrf.disable());  // 新しい方法でCSRF保護を無効に

        return http.build();
    }
}
