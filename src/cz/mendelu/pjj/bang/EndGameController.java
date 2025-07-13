package cz.mendelu.pjj.bang;

import cz.mendelu.pjj.bang.bangcards.Role;
import cz.mendelu.pjj.bang.bangcards.RoleImage;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author xdostal
 */
public class EndGameController implements Initializable {
    @FXML
    Button BTnew_game;
    @FXML
    Label LBwinner;

    @FXML
    ImageView IVwinner_card;

    /**
     * Exits the game
     */
    @FXML
    private void exitGame() {
        System.exit(0);
    }

    /**
     * Displays winner message
     */
    @FXML
    private void displayWinnerMessage(String text) {
        LBwinner.setText(text);
    }

    /**
     * Displays winner role image based on the path
     */
    @FXML
    private void displayWinnerImage(Role role) {
        RoleImage path = RoleImage.valueOf(role.toString());
        IVwinner_card.setImage(new Image(path.getPath()));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        displayWinnerMessage(Bang.getWinMessage());
        displayWinnerImage(Bang.getWinner());
    }
}

