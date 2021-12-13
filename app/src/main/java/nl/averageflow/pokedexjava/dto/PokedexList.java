package nl.averageflow.pokedexjava.dto;

public class PokedexList {

    private Iterable<PokedexListItem> results;

    private Integer count;

    private String next;
    private String previous;

    public PokedexList() {

    }

    public Iterable<PokedexListItem> getResults() {
        return results;
    }

    public Integer getCount() {
        return count;
    }

    public String getPrevious() {
        return previous;
    }

    public String getNext() {
        return next;
    }
}
