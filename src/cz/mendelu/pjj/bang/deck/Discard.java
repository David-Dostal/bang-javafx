package cz.mendelu.pjj.bang.deck;

import cz.mendelu.pjj.bang.cards.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xdostal
 */
public class Discard {
    /**
     * Contains a list of all the cards in the discard pile.
     */
    private final List<Card> discard;

    /**
     * Creates an empty discard pile.
     */
    public Discard() {
        discard = new ArrayList<>();
    }

    /**
     * Gets a value for the number of cards in the discard pile.
     *
     * @return size of discard pile
     */
    public int size() {
        return discard.size();
    }

    /**
     * Gets the top card of the discard pile without removing it.
     *
     * @return top card of discard pile
     */
    public Card top() {
        return discard.get(0);
    }

    /**
     * Gets the top numberOfCards cards of the discard pile without removing them.
     *
     * @param numberOfCards number of cards to get from top of discard pile
     * @return top number of cards of discard pile
     */
    public List<Card> top(int numberOfCards) {
        return discard.subList(0, numberOfCards);
    }

    /**
     * Add card to the top of the discard pile.
     *
     * @param card card to discard
     */
    public void add(Card card) {
        discard.add(0, card);
    }

    /**
     * Add cards to the top of the discard pile.
     *
     * @param cards cards to discard
     */
    public void add(List<Card> cards) {
        discard.addAll(0, cards);
    }

    /**
     * Add cards to the top of the discard pile with a certain card on top.
     *
     * @param cards   cards to discard
     * @param topCard index of card to place at top of discard pile
     */
    public void add(List<Card> cards, int topCard) {
        topCard = topCard >= cards.size() ? cards.size() - 1 : topCard;
        List<Card> rCards = cards.subList(topCard, cards.size());
        rCards.addAll(cards.subList(0, topCard));
        discard.addAll(0, cards);
    }
}