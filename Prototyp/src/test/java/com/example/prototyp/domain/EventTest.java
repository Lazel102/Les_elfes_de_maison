package com.example.prototyp.domain;
import com.example.prototyp.domain.helper.EventBuilder;
import java.util.List;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class EventTest {

  @Test
  void isFull() {
    Event testEvent = new EventBuilder().
        withNumberOfParticipants(3).
        withParticipants(List.of("Victor Hugo", "Réné Descartes")).
        create();
    assertThat(testEvent.isFull()).isTrue();
  }
}