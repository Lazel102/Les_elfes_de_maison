package com.example.prototyp.persistence;

import com.example.prototyp.persistence.databaseDtos.Event;
import com.example.prototyp.persistence.databaseDtos.Recipe;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Repository;

public class EventRepoPostgresImplementation implements EventRepository {

  private final EventSpringRepo eventSpringRepo;

  public EventRepoPostgresImplementation(EventSpringRepo eventSpringRepo) {
    this.eventSpringRepo = eventSpringRepo;
  }

  @Override
  public Long saveEvent(com.example.prototyp.domain.Event event) {
    Event eventDto = toDto(event);
    return eventSpringRepo.save(eventDto).id();
  }

  @Override
  public Optional<com.example.prototyp.domain.Event> findEventById(Long id) {
    return eventSpringRepo.findById(id).map(this::fromDto);
  }

  private com.example.prototyp.domain.Event fromDto(Event event) {
    com.example.prototyp.domain.Event domainEvent = new com.example.prototyp.domain.Event(event.id(),
        event.kitchenadress(), event.kitchenImageURL(), event.date(), event.numberOfParticipants(), event.title());
    event.recipes().stream().forEach(r -> domainEvent.addParticipant(r.chef()));
    event.recipes().stream()
        .forEach(r -> domainEvent.addRecipe(r.id(), r.chef(), r.title(), r.ingredients(), r.instructions(), r.image()));
    return domainEvent;
  }

  @Override
  public List<com.example.prototyp.domain.Event> findAll() {
    return eventSpringRepo.findAll().stream()
        .map(e -> fromDto(e)).collect(Collectors.toList());
  }

  private Event toDto(com.example.prototyp.domain.Event event) {
    List<Recipe> recipes = event.getRecipes().stream().map(r -> new Recipe(r.getId(), r.getChef(), r.getTitle(),
        r.getIngredients(), r.getInstruction(), r.getImage(), event.getId())).collect(Collectors.toList());
    return new Event(event.getId(), event.getTitle(), recipes, event.getAdress(),
        event.getKitchenImageUrl(), event.getMaxNumberOfParticipants(), event.getDate());
  }

}
