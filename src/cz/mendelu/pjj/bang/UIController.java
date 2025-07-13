package cz.mendelu.pjj.bang;

import cz.mendelu.pjj.bang.bangcards.Role;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * @author xdostal
 */
public class UIController implements Initializable {
    @FXML
    Label LBconsole;
    @FXML
    ImageView IVdiscard;
    @FXML
    ImageView IVdeck;
    @FXML
    ImageView IVclass_card;
    @FXML
    ImageView IVchar_card;
    @FXML
    Label Lname, Lhealth;
    @FXML
    Label Lenemy_name, Lenemy_health;
    @FXML
    ImageView IVb1, IVb2, IVb3, IVb4, IVb5, IVb6, IVb7;
    @FXML
    ArrayList<ImageView> IVblueCards = new ArrayList<>();
    @FXML
    ImageView IVbr1, IVbr2, IVbr3, IVbr4, IVbr5, IVbr6, IVbr7;
    @FXML
    List<ImageView> IVbrownCards = new ArrayList<>();
    @FXML
    ImageView IVenemy_class_card, IVenemy_char_card;
    @FXML
    ImageView IVenemy_br1, IVenemy_br2, IVenemy_br3, IVenemy_br4, IVenemy_br5, IVenemy_br6, IVenemy_br7, IVenemy_br8;
    @FXML
    ImageView IVenemy_b1, IVenemy_b2, IVenemy_b3, IVenemy_b4, IVenemy_b5, IVenemy_b6, IVenemy_b7, IVenemy_b8;
    @FXML
    List<ImageView> IVenemyBrownCards = new ArrayList<>();
    @FXML
    List<ImageView> IVenemyBlueCards = new ArrayList<>();

    /**
     * Initializes the fxml
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Bang.main();
        IVblueCards.add(IVb1);
        IVblueCards.add(IVb2);
        IVblueCards.add(IVb3);
        IVblueCards.add(IVb4);
        IVblueCards.add(IVb5);
        IVblueCards.add(IVb6);
        IVblueCards.add(IVb7);
        IVbrownCards.add(IVbr1);
        IVbrownCards.add(IVbr2);
        IVbrownCards.add(IVbr3);
        IVbrownCards.add(IVbr4);
        IVbrownCards.add(IVbr5);
        IVbrownCards.add(IVbr6);
        IVbrownCards.add(IVbr7);
        IVenemyBrownCards.add(IVenemy_br1);
        IVenemyBrownCards.add(IVenemy_br2);
        IVenemyBrownCards.add(IVenemy_br3);
        IVenemyBrownCards.add(IVenemy_br4);
        IVenemyBrownCards.add(IVenemy_br5);
        IVenemyBrownCards.add(IVenemy_br6);
        IVenemyBrownCards.add(IVenemy_br7);
        IVenemyBrownCards.add(IVenemy_br8);
        IVenemyBlueCards.add(IVenemy_b1);
        IVenemyBlueCards.add(IVenemy_b2);
        IVenemyBlueCards.add(IVenemy_b3);
        IVenemyBlueCards.add(IVenemy_b4);
        IVenemyBlueCards.add(IVenemy_b5);
        IVenemyBlueCards.add(IVenemy_b6);
        IVenemyBlueCards.add(IVenemy_b7);
        IVenemyBlueCards.add(IVenemy_b8);
        IVdeck.setImage(new Image("./resources/UI/back_card.png"));
        IVdiscard.setImage(new Image("./resources/UI/back_card.png"));
        display();
    }

    /**
     * Method that is used to end the current round
     */

    public void nextRound() {
        Bang.endTurn();
        display();
    }

    /**
     * Displays the current state of the Bang! game
     */
    private void display() {
        if (Bang.getDiscard() != null && Bang.getDiscard().size() != 0) {
            IVdiscard.setImage(new Image(Bang.getDiscard().top().getImgPath()));
        }
        displayCurrentPlayer(Bang.getCurrentPlayer());
        displayOtherPlayer(Bang.getDisplayedOtherPlayer());
    }

    /**
     * Changes the other displayed player to the next in the list
     */
    public void nextPlayer() {
        Bang.setDisplayedOtherPlayer(Bang.nextPlayer(Bang.getDisplayedOtherPlayer()));
        if (Bang.getCurrentPlayer().equals(Bang.getDisplayedOtherPlayer())) {
            Bang.setDisplayedOtherPlayer(Bang.nextPlayer(Bang.getDisplayedOtherPlayer()));
        }
        display();
    }

    /**
     * Displays the current player from the Bang! file
     */
    private void displayCurrentPlayer(Player player) {
        IVchar_card.setImage(new Image(player.getCharacter().getImgPath()));
        IVclass_card.setImage(new Image(player.getRole().getImgPath()));
        Lname.setText(player.getName());
        Lhealth.setText(String.valueOf(player.getLifePoints()));
        int brSize = player.hand().size();
        for (int i = 0; i < brSize; i++) {
            IVbrownCards.get(i).setImage(new Image(player.getHand().getHand().get(i).getImgPath()));
        }
        if (brSize < 7) {
            for (int i = brSize; i < 7; i++) {
                IVbrownCards.get(i).setImage(null);
            }
        }
        int blSize = player.getCardsInPlay().size();
        for (int i = 0; i < blSize; i++) {
            IVblueCards.get(i).setImage(new Image(player.getCardsInPlay().get(i).getImgPath()));
        }
        if (blSize < 7) {
            for (int i = blSize; i < 7; i++) {
                IVblueCards.get(i).setImage(null);
            }
        }
    }

