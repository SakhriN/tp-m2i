package com.example.ex1.service;

import org.springframework.stereotype.Service;
import com.example.ex1.model.Recipe;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RecipeService {

    private final Map<UUID, Recipe> recipes;

    public RecipeService() {
        recipes = new HashMap<>();

        Recipe recipeA = Recipe.builder()
                .id(UUID.randomUUID())
                .name("Fondant au chocolat")
                .time_cooking(35)
                .time_preparation(45)
                .instructions("Faire bouillir l'eau, la jeter sur un passant\n" +
                        "et hop y a plus rien.")
                .ingredients(Arrays.asList("Chocolat","Lait","Beurre","50 euros","un magasin de vente de fondant au chocolat"))
                .build();

        Recipe recipeB = Recipe.builder()
                .id(UUID.randomUUID())
                .name("Fondant au chocolat")
                .time_cooking(35)
                .time_preparation(45)
                .instructions("Faire bouillir l'eau, la jeter sur un passant\n" +
                        "et hop y a plus rien.")
                .ingredients(Arrays.asList("Chocolat","Lait","Beurre","50 euros","un magasin de vente de fondant au chocolat"))
                .build();

        Recipe recipeC = Recipe.builder()
                .id(UUID.randomUUID())
                .name("Fondant au chocolat")
                .time_cooking(35)
                .time_preparation(45)
                .instructions("Faire bouillir l'eau, la jeter sur un passant\n" +
                        "et hop y a plus rien.")
                .ingredients(Arrays.asList("Chocolat","Lait","Beurre","50 euros","un magasin de vente de fondant au chocolat"))
                .build();

        recipes.put(recipeA.getId(), recipeA);
        recipes.put(recipeB.getId(), recipeB);
        recipes.put(recipeC.getId(), recipeC);
    }

    public List<Recipe> getRecipes() {
        return recipes.values().stream().toList();
    }

    public void addRecipe(Recipe recipe) {
        recipe.setId(UUID.randomUUID());
        recipes.put(recipe.getId(), recipe);
    }

    public Recipe getRecipeById(UUID id) {
        return recipes.values().stream().filter(s -> s.getId().equals(id)).findFirst().orElse(null);
        //  return rabbits.get(id);
    }

    public List<Recipe> getRecipeByIngredient(String ingredient) {
        return recipes.values().stream()
                .filter(recipe -> recipe.getIngredients().contains(ingredient))
                .collect(Collectors.toList()); }

    public boolean updateRecipe(UUID id, Recipe recipe) {
        boolean test = false;
        Recipe verification = getRecipeById(id);
        if (verification != null) {
            recipe.setId(verification.getId());
            recipes.put(recipe.getId(), recipe);
            test = true;
        }
        return test;
    }

    public boolean deleteRecipeById(UUID id) {
        boolean test = false;
        if (getRecipeById(id) != null) {
            recipes.remove(id);
            test = true;
        }
        return test;
    }

}
