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
  void addParticipant(String name){
    if (participants.size()+1 <= maxNumberOfParticipants){
      participants.add(new Participant(name));
    }
  }

  public List<String> getParticipants() {
    return participants.stream().map(participant -> participant.name()).collect(Collectors.toList());
  }
  public Integer getNumberOfParticipants(){
    return participants.size();
  }

  public Integer getMaxNumberOfParticipants() {
    return maxNumberOfParticipants;
  }

  public Boolean isParticipant(String name) {
    return participants.contains(new Participant(name));
  }

}
