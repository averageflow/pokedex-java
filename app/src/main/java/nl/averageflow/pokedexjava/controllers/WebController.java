package nl.averageflow.pokedexjava.controllers;

import nl.averageflow.pokedexjava.dto.PokedexList;
import nl.averageflow.pokedexjava.dto.PokedexListItem;
import nl.averageflow.pokedexjava.dto.Pokemon;
import nl.averageflow.pokedexjava.services.PokemonDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class WebController {

    @GetMapping(value = "/")
    public String index(final Model model) throws ExecutionException, InterruptedException {
        final PokedexList urls = PokemonDetailsService.getPokedexEntries();

        assert urls != null;
        final Iterable<Pokemon> pokeData = PokemonDetailsService.getPokedexEntryDetails(
                StreamSupport.stream(urls.getResults().spliterator(), false)
                        .map(PokedexListItem::getUrl).collect(Collectors.toList())
        );

        model.addAttribute("pokeData", pokeData);

        return "index";
    }
}
