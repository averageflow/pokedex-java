package nl.averageflow.pokedexjava.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.averageflow.pokedexjava.dto.PokedexList;
import nl.averageflow.pokedexjava.dto.PokedexListItem;
import nl.averageflow.pokedexjava.dto.Pokemon;
import nl.averageflow.pokedexjava.services.PokemonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.FileNotFoundException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.file.Paths;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class WebController {

    @Autowired
    private PokemonDetailsService pokemonDetailsService;

    @GetMapping(value = "/")
    public String index(Model model) throws ExecutionException, InterruptedException {
        PokedexList urls = this.pokemonDetailsService.getPokedexEntries();
        Iterable<Pokemon> pokeData = this.pokemonDetailsService.getPokedexEntryDetails(
                StreamSupport.stream(urls.getResults().spliterator(), false)
                        .map(PokedexListItem::getUrl).collect(Collectors.toList())
        );

        model.addAttribute("myAttribute", "myAttributeValue");
        model.addAttribute("pokeData", pokeData);

        return "index";
    }
}
