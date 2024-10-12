package com.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class RecipeRequest {
    private String username;
    private List<String> ingredients;

    // ゲッターとセッター
}