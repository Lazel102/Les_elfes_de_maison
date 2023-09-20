package com.example.prototyp.persistence1.databaseDtos;
import java.util.List;
import org.springframework.data.annotation.Id;


public record Recipe (@Id Long id,
                      String chef,
                      String title,
                      String ingredients, // todo: Ingredients is saved as a String, so we need to ensure that there is no "," in each ingredient string
                      String instructions,
                      String image,
                      String description
)
{

}



