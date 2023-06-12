package com.example.prototyp.persistence;

import com.example.prototyp.persistence.databaseDtos.Event;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

public interface EventSpringRepo extends CrudRepository<Event, Long> {
  List<Event> findAll();
}
