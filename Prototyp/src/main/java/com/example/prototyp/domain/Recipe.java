package com.example.prototyp.domain;

import com.example.prototyp.domain.forms.RecipeForm;
import java.util.List;

public class Recipe {

  private final String title;
  private final List<String> ingredients;
  private final String instruction;
  private final String imageUrl;

  private final String chef;
  private final String description;

  Recipe(RecipeForm recipeForm, String chef) {
    this.chef = chef;
    this.title = recipeForm.title();
    this.ingredients = recipeForm.ingredients();
    this.instruction = recipeForm.instruction();
    this.imageUrl = recipeForm.image().getOriginalFilename();
    this.description = recipeForm.description();

  }

  public Recipe( String chef, String title, List<String> ingredients, String instructions, String image, String description) {
    this.chef = chef;
    this.title = title;
    this.ingredients = ingredients;
    this.instruction = instructions;
    this.imageUrl = image;
    this.description=description;
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

  public String getDescription() {
    return description;
  }
}
