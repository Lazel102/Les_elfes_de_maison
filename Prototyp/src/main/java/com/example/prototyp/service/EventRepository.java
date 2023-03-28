package com.example.prototyp.service;

import com.example.prototyp.domain.Event;
import java.util.List;

public interface EventRepository {

  Long saveEvent(Event event);
  Event findEventById(Long id);
  List<Event> findAll();
}
