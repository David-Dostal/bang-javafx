package cz.mendelu.pjj.bang.cards;

/**
 * @author xdostal
 */

public class Card {

    private final Value value;
    private final Suit suit;
    private final String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    /**
     * Creates a card with a value and suit.
     *
     * @param value   value of card
     * @param suit    suit of card
     * @param imgPath path to the card's img
     */
    public Card(Value value, Suit suit, String imgPath) {
        this.value = value;
        this.suit = suit;
        this.imgPath = imgPath;
    }

    /**
     * Creates a card with just the imgPath.
     *
     * @param imgPath path to the card's img
     */
    public Card(String imgPath) {
        this.value = Value.NONE;
        this.suit = Suit.NONE;
        this.imgPath = imgPath;
    }

    /**
     * Gets the value of the card.
     *
     * @return value of card
     * @see Value
     */
    public Value value() {
        return value;
    }

    /**
     * Gets the suit of the card.
     *
     * @return suit of card
     * @see Suit
     */
    public Suit suit() {
        return suit;
    }

    @Override
    public String toString() {
        return value.name().toLowerCase() + " of " + suit.name().toLowerCase();
    }
}