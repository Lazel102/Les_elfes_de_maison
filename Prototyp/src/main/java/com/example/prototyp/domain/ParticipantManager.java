package com.example.prototyp.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class ParticipantManager {
  private final List<Participant> participants;

  int maxNumberOfParticipants;
  ParticipantManager(int numberOfParticipants, String creator){
    this.maxNumberOfParticipants = numberOfParticipants;
    this.participants= new ArrayList<>();
    this.participants.add(new Participant(creator));
  }

  public ParticipantManager(int numberOfParticipants) {
    this.maxNumberOfParticipants = numberOfParticipants;
    this.participants= new ArrayList<>();

  }

  void addParticipant(String name){
    if (participants.size()+1 <= maxNumberOfParticipants){
      participants.add(new Participant(name));
    }
  }

  List<String> getParticipants() {
    return participants.stream().map(participant -> participant.name()).collect(Collectors.toList());
  }
  Integer getNumberOfParticipants(){
    return participants.size();
  }

  Integer getMaxNumberOfParticipants() {
    return maxNumberOfParticipants;
  }

  Boolean isParticipant(String name) {
    return participants.contains(new Participant(name));
  }

  Boolean isFull() {
    return maxNumberOfParticipants==getNumberOfParticipants();
  }
}
