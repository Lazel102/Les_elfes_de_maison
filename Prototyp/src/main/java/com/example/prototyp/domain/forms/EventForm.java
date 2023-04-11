package com.example.prototyp.domain.forms;


import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public record EventForm(/*@DateTimeFormat(pattern = "yyyy-MM-dd")*/ String date, Integer numberOfParticipants, MultipartFile kitchenImage, String kitchenAdress, String title) {

}
