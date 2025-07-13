package cz.mendelu.pjj.bang.cards;

/**
 * @author xdostal
 */
public enum Value {
    NONE(0),
    TWO(2),
    THREE(3),
    FOUR(4),
    FIVE(5),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13),
    ACE(14),
    JOKER(15);

    /**
     * Integer value of card.
     */
    private final int value;

    /**
     * Sets the integer value of the card.
     *
     * @param value integer value of the card
     */
    Value(final int value) {
        this.value = value;
    }

    /**
     * Gets the integer value of the card.
     *
     * @return integer value of card
     */
    public int value() {
        return value > 10 ? (value == 14 ? 11 : (value == 15 ? -1 : 10)) : value;
    }
}
