package com.example.prototyp.persistence1;

import static org.assertj.core.api.Assertions.assertThat;
import com.example.prototyp.domain.Event;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.jdbc.DataJdbcTest;
import org.springframework.context.annotation.Import;
@Import(EventRepoPostgresImplementation.class)
@DataJdbcTest
class PersistenceTest {

  @Autowired
  private EventRepoPostgresImplementation eventRepo;
  @Test
  @DisplayName("Ein Event kann hinzugefügt werden")
  void test_1() {
    Event event = new Event(null, "Invalides", "Desktop", LocalDate.of(2022,2,1),4, "Napoleon's Kitchen Elves" );
    Long id = eventRepo.saveEvent(event);
    assertThat(id).isEqualTo(1);
  }
  @Test
  @DisplayName("Event can be loaded from database")
  void test_2() {
    Event event = new Event(null, "Invalides", "Desktop", LocalDate.of(2022,2,1),4, "Napoleon's Kitchen Elves" );
    Long id = eventRepo.saveEvent(event);
    Optional<Event> event_new = eventRepo.findEventById(id);
    assertThat(event_new.get().getAdress()).isEqualTo("Invalides");
  }
  @Test
  @DisplayName("Events with recipes can be added to the database")
  void test_3() {
    Event event = new Event(null, "Invalides", "Desktop", LocalDate.of(2022,2,1),4, "Napoleon's Kitchen Elves" );
    event.addRecipe("Yassine","lasagne", List.of("Tomatoes","Meat","Pasta"),"Cook not to long and not to short","path/to/image.png");
    Long id = eventRepo.saveEvent(event);
    Optional<Event> event_new = eventRepo.findEventById(id);
    assertThat(event_new.get().getRecipes()).hasSize(1);
  }

  @Test
  @DisplayName("Multiple Events can be loaded from the database")
  void test_4() {
    Event event1 = new Event(null, "Invalides", "Desktop", LocalDate.of(2022,2,1),4, "Napoleon's Kitchen Elves" );
    Event event2 = new Event(null, "Invalides", "Desktop", LocalDate.of(2022,2,1),4, "Napoleon's Kitchen Elves" );
    event1.addRecipe("Yassine","lasagne", List.of("Tomatoes","Meat","Pasta"),"Cook not to long and not to short","path/to/image.png");
    event2.addRecipe("Yassine","lasagne", List.of("Tomatoes","Meat","Pasta"),"Cook not to long and not to short","path/to/image.png");
    Long id1 = eventRepo.saveEvent(event1);
    Long id2 = eventRepo.saveEvent(event2);
    List events = eventRepo.findAll();
    assertThat(events).hasSize(2);
  }
}
