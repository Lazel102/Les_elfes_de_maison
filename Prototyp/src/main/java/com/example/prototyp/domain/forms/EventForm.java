package com.example.prototyp.domain.forms;


import java.time.LocalDate;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

public record EventForm(@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate datum, Integer numberOfParticipants, MultipartFile kitchenImage, String kitchenAdress, String title, String description) {


}
