package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entity.Recipe;

public interface RecipeRepository extends JpaRepository<Recipe, Long> {
	List<Recipe> findByCategoryIn(List<String> categories);
}

