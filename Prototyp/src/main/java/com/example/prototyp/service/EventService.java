package com.example.prototyp.service;

import com.example.prototyp.domain.Event;
import org.springframework.stereotype.Service;

@Service
public class EventService {

  EventRepository repo;

  public EventService(EventRepository repo) {
    this.repo = repo;
  }
  public Long saveEvent(Event event){
    return repo.saveEvent(event);
  }
}
