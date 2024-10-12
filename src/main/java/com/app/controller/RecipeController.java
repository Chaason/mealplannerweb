package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.RecipeRequest;
import com.app.entity.Recipe;
import com.app.entity.User;
import com.app.service.RecipeService;
import com.app.service.UserService;

@RestController
@RequestMapping("/api/recipes")
public class RecipeController {
    @Autowired
    private RecipeService recipeService;
    @Autowired
    private UserService userService;

    @PostMapping("/random")
    public List<Recipe> getRandomRecipes(@RequestBody RecipeRequest request) {
        User user = userService.findByUsername(request.getUsername());
        return recipeService.getRandomRecipes(user, request.getIngredients());
    }

    @PostMapping("/save")
    public Recipe saveRecipe(@RequestBody Recipe recipe) {
        return recipeService.saveRecipe(recipe);
    }

    @GetMapping("/user/{userId}")
    public List<Recipe> getUserRecipes(@PathVariable Long userId) {
        return recipeService.getUserRecipes(userId);
    }

}
