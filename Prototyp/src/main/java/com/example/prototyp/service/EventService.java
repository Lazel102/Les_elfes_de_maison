package com.example.prototyp.service;

import com.example.prototyp.domain.Event;
import com.example.prototyp.domain.displayDtos.EventDto;
import java.util.List;
import java.util.stream.Collectors;
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

  public Event findEventbyId(Long id){
    return repo.findEventById(id);
  }

  public List<EventDto> getUserEvents(String user) {
    return repo.findAll()
        .stream()
        .filter(event ->event.isParticipant(user))
        .map(event ->new EventDto(event))
        .collect(Collectors.toList());
  }

  public List<EventDto> getJoinableEvents(String user) {
    return repo.findAll()
        .stream()
        .filter(event ->!event.isParticipant(user))
        .map(event->new EventDto(event))
        .collect(Collectors.toList());

  }
}
