package cz.mendelu.pjj.bang;

import cz.mendelu.pjj.bang.bangcards.Role;

import static org.junit.Assert.*;

public class BangTest {
    /**
     * Prepares the Bang! class for testing
     **/
    @org.junit.Before
    public void setUp() {
        Bang.main();
    }

    /**
     * Tests, whether the game was correctly setup
     **/
    @org.junit.Test
    public void setupGame() {
        //4 players //todo
        assertEquals(Bang.getPlayers().size(), 4);
        //sheriff starts the game
        assertEquals(Bang.getCurrentPlayer().getRole().role(), Role.SHERIFF);
        //no cards in the discard pile
        assertEquals(Bang.getDiscard().size(), 0);
    }

    /**
     * Asserts that nextPlayer method indexes through all players in order
     **/
    @org.junit.Test
    public void nextPlayer() {
        Player startPlayer = Bang.getCurrentPlayer();
        Player curPlayer = Bang.getCurrentPlayer();
        System.out.println(curPlayer);
        for (int i = 0; i < Bang.getPlayers().size(); i++) {
            curPlayer = Bang.nextPlayer(curPlayer);
        }
        assertTrue(startPlayer == curPlayer);
    }

    /**
     * Asserts that this method discards just one card in hand
     **/
    @org.junit.Test
    public void discardCardInHand() {
        Player p = Bang.getCurrentPlayer();
        int sizeOnTableBefore = p.getCardsInPlay().size();
        int sizeInHandBefore = p.getHand().size();
        Bang.discardCardInHand(1);
        int sizeOnTableAfter = p.getCardsInPlay().size();
        int sizeInHandAfter = p.getHand().size();
        System.out.println(sizeInHandBefore);
        System.out.println(sizeInHandAfter);
        assertFalse(sizeInHandBefore == sizeInHandAfter);
        assertTrue(sizeOnTableBefore == sizeOnTableAfter);
    }
}