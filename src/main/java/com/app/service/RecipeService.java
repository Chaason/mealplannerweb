package com.app.service;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Recipe;
import com.app.repository.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getRandomRecipes() {
        List<Recipe> allRecipes = recipeRepository.findAll();
        Random random = new Random();
        int totalRecipes = allRecipes.size();

        if (totalRecipes <= 3) {
            return allRecipes;
        }

        return List.of(
            allRecipes.get(random.nextInt(totalRecipes)),
            allRecipes.get(random.nextInt(totalRecipes)),
            allRecipes.get(random.nextInt(totalRecipes))
        );
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

