package com.example.prototyp.service;

import java.util.Arrays;
import java.util.List;

public class DtoConversionService {
  public static List<String> convertIngredientStringToList(String ingredients){
    return Arrays.asList(ingredients.split(",", -1));
  };
}
