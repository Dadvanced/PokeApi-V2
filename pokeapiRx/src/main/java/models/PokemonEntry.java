package models;

public class PokemonEntry {
    private int entry_number;
    private PokemonSpecies pokemon_species;

    public int getEntryNumber() {
        return entry_number;
    }

    public void setEntryNumber(int entry_number) {
        this.entry_number = entry_number;
    }

    public PokemonSpecies getPokemonSpecies() {
        return pokemon_species;
    }

    public void setPokemonSpecies(PokemonSpecies pokemon_species) {
        this.pokemon_species = pokemon_species;
    }
}
