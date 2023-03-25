package com.example.prototyp.domain;

import java.util.ArrayList;
import java.util.List;

class ParticipantManager {
  private final List<Participant> participants;
  int numberOfParticipants;
  ParticipantManager(int numberOfParticipants, String creator){
    this.numberOfParticipants = numberOfParticipants;
    this.participants= List.of(new Participant(creator));
  }
  void addParticipant(String name){
    if (participants.size()+1 <=numberOfParticipants){
      participants.add(new Participant(name));
    }
  }

}
