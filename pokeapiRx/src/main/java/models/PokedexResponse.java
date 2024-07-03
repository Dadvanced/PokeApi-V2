package models;

import java.util.List;

public class PokedexResponse {
    private List<PokemonEntry> pokemon_entries;
    private List<Description> descriptions;

    public List<PokemonEntry> getPokemonEntries() {
        return pokemon_entries;
    }

    public void setPokemonEntries(List<PokemonEntry> pokemon_entries) {
        this.pokemon_entries = pokemon_entries;
    }

    public List<PokemonEntry> getPokemon_entries() {
        return pokemon_entries;
    }

    public void setPokemon_entries(List<PokemonEntry> pokemon_entries) {
        this.pokemon_entries = pokemon_entries;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }
}
