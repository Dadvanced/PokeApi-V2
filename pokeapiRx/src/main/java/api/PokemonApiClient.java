package api;

import com.google.gson.Gson;
import models.Description;
import models.PokedexResponse;
import models.Pokemon;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utilities.Constants;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class PokemonApiClient {
    private static final OkHttpClient client = new OkHttpClient();
    private static final Gson gson = new Gson();
    private static String regionName = "";
    private static String regionDescription = "";

    public static Pokemon getPokemon(String nameOrId) throws IOException {
        String url = Constants.BASE_URL + Constants.POKEMON_URL + nameOrId.toLowerCase();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            String responseBody = response.body().string();
            return parsePokemon(responseBody);
        }
    }

    public static List<Pokemon> getPokemonByGeneration(int generation) throws IOException {
        List<Pokemon> pokemonList;

        String url = Constants.BASE_URL + Constants.POKEDEX_URL + (generation +1);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            String responseBody = response.body().string();

            PokedexResponse pokedexResponse = gson.fromJson(responseBody, PokedexResponse.class);
            System.out.println(responseBody);

            // Get the name and description for the region in spanish
            setRegionValues(pokedexResponse);

            // parse the pokedex response to pokemon list
            pokemonList = parsePokedexResponse(pokedexResponse);

        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
            throw ioException;
        }

        return pokemonList;
    }

    private static Pokemon parsePokemon(String json) {
        return gson.fromJson(json, Pokemon.class);
    }

    /**
     * maps the pokedexResponse to pokemon list
     * @param pokedexResponse
     * @return
     */
    private static List<Pokemon> parsePokedexResponse(PokedexResponse pokedexResponse) {
        return pokedexResponse.getPokemonEntries().stream()
                .map(entry -> new Pokemon(entry.getEntryNumber(), entry.getPokemonSpecies().getName()))
                .collect(Collectors.toList());
    }

    /**
     * Set the name and description for the region in spanish
     * @param pokedexResponse
     */
    private static void setRegionValues(PokedexResponse pokedexResponse) {
        for (Description description : pokedexResponse.getDescriptions()) {
            if ("es".equals(description.getLanguage().getName())) {
                regionName = description.getLanguage().getName();
                regionDescription = description.getDescription();
                break;
            }
        }
        System.out.println(regionName);
        System.out.println(regionDescription);
    }

}