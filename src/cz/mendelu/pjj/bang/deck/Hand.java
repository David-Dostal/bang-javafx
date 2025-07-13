package cz.mendelu.pjj.bang.deck;

import cz.mendelu.pjj.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xdostal
 */
public class Hand {

    /**
     * Contains a list of all the cards in the hand.
     */
    private final List<Card> hand;

    /**
     * Creates a new empty hand.
     */
    public Hand() {
        hand = new ArrayList<>();
    }

    /**
     * Gets a value for the number of cards in the hand.
     *
     * @return size of hand
     */
    public int size() {
        return hand.size();
    }

    public List<Card> getHand() {
        return hand;
    }

    /**
     * Adds a card to the hand.
     *
     * @param card card to add
     */
    public void add(Card card) {
        hand.add(card);
    }

    /**
     * Gets and removes all the cards from the hand.
     *
     * @return all cards in hand
     */
    public List<Card> takeAll() {
        List<Card> cards = new ArrayList<>(hand);
        hand.clear();
        return cards;
    }

    /**
     * Gets and removes a single card from the hand.
     *
     * @param index index of card in hand
     * @return removed card
     */
    public Card take(int index) {
        return index >= hand.size() ? null : hand.remove(index);
    }

    /**
     * Gets and removes a random card from the hand.
     *
     * @return removed card
     */
    public Card takeRandom() {
        return hand.isEmpty() ? null : hand.remove((int) (Math.random() * hand.size()));
    }
}