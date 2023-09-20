package com.example.prototyp.domain;

import com.example.prototyp.domain.displayDtos.RecipeDto;
import com.example.prototyp.domain.forms.EventForm;
import com.example.prototyp.domain.forms.RecipeForm;
import java.time.LocalDate;
import java.util.List;

public class Event {

  private Long id;
  private final String title;

  private final String description;
  private final ParticipantManager participantManager;
  private final Kitchen kitchen;
  private final LocalDate datum;
  private final RecipeManager recipeManager = new RecipeManager();

  //todo: Make sure only one constructor remains. This can be fixed within the static factory method.
  public Event(Long id, String adress, String kitchenImageUrl, String creator, LocalDate datum, int numberOfParticipants,
               String title, String description) {
    this.title = title;
    this.description = description;
    this.kitchen = new Kitchen(adress, kitchenImageUrl);
    this.datum = datum;
    this.participantManager = new ParticipantManager(numberOfParticipants, creator);
    this.id = id;
  }


  public Event(Long id, String adress, String kitchenImageUrl, LocalDate date, int numberOfParticipants, String title,
               String description) {
    this.title = title;
    this.description = description;
    this.kitchen = new Kitchen(adress, kitchenImageUrl);
    this.datum = date;
    this.participantManager = new ParticipantManager(numberOfParticipants);
    this.id = id;
  }

  public static Event of(Integer maxNumberOfParticipants, String title) {
    return new Event(null, null, null, "Creator", null, maxNumberOfParticipants, title, null);
  };

  public static Event of(EventForm eventForm, String creator) {
    return new Event(null, eventForm.kitchenAdress(), eventForm.kitchenImage().getOriginalFilename(), creator,
        eventForm.datum(),
        eventForm.numberOfParticipants(), eventForm.title(), eventForm.description());
  }

  // todo: Has to be deleted when the program is connected to web
  public String getTitle() {
    return this.title;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
    return this.id;
  };

  public void addParticipant(String name) {
    participantManager.addParticipant(name);
  }

  public void addRecipe(String chef, RecipeForm recipeForm) {
    recipeManager.addRecipe(chef, recipeForm);
  }

  public void addRecipe(String chef, String title, List<String> ingredients, String instructions, String image, String description) {
    recipeManager.addRecipe( chef, title, ingredients, instructions, image, description);
  }

  public List<String> getParticipants() {
    return participantManager.getParticipants();
  }

  public Integer getNumberOfParticipants() {
    return participantManager.getNumberOfParticipants();
  }

  public Integer getMaxNumberOfParticipants() {
    return participantManager.getMaxNumberOfParticipants();
  }

  public String getKitchenImageUrl() {
    return kitchen.getImageUrl();
  }

  public LocalDate getDatum() {
    return this.datum;
  }

  public String getAdress() {
    return kitchen.getAdress();
  }

  public Boolean isParticipant(String name) {
    return participantManager.isParticipant(name);
  }

  public List<RecipeDto> getRecipeDisplayDtos() {
    return recipeManager.getRecipeDtos();
  }

  public List<Recipe> getRecipes() {
    return recipeManager.getRecipes();
  }
  public String getDescription() {
    return description;
  }

  public Boolean isFull() {
    return participantManager.isFull();
  }

}
