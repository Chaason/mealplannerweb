package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findByUser_Id(Long userId);
    List<Recipe> findByIngredientsContainingAndUser_Id(String ingredient, Long userId);
}
