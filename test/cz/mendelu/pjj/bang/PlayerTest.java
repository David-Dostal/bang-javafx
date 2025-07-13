package cz.mendelu.pjj.bang;

import cz.mendelu.pjj.bang.cards.Suit;
import cz.mendelu.pjj.bang.cards.Value;
import cz.mendelu.pjj.bang.bangcards.Brown;
import cz.mendelu.pjj.bang.bangcards.BrownCard;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class PlayerTest {
    /**
     * Prepares the Bang! class for testing
     **/
    @org.junit.Before
    public void setUp() {
        Bang.main();
    }

    /**
     * Asserts, that taking cards from hand takes correct amount of cards
     **/
    @org.junit.Test
    public void takeAllCardsFromPlay() {
        int size = Bang.getCurrentPlayer().getCardsInPlay().size();
        assertTrue(size == Bang.getCurrentPlayer().takeAllCardsFromPlay().size());
        assertTrue(Bang.getCurrentPlayer().getCardsInPlay().size() == 0);
    }

    /**
     * Asserts, that getLifePoints returns the actual amount of lives, and also tests the Bang. Play method
     * when a Bang! card is played
     **/
    @Test
    public void getLifePoints() throws IOException {
        int startingPoints = Bang.getDisplayedOtherPlayer().getLifePoints();
        Bang.getDisplayedOtherPlayer().takeAllCardsFromHand();
        Bang.play(Bang.getCurrentPlayer(), new BrownCard(Brown.BANG, Value.TEN, Suit.DIAMONDS), false);
        assertTrue(Bang.getDisplayedOtherPlayer().getLifePoints() == startingPoints - 1);
    }
}