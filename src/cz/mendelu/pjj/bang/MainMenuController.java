package cz.mendelu.pjj.bang;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author xdostal
 */
public class MainMenuController implements Initializable {
    public Label chooseGameModeLB;
    @FXML
    private ChoiceBox<Integer> gameModeCB;
    /**
     * Contains game-modes
     */
    private final Integer[] gameModes = {4, 5, 6, 7};

    /**
     * User has to select a game mode
     */
    @FXML
    private void startGame() throws IOException {
        if (gameModeCB.getValue() != null) {
            Main.loadUI();
        } else {
            chooseGameModeLB.setText("Vyber poèet hráèù!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gameModeCB.getItems().addAll(gameModes);
    }
}

