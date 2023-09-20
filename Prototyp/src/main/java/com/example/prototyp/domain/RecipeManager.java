package com.example.prototyp.domain;

import com.example.prototyp.domain.displayDtos.RecipeDto;
import com.example.prototyp.domain.forms.RecipeForm;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RecipeManager {
  private List<Recipe> recipes= new ArrayList<>();

  void addRecipe(String chef, RecipeForm recipeForm){
    recipes.add(new Recipe(recipeForm,chef));
  }

  void addRecipe( String chef, String title, List<String> ingredients, String instructions, String image,String description) {
    recipes.add(new Recipe(chef, title, ingredients, instructions, image ,description));
  }

  public List<RecipeDto> getRecipeDtos() {
    return recipes.stream().map(recipe -> new RecipeDto(recipe)).collect(Collectors.toList());
  }

  public List<Recipe> getRecipes() {
    return new ArrayList<Recipe>(recipes);
  }
}
