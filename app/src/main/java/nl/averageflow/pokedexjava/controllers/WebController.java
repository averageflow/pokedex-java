package nl.averageflow.pokedexjava.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping(value = "/index")
    public String index(){
        return "index";
    }
}
