package com.app.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.entity.Recipe;
import com.app.entity.User;
import com.app.repository.RecipeRepository;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    public List<Recipe> getRandomRecipes(User user, List<String> ingredients) {
        List<Recipe> recipes;
        if (ingredients.isEmpty()) {
            recipes = recipeRepository.findByUser_Id(user.getId());
        } else {
            recipes = recipeRepository.findByIngredientsContainingAndUser_Id(String.join(",", ingredients), user.getId());
        }
        Collections.shuffle(recipes);
        return recipes.size() > 3 ? recipes.subList(0, 3) : recipes;
    }

    public Recipe saveRecipe(Recipe recipe) {
        recipe.setSavedDate(new Date());
        return recipeRepository.save(recipe);
    }

    public List<Recipe> getUserRecipes(Long userId) {
        return recipeRepository.findByUser_Id(userId);
    }

}
