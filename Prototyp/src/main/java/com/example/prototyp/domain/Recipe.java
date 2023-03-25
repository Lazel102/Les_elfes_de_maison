package com.example.prototyp.domain;

import java.util.ArrayList;
import java.util.List;

public class Recipe {
  private final List<String> ingredients= new ArrayList<>();
  private final String description;
  Recipe(List<String> ingredients, String description) {
    this.description = description;
    this.ingredients.addAll(ingredients);
  }
}
