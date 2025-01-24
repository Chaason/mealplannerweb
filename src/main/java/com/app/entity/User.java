package com.app.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;
    private String password;
    private String allergies;

    // パスワードをハッシュ化するメソッド
    public void setPassword(String password) {
        this.password = new BCryptPasswordEncoder().encode(password);
    }
}
