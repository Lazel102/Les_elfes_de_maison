package com.example.prototyp.service;

import com.example.prototyp.domain.Event;

public interface EventRepository {

  Long saveEvent(Event event);
}
