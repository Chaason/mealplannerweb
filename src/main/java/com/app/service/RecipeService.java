package com.app.service;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Recipe;
import com.app.repository.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getRandomRecipes(List<String> categories) {
        List<Recipe> allRecipes;

        // チェックが一つもついていない場合は、すべての献立を取得
        if (categories == null || categories.isEmpty()) {
            allRecipes = recipeRepository.findAll();
        } else {
            allRecipes = recipeRepository.findByCategoryIn(categories);
        }

        int totalRecipes = allRecipes.size();

        if (totalRecipes <= 3) {
            return allRecipes;
        }

        Collections.shuffle(allRecipes);
        return allRecipes.subList(0, 3);
    }
    
    /*public List<Recipe> getRandomRecipes() {
        List<Recipe> allRecipes = recipeRepository.findAll();
        Collections.shuffle(allRecipes);

        return allRecipes.stream().limit(3).toList();
    }*/


    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }
}

