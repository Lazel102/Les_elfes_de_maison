package com.example.prototyp.service;

import com.example.prototyp.domain.Event;
import com.example.prototyp.domain.displayDtos.EventDto;
import com.example.prototyp.persistence.EventRepository;
import java.util.List;
import java.util.Optional;
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
    return repo.findEventById(id).orElseThrow(EventNotExistingException::new);
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
