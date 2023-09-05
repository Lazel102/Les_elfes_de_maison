package com.example.prototyp.domain.displayDtos;

import com.example.prototyp.domain.Event;
import java.time.LocalDate;

public record EventDto(String title, Integer numberOfParticipants, Integer maxNumberOfParticipants, LocalDate date, String adress, Long id, String kitchenImage) {
  public EventDto(Event event){
      this(event.getTitle(), event.getNumberOfParticipants(), event.getMaxNumberOfParticipants(),  event.getDatum(),event.getAdress(), event.getId(),
          event.getKitchenImageUrl());
  }
}
