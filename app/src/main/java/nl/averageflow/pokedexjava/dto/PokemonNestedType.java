package nl.averageflow.pokedexjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonNestedType {
    private PokemonType type;

    public PokemonNestedType(){

    }

    public PokemonType getType() {
        return type;
    }
}
