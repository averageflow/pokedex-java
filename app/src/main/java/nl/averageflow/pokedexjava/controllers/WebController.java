package nl.averageflow.pokedexjava.controllers;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping({"/", "index"})
    public String index(Model model){
        model.addAttribute("myAttribute", "myAttributeValue");
        return "index";
    }
}
