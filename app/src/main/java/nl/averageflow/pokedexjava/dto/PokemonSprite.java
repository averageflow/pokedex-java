package nl.averageflow.pokedexjava.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PokemonSprite {
    @JsonProperty(value="front_default")
    private String frontDefault;

    @JsonProperty(value="front_shiny")
    private String frontShiny;

    @JsonProperty(value="front_female")
    private String frontFemale;

    @JsonProperty(value="front_shiny_female")
    private String frontShinyFemale;

    @JsonProperty(value="back_default")
    private String backDefault;

    @JsonProperty(value="back_shiny")
    private String backShiny;

    @JsonProperty(value="back_female")
    private String backFemale;

    @JsonProperty(value="back_shiny_female")
    private String backShinyFemale;

    public String getFrontDefault() {
        return frontDefault;
    }

    public String getFrontShiny() {
        return frontShiny;
    }

    public String getFrontFemale() {
        return frontFemale;
    }

    public String getFrontShinyFemale() {
        return frontShinyFemale;
    }

    public String getBackDefault() {
        return backDefault;
    }

    public String getBackShiny() {
        return backShiny;
    }

    public String getBackFemale() {
        return backFemale;
    }

    public String getBackShinyFemale() {
        return backShinyFemale;
    }

    public PokemonSprite(){}
}
