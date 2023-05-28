package com.example.prototyp.web;


import static com.example.prototyp.config.WebConfig.UPLOAD_DIRECTORY;


import com.example.prototyp.domain.displayDtos.EventDto;
import com.example.prototyp.domain.displayDtos.RecipeDto;
import com.example.prototyp.domain.newEventAgregate.Event.Event;
import com.example.prototyp.security.User;
import com.example.prototyp.service.DisplayService;
import com.example.prototyp.service.EventService;
import com.example.prototyp.domain.forms.EventForm;
import com.example.prototyp.domain.forms.RecipeForm;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class WebController {
  private final EventService eventService;

  public WebController(EventService eventService) {
    this.eventService = eventService;
  }


  @GetMapping("/")
  public String index(){
    return "index";
  }
  @GetMapping("/home")
  public String home(Authentication authentication, Model m){
    User user = (User) authentication.getPrincipal();
    Long userId = user.getId();
    List<EventDto> userEvents= eventService.getUserEvents(userId);
    m.addAttribute("events", userEvents);
    m.addAttribute( "username",user.getName());
    return "home";
  }
  @GetMapping("/joinEvent")
  public String joinEvent(Model m, UsernamePasswordAuthenticationToken token){
    List<EventDto> events =  eventService.getJoinableEvents(token.getName());
    m.addAttribute("events",events);
    return "eventPages/joinEvent";
  }

  @GetMapping("/createEvent")
  public String createEvent(Model model){
    model.addAttribute("eventForm",new EventForm(null,null,null,null,null) );
    return "eventPages/createEvent";
  }

  @PostMapping("/createEvent")
  public String createEvent(@ModelAttribute("eventForm") EventForm eventForm, UsernamePasswordAuthenticationToken token ) throws
      IOException {
    Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, eventForm.kitchenImage().getOriginalFilename());
    Files.write(fileNameAndPath,eventForm.kitchenImage().getBytes());
    Event createdEvent = Event.of(eventForm ,token.getName());
    Long id = eventService.saveEvent(createdEvent);
    return "redirect:/event/" + id + "/addRecipe";
  }
  @GetMapping("/event/{eventId}/addRecipe")
  public String addRecipe(@PathVariable("eventId") Long eventId, Model m){
    m.addAttribute("recipeForm", new RecipeForm(null, null, new ArrayList<>(),null, null));
    m.addAttribute("eventId",eventId);
    return "recipePages/addRecipe";
  }
  @PostMapping("/event/{eventId}/addRecipe")
  public String addRecipe(@PathVariable("eventId") Long eventId, Model m, @ModelAttribute("recipeForm") RecipeForm recipeForm, UsernamePasswordAuthenticationToken token)
      throws IOException {
    Event event = eventService.findEventbyId(eventId);
    Path fileNameAndPath = Paths.get(UPLOAD_DIRECTORY, recipeForm.image().getOriginalFilename());
    Files.write(fileNameAndPath,recipeForm.image().getBytes());
    event.addRecipe(token.getName(), recipeForm);
    return "redirect:/home";
  }
  @GetMapping("event/{eventId}")
  public String event( @PathVariable Long eventId, Model m, UsernamePasswordAuthenticationToken token){
    Event event = eventService.findEventbyId(eventId);
    List<RecipeDto> recipes= event.getRecipes();
    m.addAttribute("recipes", recipes);
    m.addAttribute("event", new EventDto(event));
    m.addAttribute("showJoinEvent", DisplayService.showJoinEvent( event,token));
    return "eventPages/event";
  }

  @PostMapping("event/{eventId}/joinEvent")
  public String joinEvent(@PathVariable("eventId") Long id, UsernamePasswordAuthenticationToken token){
    Event event = eventService.findEventbyId(id);
    event.addParticipant(token.getName());
    return "redirect:/event/"+id+"/addRecipe";
  }

}
