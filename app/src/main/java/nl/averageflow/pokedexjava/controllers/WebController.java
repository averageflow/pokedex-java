package nl.averageflow.pokedexjava.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

//    @GetMapping(value = "/")
//    public String index(){
//
//        return "index";
//    }
    @GetMapping(value = "/")
    public String index(Model model){
        model.addAttribute("myAttribute", "myAttributeValue");
        return "index";
    }
}
