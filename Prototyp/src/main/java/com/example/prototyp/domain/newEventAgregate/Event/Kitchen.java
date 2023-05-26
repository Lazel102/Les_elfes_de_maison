package com.example.prototyp.domain.newEventAgregate.Event;

class Kitchen {
  private final String adress;
  private final String imageUrl;

  public Kitchen(String adress, String imageUrl){
    this.adress = adress;
    this.imageUrl=imageUrl;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public String getAdress() {
    return this.adress;
  }
}
