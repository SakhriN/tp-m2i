package com.example.ex1.controller;

import com.example.ex1.model.Recipe;
import com.example.ex1.service.RecipeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class RecipeController {

    private final RecipeService recipeService;

    @GetMapping
    public String homePage() {
        return "page_home";
    }

    @GetMapping("/ajout")
    public String addRecipe(Model model) {
        model.addAttribute("recipe", new Recipe());
        return "form/form";
    }

    @PostMapping("/ajout")
    public String submitRecipe(@ModelAttribute("recipe") @Valid Recipe recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form/form";
        }
        recipeService.addRecipe(recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/regarde")
    public String showRecipe(@RequestParam("ingredient") String ingredient, Model model) {
        List<Recipe> recipes = recipeService.getRecipeByIngredient(ingredient);
        model.addAttribute("recettes", recipes);
        model.addAttribute("ingredient",ingredient);
        return "page_list";
    }

    @GetMapping("/recipe/{recipeId}")
    public String detailRecipe(@PathVariable("recipeId") UUID id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        model.addAttribute("marecette", recipe);
        return "page_detail";
    }

    @GetMapping("/recipes")
    public String pageb(Model model) {
        List<Recipe> recipes = recipeService.getRecipes();
        model.addAttribute("recettes", recipes);
        model.addAttribute("ingredient", null);
        return "page_list";
    }


    @GetMapping("/edit/{id}")
    public String editRecipe(@PathVariable("id") UUID id, Model model) {
        Recipe recipe = recipeService.getRecipeById(id);
        if (recipe != null) {
            model.addAttribute("recipe",recipe);
            return "form/form";
        } else {
            return "/page_list";
        }
    }

    @PostMapping("/edit/{id}")
    public String submitEditRecipe(@PathVariable("id") UUID id,@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return "form/form";
        }
        recipeService.updateRecipe(id, recipe);
        return "redirect:/recipes";
    }

    @GetMapping("/delete/{id}")
    public String deleteRecipe(@PathVariable("id") UUID id) {
        recipeService.deleteRecipeById(id);
        return "redirect:/recipes";
    }

}