    /**
     * Displays the currently displayed other player from the Bang! file
     */
    private void displayOtherPlayer(Player player) {
        IVenemy_char_card.setImage(new Image(player.getCharacter().getImgPath()));
        if (player.getRole().role().equals(Role.SHERIFF)) {
            IVenemy_class_card.setImage(new Image(player.getRole().getImgPath()));
        } else {
            IVenemy_class_card.setImage(new Image("./resources/UI/back_card.png"));
        }
        Lenemy_name.setText(player.getName());
        Lenemy_health.setText(String.valueOf(player.getLifePoints()));
        int brSize = player.hand().size();
        for (int i = 0; i < brSize; i++) {
            //IVenemyBrownCards.get(i).setImage(new Image(player.getHand().getHand().get(i).getImgPath()));
            IVenemyBrownCards.get(i).setImage(new Image("./resources/UI/back_card.png"));
        }
        if (brSize < 7) {
            for (int i = brSize; i < 7; i++) {
                IVenemyBrownCards.get(i).setImage(null);
            }
        }
        int blSize = player.getCardsInPlay().size();
        for (int i = 0; i < blSize; i++) {
            IVenemyBlueCards.get(i).setImage(new Image(player.getCardsInPlay().get(i).getImgPath()));
        }
        if (blSize < 7) {
            for (int i = blSize; i < 7; i++) {
                IVenemyBlueCards.get(i).setImage(null);
            }
        }
    }

    /**
     * Displays character's information when hovered over the current player's character card
     */
    @FXML
    void hoverCharCard(MouseEvent event) {
        String info;
        ImageView iv = (ImageView) event.getSource();
        if (iv.getId().equals("IVchar_card")) {
            info = Bang.getCurrentPlayer().character().description();
        } else {
            info = Bang.getDisplayedOtherPlayer().character().description();
        }

        updateConsole(info);
    }

    /**
     * Displays class information when hovered over the current player's class card
     */
    @FXML
    void hoverClassCard(MouseEvent event) {
        String info;
        ImageView iv = (ImageView) event.getSource();
        if (iv.getId().equals("IVclass_card")) {
            info = Bang.getCurrentPlayer().role().description();
        } else {
            info = Bang.getDisplayedOtherPlayer().role().description();
        }
        updateConsole(info);
    }

    /**
     * Determines, which mouse button was used to click a playable card and takes an according action
     */
    @FXML
    public void buttonClicked(MouseEvent event) throws IOException {
        switch (event.getButton()) {
            case PRIMARY -> //Left button
                    useCard(event);
            case SECONDARY -> //Right button
                    useCardSecondarily(event);
            case MIDDLE -> discardCard(event); //Middle button
            default -> {
            }
            //Ignore
        }
    }

    /**
     * Uses a card by its secondary action (Panic!, Cat Balou!)
     */
    private void useCardSecondarily(MouseEvent event) throws IOException {
        ImageView iv = (ImageView) event.getSource();
        String id = iv.getId();
        // Extract the index from the string
        String indexString = id.substring(id.length() - 1);
        int index = Integer.parseInt(indexString) - 1;
        // Check if the string is in the format "IVb" (or IVbr)
        if (id.matches("IVb\\d+")) {
            Bang.play(Bang.getCurrentPlayer(), Bang.getCurrentPlayer().takeCard(index), true);
        } else {
            Bang.play(Bang.getCurrentPlayer(), Bang.getCurrentPlayer().hand().take(index), true);
        }
        display();
    }

    /**
     * Uses a card by its primary action
     */
    public void useCard(MouseEvent event) throws IOException {
        ImageView iv = (ImageView) event.getSource();
        String id = iv.getId();
        // Extract the index from the string
        String indexString = id.substring(id.length() - 1);
        int index = Integer.parseInt(indexString) - 1;
        // Check if the string is in the format "IVb" (or IVbr)
        if (id.matches("IVb\\d+")) {
            Bang.play(Bang.getCurrentPlayer(), Bang.getCurrentPlayer().takeCard(index), false);
        } else {
            Bang.play(Bang.getCurrentPlayer(), Bang.getCurrentPlayer().hand().take(index), false);
        }
        display();
    }

    /**
     * Discards a card clicked by the middle mouse button
     */
    public void discardCard(MouseEvent event) {
        ImageView iv = (ImageView) event.getSource();
        String id = iv.getId();
        // Extract the index from the string
        String indexString = id.substring(id.length() - 1);
        int index = Integer.parseInt(indexString) - 1;
        // Check if the string is in the format "IVb" (or IVbr)
        if (id.matches("IVb\\d+")) {
            Bang.discardCardOnTable(index);
        } else {
            Bang.discardCardInHand(index);
        }
        display();
    }

    /**
     * Shows information on how to use playable cards
     */
    public void showInfo() {
        updateConsole("Levé tlaèítko pro primární zahrání karty,\npravé tlaèítko pro sekundární (u Paniky a Cat Balou vybere náhodnou kartu z ruky)\n, prostøední pro vyhození karty");
    }

    /**
     * Updates in-game console
     */
    public void updateConsole(String text) {
        LBconsole.setText(text);
    }
}
