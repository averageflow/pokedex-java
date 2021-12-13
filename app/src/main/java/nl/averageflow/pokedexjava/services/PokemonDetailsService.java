package nl.averageflow.pokedexjava.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import nl.averageflow.pokedexjava.dto.PokedexList;
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

    public PokedexList getPokedexEntries() throws ExecutionException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://pokeapi.co/api/v2/pokemon/"))
                .timeout(Duration.ofMinutes(2))
                .header("Content-Type", "application/json")
                //.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                .GET()
                .build();

        CompletableFuture<String> responseBody = client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body);
        //.thenAccept(System.out::println);

        String pokeList = responseBody.get();

        final ObjectMapper objectMapper = new ObjectMapper();

        PokedexList pokedexList = null;

        try {
            pokedexList = objectMapper.readValue(pokeList, PokedexList.class);
        } catch (final Exception e) {
            System.out.println(e);
        }


        assert pokedexList != null;
        return pokedexList;
    }

    public Iterable<String> getPokedexEntryDetails(Iterable<String> urls){
        HttpClient client = HttpClient.newHttpClient();
        List<CompletableFuture<String>> futuresList = StreamSupport.stream(urls.spliterator(), true).map(url -> {
            HttpRequest pokedexListItemRequest = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .timeout(Duration.ofMinutes(2))
                    .header("Content-Type", "application/json")
                    //.POST(HttpRequest.BodyPublishers.ofFile(Paths.get("file.json")))
                    .GET()
                    .build();

            return client.sendAsync(pokedexListItemRequest, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body);
        }).toList();

        Iterable<String> test = futuresList.stream().map(CompletableFuture::join).collect(Collectors.toList());
        return test;
    }
}
