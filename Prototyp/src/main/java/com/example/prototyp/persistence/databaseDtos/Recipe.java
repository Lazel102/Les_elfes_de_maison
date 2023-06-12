package com.example.prototyp.persistence.databaseDtos;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
public record Recipe(@Id @GeneratedValue Long id, String chef, String title,
        @ElementCollection List<String> ingredients,
        String instructions, String image, Long eventId) {
}
