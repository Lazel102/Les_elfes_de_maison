package com.example.prototyp.web.forms;

import java.util.List;

public record RecipeForm(String title, String description, List<String> ingredients,String instruction) {
}
