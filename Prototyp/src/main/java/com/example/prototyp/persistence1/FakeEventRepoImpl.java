package com.example.prototyp.persistence1;

import com.example.prototyp.domain.Event;
import com.example.prototyp.service.EventRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


public class FakeEventRepoImpl implements EventRepository {
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
  public Optional<Event> findEventById(Long id) {
    return Optional.ofNullable(fakeDB.get(id));
  }

  @Override
  public List<Event> findAll() {
    return fakeDB.values().stream().toList();
  }
}
