package com.example.prototyp.domain;

import java.util.List;

public class Event {
  private final ParticipantManager participantManager;
  private final Kitchen kitchen;
  private final String date;
  private final RecipeManager recipeManager= new RecipeManager();

  public Event(String adress, String imageUrl, String creator, String date, int numberOfParticipants){
    this.kitchen= new Kitchen(adress,imageUrl);
    this.date=date;
    this.participantManager=new ParticipantManager(numberOfParticipants,creator);

  }

  public static Event of(String date, Integer numberOfParticipants, String name, String kitchenImage, String kitchenAdress) {
    return new Event(kitchenAdress, kitchenImage, name,date, numberOfParticipants);
  }

  public void addParticipant(String name){
    participantManager.addParticipant(name);
  }
  public void addRecipe(List<String> ingredients, String description){
    recipeManager.addRecipe(ingredients,description);
  }
}
