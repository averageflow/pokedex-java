package nl.averageflow.pokedexjava;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SuppressWarnings({"UtilityClassCanBeEnum", "NonFinalUtilityClass"})
@SpringBootApplication
public class PokedexApplication {

    public static void main(final String[] args) {
        SpringApplication.run(PokedexApplication.class, args);
    }

}
