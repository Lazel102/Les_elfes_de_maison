package com.example.prototyp.controller;

import com.example.prototyp.service.EventService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;


public class ControllerTest {
  @Autowired
  MockMvc mockMvc;
  @MockBean
  EventService eventService;
  @Test
  @DisplayName("Eventforms können hinzugefügt werden.")
  public void test01(){


  }
}
