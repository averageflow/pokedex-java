package nl.averageflow.pokedexjava.dto;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Pokemon {
    private Integer id;

    private String name;

    @JsonProperty(value = "base_experience")
    private Integer baseExperience;

    // pokemon height in decimeters
    private Integer height;

    @JsonProperty(value = "is_default")
    private Boolean isDefault;

    private Integer order;

    // pokemon weight in hectograms
    private Integer weight;

    @JsonProperty(value = "location_area_encounters")
    private String locationAreaEncounters;

    private Iterable<PokemonNestedType> types;

    private PokemonSprite sprites;

    public String getLocationAreaEncounters() {
        return locationAreaEncounters;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getOrder() {
        return order;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getBaseExperience() {
        return baseExperience;
    }

    public String getName() {
        return name;
    }

    public Integer getId() {
        return id;
    }

    public PokemonSprite getSprites() {
        return sprites;
    }

    public Iterable<PokemonNestedType> getTypes() {
        return types;
    }


//    private List<?> abilities;
//
//    private List<?> forms;
//
//
//    @JsonProperty(value="game_indices")
//    private List<?> gameIndices;
//
//
//    @JsonProperty(value="held_items")
//    private List<?> heldItems;
//
//
//
//
//    private List<?> moves;
//
//
//    @JsonProperty(value="past_types")
//    private List<?> pastTypes;
//
//
//
//
//
//    private Any species;
//
//
//    private List<?> stats;
//
//
}
