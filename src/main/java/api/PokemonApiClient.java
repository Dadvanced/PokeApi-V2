package api;

import models.PokedexResponse;
import models.pokemon.Pokemon;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import utilities.Constants;
import utilities.Utils;

import java.io.IOException;
import java.util.List;

public class PokemonApiClient {
    private static final Logger logger = LoggerFactory.getLogger(PokemonApiClient.class);


    private static final OkHttpClient client = new OkHttpClient();

    // Get Pokemon by name or id (e.g. celebi || 300)
    public static Pokemon getPokemon(String nameOrId) throws IOException {
        String url = Constants.POKEMON_URL + nameOrId.toLowerCase();
        Request request = new Request.Builder()
                .url(url)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (!response.isSuccessful()) throw new IOException("Unexpected code " + response);

            assert response.body() != null;
            String responseBody = response.body().string();
            //logger.info(responseBody);
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
            pokemonList = Utils.parsePokedexResponse(pokedexResponse);

        } catch (IOException ioException) {
            logger.error(ioException.getLocalizedMessage());
            throw ioException;
        }

        return pokemonList;
    }
}
