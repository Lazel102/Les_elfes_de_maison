package com.example.prototyp.persistence1.databaseDtos;

import java.time.LocalDate;
import java.util.List;


import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;


public record Event(@Id Long id,
                    String title,
                    List<Recipe> recipes,
                    String kitchen_address,
                    String kitchen_image_url,
                    Integer numberOfParticipants,
                    @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datum) {

}

