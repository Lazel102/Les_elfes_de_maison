package com.example.prototyp.persistence.databaseDtos;

import java.util.List;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;

@Entity
public record Event(@Id Long id,
        String title,
        @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) List<Recipe> recipes,
        String kitchenadress,
        String kitchenImageURL,
        Integer numberOfParticipants,
        String date) {
}
