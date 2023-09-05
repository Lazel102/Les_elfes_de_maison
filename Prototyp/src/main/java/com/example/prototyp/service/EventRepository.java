package com.example.prototyp.service;

import com.example.prototyp.domain.Event;
import java.util.List;
import java.util.Optional;

public interface EventRepository {

  Long saveEvent(Event event);
  Optional<Event> findEventById(Long id);
  List<Event> findAll();
}
