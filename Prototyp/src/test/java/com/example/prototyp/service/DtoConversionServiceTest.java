package com.example.prototyp.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;


class DtoConversionServiceTest {

  @Test
  public void testingredientsListToStringConversion(){
    String ingredientString = "200g Tomaten,20 Äpfel,17l Ochsenmilch";
    List<String> ingredientList = DtoConversionService.convertIngredientStringToList(ingredientString);
    assertThat(ingredientList).containsExactlyInAnyOrder("200g Tomaten","20 Äpfel","17l Ochsenmilch");
  }

}