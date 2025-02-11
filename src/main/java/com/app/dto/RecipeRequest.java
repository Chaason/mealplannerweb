package com.app.dto;

import java.util.List;

import lombok.Data;

@Data
public class RecipeRequest {
    private List<String> ingredients;
}
