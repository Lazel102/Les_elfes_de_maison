package com.example.prototyp.domain;

import java.util.ArrayList;
import java.util.List;

public class RecipeManager {
  private List<Recipe> recipes= new ArrayList<>();

  void addRecipe(List<String> ingredients, String description){
    recipes.add(new Recipe(ingredients,description));
  }


}
