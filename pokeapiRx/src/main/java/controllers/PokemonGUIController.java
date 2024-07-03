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
import javafx.stage.Stage;
import models.Pokemon;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class PokemonGUIController implements Initializable {

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
                updatePokemonInfo(newValue);
            }
        });

        gen1Button.setOnAction(event -> {
            loadPokemonList(1);
            disableGenButtons(true);
        });

        gen2Button.setOnAction(event -> {
            loadPokemonList(2);
            disableGenButtons(false);
        });

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
            e.printStackTrace();
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
        // Actualizar la interfaz de usuario con la información del Pokémon
        idLabel.setText(String.valueOf(pokemon.getId()));
        nameLabel.setText(pokemon.getName());
        // Actualizar otras etiquetas con más información del Pokémon (vida, ataque, defensa, etc.)
        // Por ejemplo:
        // healthLabel.setText("Health: " + pokemon.getHealth());
        // attackLabel.setText("Attack: " + pokemon.getAttack());
        // defenseLabel.setText("Defense: " + pokemon.getDefense());

        // Cargar la imagen del Pokémon en el ImageView correspondiente
        // Esto requeriría cargar la imagen desde la URL proporcionada por la API
        // imageView.setImage(new Image(pokemon.getImageUrl()));

        // Cargar el GIF del Pokémon en el WebView correspondiente
        // Esto requeriría cargar el GIF desde la URL proporcionada por la API
        // webView.getEngine().load(pokemon.getGifUrl());
    }

    private void disableGenButtons(boolean disableGen1) {
        gen1Button.setDisable(disableGen1);
        gen2Button.setDisable(!disableGen1);
    }
}
