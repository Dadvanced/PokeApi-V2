import controllers.PokemonGUIController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.util.Objects;

public class PokemonGUI extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Pokedex-vanced");

        // Load FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pokemonGUI.fxml"));
        Parent root = loader.load();

        // Get controller
        PokemonGUIController controller = loader.getController();
        controller.setStage(primaryStage);

        // Show scene
        Scene scene = new Scene(root, 1200, 800);
        scene.getStylesheets().add(Objects.requireNonNull(getClass().getResource("styles.css")).toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set icon
        primaryStage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/pokeball.png"))));
    }

}
