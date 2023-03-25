package com.example.prototyp.web;


import com.example.prototyp.domain.Event;
import com.example.prototyp.service.EventService;
import com.example.prototyp.web.forms.EventForm;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
  public String home(UsernamePasswordAuthenticationToken token, Model m){
    m.addAttribute( "username",token.getName());
    return "home";
  }
  @GetMapping("/joinEvent")
  public String joinEvent(){
    return "eventPages/joinEvent";
  }

  @GetMapping("/createEvent")
  public String createEvent(Model model){
    model.addAttribute("eventForm",new EventForm(null,null,null,null) );
    return "eventPages/createEvent";
  }

  @PostMapping("/createEvent")
  public String createEvent(@ModelAttribute("eventForm") EventForm eventForm, UsernamePasswordAuthenticationToken token ){
    Event createdEvent = Event.of(eventForm.date(), eventForm.numberOfParticipants(), token.getName(), eventForm.kitchenImage(), eventForm.kitchenAdress());
    Long id = eventService.saveEvent(createdEvent);
    return "redirect:/event/" + id + "/addRecipe";
  }
  @GetMapping("/event/{eventId}/addRecipe")
  public String createEvent(@PathVariable("eventId") Long eventId, Model m){
    m.addAttribute("eventId",eventId);
    m.addAttribute("recipeForm", new RecipeForm())
    return "recipePages/addRecipe";
  }

}
