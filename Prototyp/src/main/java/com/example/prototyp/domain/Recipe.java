package com.example.prototyp.domain;

import com.example.prototyp.domain.forms.RecipeForm;
import java.util.List;

public class Recipe {
  private final Long id;
  private final String title;
  private final List<String> ingredients;
  private final String instruction;
  private final String imageUrl;

  private final String chef;

  Recipe(RecipeForm recipeForm, String chef) {
    this.id = null;
    this.chef = chef;
    this.title = recipeForm.title();
    this.ingredients = recipeForm.ingredients();
    this.instruction = recipeForm.instruction();
    this.imageUrl = recipeForm.image().getOriginalFilename();

  }

  public Recipe(Long id, String chef, String title, List<String> ingredients, String instructions, String image) {
    this.id = id;
    this.chef = chef;
    this.title = title;
    this.ingredients = ingredients;
    this.instruction = instructions;
    this.imageUrl = image;
  }

  public Long getId() {
    return this.id;
  }

  public String getTitle() {
    return title;
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
