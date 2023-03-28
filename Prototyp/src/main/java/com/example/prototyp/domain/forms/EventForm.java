package com.example.prototyp.domain.forms;


import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

public record EventForm(/*@DateTimeFormat(pattern = "yyyy-MM-dd")*/ String date, Integer numberOfParticipants, String kitchenImage, String kitchenAdress, String title) {

}
