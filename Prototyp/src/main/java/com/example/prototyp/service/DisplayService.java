package com.example.prototyp.service;

import com.example.prototyp.domain.oldEventAgregate.Event;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class DisplayService {
  public static boolean showJoinEvent(Event event, UsernamePasswordAuthenticationToken token){
    return !(event.isParticipant(token.getName()) && event.isFull());
  }
}
