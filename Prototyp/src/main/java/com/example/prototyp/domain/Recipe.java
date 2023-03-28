package com.example.prototyp.domain;

import com.example.prototyp.domain.forms.RecipeForm;
import java.util.List;

public class Recipe {
  private final String title;
  private final String description;
  private final List<String> ingredients;
  private final String instruction;
  private final String imageUrl;

  private final String chef;
  Recipe(RecipeForm recipeForm, String chef) {
    this.chef=chef;
    this.description = recipeForm.description();
    this.title = recipeForm.title();
    this.ingredients = recipeForm.ingredients();
    this.instruction = recipeForm.instruction();
    this.imageUrl = recipeForm.imageUrl();

  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public List<String> getIngredients() {
    return ingredients;
  }

  public String getInstruction() {
    return instruction;
  }

  public String getImage() {
    return imageUrl;
  }

  public String getChef() {
    return chef;
  }
}
