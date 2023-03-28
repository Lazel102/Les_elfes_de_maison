package com.example.prototyp.domain.forms;

import java.util.List;

public record RecipeForm(String title, String description, List<String> ingredients,String instruction, String imageUrl) {
}
