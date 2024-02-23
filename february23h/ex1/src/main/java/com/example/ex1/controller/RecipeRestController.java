package com.example.ex1.controller;

import com.example.ex1.model.Recipe;
import com.example.ex1.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/home")
public class RecipeRestController {

    private final RecipeService recipeService;

    @PostMapping("recipes")
    public Recipe createRecipe(@RequestBody @Valid Recipe recipe, BindingResult bindingResult) {
        recipe.setId(UUID.randomUUID());
        recipeService.addRecipe(recipe);
        return recipe;
    }

    @GetMapping("recipes")
    public List<Recipe> getAllRecipe() {
        return recipeService.getRecipes();
    }

    @GetMapping("recipe/{id}")
    public Recipe getOneRecipe(@PathVariable("id") UUID id) {
        return recipeService.getRecipeById(id);
    }

    @PutMapping("recipe/{id}")
    public boolean UpdateRecipe(@PathVariable("id") UUID id, @Valid @RequestBody Recipe recipe, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){

        }
        return recipeService.updateRecipe(id, recipe);
    }

    @DeleteMapping("recipe/{id}")
    public boolean DeleteRecipe(@PathVariable("id") UUID id) {
        return recipeService.deleteRecipeById(id);
    }

}
