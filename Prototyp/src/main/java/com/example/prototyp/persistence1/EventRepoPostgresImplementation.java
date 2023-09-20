package com.example.prototyp.persistence1;

import com.example.prototyp.persistence1.databaseDtos.Event;
import com.example.prototyp.persistence1.databaseDtos.Recipe;
import com.example.prototyp.service.DtoConversionService;
import com.example.prototyp.service.EventRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary
public class EventRepoPostgresImplementation implements EventRepository {
  @Autowired
  private  EventSpringRepo eventSpringRepo;

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
        event.kitchen_address(), event.kitchen_image_url(), event.datum(), event.numberOfParticipants(), event.title(),
        event.description());
    event.recipes().stream().forEach(r -> domainEvent.addParticipant(r.chef()));
    event.recipes().stream()
        .forEach(r -> domainEvent.addRecipe( r.chef(), r.title(), DtoConversionService.convertIngredientStringToList(r.ingredients()), r.instructions(), r.image(), r.description()));
    return domainEvent;
  }

  @Override
  public List<com.example.prototyp.domain.Event> findAll() {
    return eventSpringRepo.findAll().stream()
        .map(e -> fromDto(e)).collect(Collectors.toList());
  }

  private Event toDto(com.example.prototyp.domain.Event event) {
    List<Recipe> recipes = event.getRecipes().stream().map(r -> new Recipe( null, r.getChef(), r.getTitle(),
        r.getIngredients().toString(), r.getInstruction(), r.getImage(), r.getDescription())).collect(Collectors.toList());
    return new Event(event.getId(), event.getTitle(), recipes, event.getAdress(),
        event.getKitchenImageUrl(), event.getMaxNumberOfParticipants(), event.getDatum(),event.getDescription());
  }

}
