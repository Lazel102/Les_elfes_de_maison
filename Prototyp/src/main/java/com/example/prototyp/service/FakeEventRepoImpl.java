package com.example.prototyp.service;

import com.example.prototyp.domain.Event;
import java.util.HashMap;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class FakeEventRepoImpl implements EventRepository{
  HashMap<Long, Event> fakeDB =new HashMap<Long, Event>();
  Long idGenerator = Long.valueOf(0);
  @Override
  public Long saveEvent(Event event) {
    if (event.getId() == null) {
      event.setId(idGenerator);
      fakeDB.put(idGenerator, event);
      idGenerator++;
    }
    return event.getId();
  }

  @Override
  public Event findEventById(Long id) {
    return fakeDB.get(id);
  }

  @Override
  public List<Event> findAll() {
    return fakeDB.values().stream().toList();
  }
}
