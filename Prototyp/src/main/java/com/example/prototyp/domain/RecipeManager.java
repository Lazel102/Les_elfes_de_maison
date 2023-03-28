package com.example.prototyp.domain;

import com.example.prototyp.domain.displayDtos.RecipeDto;
import com.example.prototyp.domain.forms.RecipeForm;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RecipeManager {
  private List<Recipe> recipes= new ArrayList<>();

  void addRecipe(String chef, RecipeForm recipeForm){
    recipes.add(new Recipe(recipeForm,chef));
  }


  public List<RecipeDto> getRecipes() {
    return recipes.stream().map(recipe -> new RecipeDto(recipe)).collect(Collectors.toList());
  }
}
