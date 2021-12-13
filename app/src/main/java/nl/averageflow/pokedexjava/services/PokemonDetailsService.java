package nl.averageflow.pokedexjava.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.averageflow.pokedexjava.dto.PokedexList;
import nl.averageflow.pokedexjava.dto.Pokemon;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PokemonDetailsService {

    public static PokedexList getPokedexEntries() throws ExecutionException, InterruptedException {
        final HttpClient client = HttpClient.newHttpClient();
        final HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/?limit=20"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                .GET()
                .build();

        final CompletableFuture<String> responseBody = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);

        final String pokeList = responseBody.get();
        final ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readValue(pokeList, PokedexList.class);
        } catch (final Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public static Iterable<Pokemon> getPokedexEntryDetails(final Iterable<String> urls) {
        final HttpClient client = HttpClient.newHttpClient();
        final List<CompletableFuture<String>> futuresList = StreamSupport.stream(urls.spliterator(), true).map(url -> {
            final HttpRequest pokedexListItemRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofMinutes(2))
                    .header("Content-Type", "application/json")
                    .GET()
                    .build();

            return client.sendAsync(pokedexListItemRequest, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body);
        }).toList();

        final Iterable<String> responseBodies = futuresList.stream().map(CompletableFuture::join).collect(Collectors.toList());

        final ObjectMapper objectMapper = new ObjectMapper();

        return StreamSupport.stream(responseBodies.spliterator(), true).map(item -> {
            try {
                return objectMapper.readValue(item, Pokemon.class);
            } catch (final Exception e) {
                System.out.println(e);
            }

            return null;
        }).toList();
    }
}
