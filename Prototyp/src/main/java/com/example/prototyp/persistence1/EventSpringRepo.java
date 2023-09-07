package com.example.prototyp.persistence1;

import com.example.prototyp.persistence1.databaseDtos.Event;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSpringRepo extends CrudRepository<Event, Long> {
  List<Event> findAll();
}
