package cz.mendelu.pjj.bang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author xdostal
 */
public class Main extends Application {
    /**
     * Initializes the stage
     */
    private static Stage mainStage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainStage = primaryStage;
        loadMainMenu();
    }

    /**
     * Loads main menu
     */
    public static void loadMainMenu() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("MainMenu.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        mainStage.setTitle("Bang! - Main menu");
        Scene scene = new Scene(root, 1024.0, 1024.0);
        mainStage.setScene(scene);
        mainStage.show();
    }

    /**
     * Loads UI
     */
    public static void loadUI() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("UI.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        mainStage.setTitle("Bang! - The game");
        Scene scene = new Scene(root, 1180, 850);

        mainStage.setScene(scene);
    }

    /**
     * Loads EndGame
     */
    public static void loadEndScreen() throws IOException {
        FXMLLoader loader = new FXMLLoader(Main.class.getResource("EndGame.fxml"));
        Parent root = loader.load();
        root.setId("pane");
        mainStage.setTitle("Bang! - End screen");
        Scene scene = new Scene(root, 600, 500);
        mainStage.setScene(scene);
        mainStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
