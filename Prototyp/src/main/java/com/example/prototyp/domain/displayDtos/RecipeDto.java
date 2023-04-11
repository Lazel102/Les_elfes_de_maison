package com.example.prototyp.domain.displayDtos;

import com.example.prototyp.domain.Recipe;
import org.springframework.web.multipart.MultipartFile;

public record RecipeDto(String title, String chef, String image) {
  public RecipeDto(Recipe recipe){
    this(recipe.getTitle(), recipe.getChef(), recipe.getImage());
  }
}
