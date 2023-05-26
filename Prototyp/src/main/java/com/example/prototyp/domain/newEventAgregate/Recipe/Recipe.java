package com.example.prototyp.domain.newEventAgregate.Recipe;

import java.util.List;

public class Recipe {

  private final Long id;

  public Recipe(Long id, String title, List<String> ingredients, String instruction,
                String imageUrl) {
    this.id = id;
    this.title = title;
    this.ingredients = ingredients;
    this.instruction = instruction;
    this.imageUrl = imageUrl;
  }

  private final String title;
  private final List<String> ingredients;
  private final String instruction;
  private final String imageUrl;
}
