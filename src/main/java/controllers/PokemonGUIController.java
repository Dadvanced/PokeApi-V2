package controllers;

import api.PokemonApiClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import models.Pokemon;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class PokemonGUIController implements Initializable {
    private static final Logger logger = LoggerFactory.getLogger(PokemonApiClient.class);

    @FXML
    private Button searchButton;

    @FXML
    private Button gen1Button;

    @FXML
    private Button gen2Button;

    @FXML
    private TextField searchField;

    @FXML
    private Label idLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private ImageView pkmImageField;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private ListView<Pokemon> pokemonListView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        pokemonListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                try {
                    Pokemon pokemon = PokemonApiClient.getPokemon(newValue.getName());
                    updatePokemonInfo(pokemon);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        searchField.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                searchButton.fire();
            }
        });

        // Search first 151 pokemons
        gen1Button.setOnAction(event -> {
            loadPokemonList(1);
            disableGenButtons(true);
        });

        // Search 151 pokemons for second generation
        gen2Button.setOnAction(event -> {
            loadPokemonList(2);
            disableGenButtons(false);
        });

        // Search any pokemon by name or id
        searchButton.setOnAction(actionEvent -> {
            disableGenButtons(false);
            try {
                searchPokemon();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    private void loadPokemonList(int generation) {
        try {
            List<Pokemon> pokemonList = PokemonApiClient.getPokemonByGeneration(generation);
            ObservableList<Pokemon> observableList = FXCollections.observableArrayList(pokemonList);

            pokemonListView.setItems(observableList);

        } catch (IOException e) {
            logger.error(e.getLocalizedMessage());            ;
        }
    }

    @FXML
    private void searchPokemon() throws IOException {
        String pokemonName = searchField.getText();
        Pokemon pokemon = PokemonApiClient.getPokemon(pokemonName);

        if (pokemon != null) {
            updatePokemonInfo(pokemon);
        } else {
            idLabel.setText("Pokemon not found");
            nameLabel.setText("");
        }
    }

    private void updatePokemonInfo(Pokemon pokemon) {
        logger.info("UPDATE POKEMON");
        logger.info(pokemon.toString());

        // Update user interface with the pokemon information
        idLabel.setText(String.valueOf(pokemon.getId()));
        nameLabel.setText(pokemon.getName());

        // Actualizar otras etiquetas con más información del Pokémon (vida, ataque, defensa, etc.)
        // Por ejemplo:
        // healthLabel.setText("Health: " + pokemon.getHealth());
        // attackLabel.setText("Attack: " + pokemon.getAttack());
        // defenseLabel.setText("Defense: " + pokemon.getDefense());

        pkmImageField.setImage(new Image(pokemon.getSprites().getOther().getShowdown().getFrontDefault()));
    }

    private void disableGenButtons(boolean disableGen1) {
        gen1Button.setDisable(disableGen1);
        gen2Button.setDisable(!disableGen1);
    }
}
