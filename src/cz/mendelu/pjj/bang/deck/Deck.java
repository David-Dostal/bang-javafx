package cz.mendelu.pjj.bang.deck;

import cz.mendelu.pjj.bang.cards.Card;

import java.util.Collections;
import java.util.List;

/**
 * @author xdostal
 */
public class Deck {

    /**
     * Contains a list of all the cards in the deck.
     */
    private final List<Card> deck;

    /**
     * Creates a deck of cards.
     *
     * @param cards list of cards in initial deck
     */
    public Deck(List<Card> cards) {
        deck = cards;
    }

    /**
     * Draws the top card from the deck and removes it from the deck.
     *
     * @return top card of the deck
     */
    public Card draw() {
        return deck.remove(0);
    }

    /**
     * Adds a card to the top of the deck.
     *
     * @param card card to add to the top of the deck
     */
    public void add(Card card) {
        deck.add(0, card);
    }

    /**
     * Adds a list of cards to the top of the deck.
     *
     * @param cards list of cards to add to top of deck
     */
    public void add(List<Card> cards) {
        deck.addAll(0, cards);
    }

    /**
     * Randomly shuffles the entire deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Gets a value for the number of cards in the deck.
     *
     * @return size of deck
     */
    public int size() {
        return deck.size();
    }

    /**
     * Gets whether there are still cards in the deck.
     *
     * @return true if deck is empty, otherwise false
     */
    public boolean isEmpty() {
        return deck.isEmpty();
    }
}