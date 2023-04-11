package com.example.prototyp.domain.forms;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public record RecipeForm(String title, String description, List<String> ingredients,String instruction, MultipartFile image) {
}
