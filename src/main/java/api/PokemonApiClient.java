package api;

import models.Description;
import models.PokedexResponse;
import models.Pokemon;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import utilities.Constants;
import utilities.Utils;

import java.io.IOException;
import java.util.List;

public class PokemonApiClient {
    private static final OkHttpClient client = new OkHttpClient();
    private static String regionName = "";
    private static String regionDescription = "";

    public static Pokemon getPokemon(String nameOrId) throws IOException {
        String url = Constants.POKEMON_URL + nameOrId.toLowerCase();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            String responseBody = response.body().string();
            return Utils.parsePokemon(responseBody);
        }
    }

    public static List<Pokemon> getPokemonByGeneration(int generation) throws IOException {
        List<Pokemon> pokemonList;

        String url = Constants.POKEDEX_URL + (generation +1);
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            String responseBody = response.body().string();

            final PokedexResponse pokedexResponse = Utils.parseResponseBody(responseBody);
            setRegionValues(pokedexResponse);
            pokemonList = Utils.parsePokedexResponse(pokedexResponse);

        } catch (IOException ioException) {
            System.out.println(ioException.getLocalizedMessage());
            throw ioException;
        }

        return pokemonList;
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
        // TODO eliminar syso cuando sea prescindible
        System.out.println(regionName);
        System.out.println(regionDescription);
    }

}
