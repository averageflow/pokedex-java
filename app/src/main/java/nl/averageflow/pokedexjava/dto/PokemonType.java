package nl.averageflow.pokedexjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonType {
    private String name;

    public String getName() {
        return name;
    }

    public PokemonType(){}
}
