package charbuilder.web;

import charbuilder.character.CharacterClass;
import charbuilder.character.CharacterInfo;
import java.util.Random;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@SessionAttributes({"user_name","user_adress"})
public class CreationController {


  @GetMapping("/")
  public String index() {
    return "start";
  }

  @GetMapping("/create/contact")
  public String createNameForm() {
    return "name";
  }

  @PostMapping("/contactdetails")
  public String createStep1(Model model, String user_name, String user_adress) {
    model.addAttribute("user_name", user_name);
    model.addAttribute("user_adress", user_adress);
    return "redirect:/";
  }

  @GetMapping("/create/2")
  public String createClassForm() {
    return "class";
  }

  @PostMapping("/create/2")
  public String createStep3(CharacterClass characterclass, @ModelAttribute("character") CharacterInfo characterInfo) {
    characterInfo.setCharacterClass(characterclass);
    return "redirect:/create/3";
  }

  @GetMapping("/create/3")
  public String createAttributeForm() {
    return "attributes";
  }

  @PostMapping("/create/3")
  public String createStep3(Model m,
                            @RequestParam("Strength") int str,
                            @RequestParam("Dexterity") int dex,
                            @RequestParam("Constitution") int con,
                            @RequestParam("Intelligence") int intl,
                            @RequestParam("Wisdom") int wis,
                            @RequestParam("Charisma") int cha,
                            @ModelAttribute("character") CharacterInfo characterInfo) {

    characterInfo.setAttribute("Strength", str);
    characterInfo.setAttribute("Dexterity", dex);
    characterInfo.setAttribute("Constitution", con);
    characterInfo.setAttribute("Intelligence", intl);
    characterInfo.setAttribute("Wisdom", wis);
    characterInfo.setAttribute("Charisma", cha);

    if(!characterInfo.isValid()){
        return "redirect:/create/3";
    }
    System.out.println(characterInfo.toString());
    // Character fertigstellen und validieren

    // Fehler: Formular wieder anzeigen, Werte müssen erhalten bleiben

    // Erfolg: Ausgabe der Spielerinformationen auf der Konsole und zurück zur Startseite

    return "redirect:/";
  }


}
