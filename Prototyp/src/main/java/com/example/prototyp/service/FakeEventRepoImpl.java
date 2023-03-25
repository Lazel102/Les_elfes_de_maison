package com.example.prototyp.service;

import com.example.prototyp.domain.Event;
import java.util.HashMap;
import org.springframework.stereotype.Repository;

@Repository
public class FakeEventRepoImpl implements EventRepository{
  HashMap<Long, Event> fakeDB =new HashMap<Long, Event>();
  Long idGenerator = Long.valueOf(0);
  @Override
  public Long saveEvent(Event event) {
    fakeDB.put(idGenerator,event);
    idGenerator++;
    return idGenerator-1;
  }
}
