package com.app.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorizeRequests -> authorizeRequests
                .requestMatchers("/", "/login", "/main", "/css/**", "/js/**", "/images/**", "/static/**", "/favicon.ico", "/login.html", "/api/recipes/random","/logout").permitAll()
                .anyRequest().authenticated()
            )
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sessionManagement -> 
                sessionManagement
                    .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
            )
            .logout(logout -> logout
            		.logoutUrl("/logout")  // ログアウトのURLを設定
            		.invalidateHttpSession(true) // セッションを無効化
            		.clearAuthentication(true)   // 認証情報をクリア
            		.logoutSuccessUrl("/login")  // ログアウト後に遷移するURL
            );
        return http.build();
    }
}


