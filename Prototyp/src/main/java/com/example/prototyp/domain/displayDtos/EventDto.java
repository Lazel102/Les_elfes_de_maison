package com.example.prototyp.domain.displayDtos;

import com.example.prototyp.domain.Event;

public record EventDto(String title, Integer numberOfParticipants, Integer maxNumberOfParticipants, String date, String adress, Long id, String kitchenImage) {
  public EventDto(Event event){
      this(event.getTitle(), event.getNumberOfParticipants(), event.getMaxNumberOfParticipants(), event.getAdress(), event.getDate(), event.getId(),
          event.getKitchenImageUrl());
  }
}
