package com.example.prototyp.domain;

import com.example.prototyp.domain.displayDtos.RecipeDto;
import com.example.prototyp.domain.forms.EventForm;
import com.example.prototyp.domain.forms.RecipeForm;
import java.util.List;

public class Event {


  private Long id;
  private final String title;
  private final ParticipantManager participantManager;
  private final Kitchen kitchen;
  private final String date;
  private final RecipeManager recipeManager= new RecipeManager();

  public Event(Long id ,String adress, String kitchenImageUrl, String creator, String date, int numberOfParticipants, String title){
    this.title= title;
    this.kitchen= new Kitchen(adress,kitchenImageUrl);
    this.date=date;
    this.participantManager=new ParticipantManager(numberOfParticipants,creator);
    this.id =id;
  }


  public static Event of(EventForm eventForm, String creator) {
    return new Event(null, eventForm.kitchenAdress(), eventForm.kitchenImage().getOriginalFilename(), creator, eventForm.date(),
        eventForm.numberOfParticipants(), eventForm.title());
  }
  //todo: Has to be deleted when the program is connected to web
  public String getTitle(){
    return this.title;
  }
  public void setId(Long id){this.id = id;}

  public Long getId(){ return this.id ;};
  public void addParticipant(String name){
    participantManager.addParticipant(name);
  }
  public void addRecipe(String chef, RecipeForm recipeForm){
    recipeManager.addRecipe(chef,recipeForm);
  }
  public List<String> getParticipants(){
    return participantManager.getParticipants();
  }
  public Integer getNumberOfParticipants(){
    return participantManager.getNumberOfParticipants();
  }
  public Integer getMaxNumberOfParticipants(){
    return participantManager.getMaxNumberOfParticipants();
  }
  public String getKitchenImageUrl(){
    return kitchen.getImageUrl();
  }
  public String getDate(){
    return this.date;
  }
  public String getAdress(){
    return kitchen.getAdress();
  }

  public Boolean isParticipant(String name) {
    return participantManager.isParticipant(name);
  }
  public List<RecipeDto> getRecipes(){
    return recipeManager.getRecipes();
  }
}
