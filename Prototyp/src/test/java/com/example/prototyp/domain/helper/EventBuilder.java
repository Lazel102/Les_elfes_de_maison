package com.example.prototyp.domain.helper;


import com.example.prototyp.domain.oldEventAgregate.Event;
import java.util.List;

public class EventBuilder {

  String title;
  Integer numberOfParticipants;
  List<String> participants;






  public EventBuilder() {}

  public EventBuilder withTitle(String title) {
    this.title=title;
    return this;
  }
  public EventBuilder withNumberOfParticipants(int numberOfParticipants){
    this.numberOfParticipants=numberOfParticipants;
    return this;
  }





  public Event create() {
    Event event = Event.of(this.numberOfParticipants,  this.title);
    participants.forEach(p -> event.addParticipant(p));
    return event;
  }


  public EventBuilder withParticipants(List<String> participants) {
    this.participants=participants;
    return this;
  }

}
