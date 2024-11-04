package utilities;

import com.google.gson.Gson;
import models.PokedexResponse;
import models.pokemon.Pokemon;

import java.util.List;
import java.util.stream.Collectors;

public class Utils {
    private static final Gson gson = new Gson();

    public static PokedexResponse parseResponseBody(String responseBody) {
        return gson.fromJson(responseBody, PokedexResponse.class);
    }

    /**
     * parses JSON data to Pokemon class
     * @param json
     * @return
     */
    public static Pokemon parsePokemon(String json) {
        return gson.fromJson(json, Pokemon.class);
    }

    /**
     * Maps the pokedexResponse to Pokemon class list
     * @param pokedexResponse
     * @return
     */
    public static List<Pokemon> parsePokedexResponse(PokedexResponse pokedexResponse) {
        return pokedexResponse.getPokemonEntries().stream()
                .map(entry -> new Pokemon(entry.getEntryNumber(), entry.getPokemonSpecies().getName()))
                .collect(Collectors.toList());
    }

    public static String capitalizeFirstLetter(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}
