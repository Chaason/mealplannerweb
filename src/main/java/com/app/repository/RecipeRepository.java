package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}



