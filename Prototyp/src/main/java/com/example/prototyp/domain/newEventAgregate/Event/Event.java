package com.example.prototyp.domain.newEventAgregate.Event;


public class Event {
  public Event(Long id, String title, Kitchen kitchen, String date) {
    this.id = id;
    this.title = title;
    this.kitchen = kitchen;
    this.date = date;
  }

  private final Long id;
  private String title;
  private final Kitchen kitchen;
  private final String date;
  private int maxNumberOfParticipants;

  private int currentNumberOfParticipants;

}
