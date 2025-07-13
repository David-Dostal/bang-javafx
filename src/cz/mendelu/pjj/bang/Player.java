package cz.mendelu.pjj.bang;

import cz.mendelu.pjj.bang.bangcards.*;
import cz.mendelu.pjj.bang.cards.*;
import cz.mendelu.pjj.bang.deck.Hand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author xdostal
 */

public class Player {
    /**
     * Current life points of player
     */
    private int lifePoints;
    /**
     * Current cards in play for character
     */
    private final List<BlueCard> cardsInPlay;
    /**
     * Character card of player
     */
    private CharacterCard character;
    /**
     * Role card of player
     */
    private RoleCard role;
    /**
     * Current hand of player
     */
    private final Hand hand;
    /**
     * Name of player
     */
    private final String name;

    /**
     * Creates a new player.
     *
     * @param name name of player
     */
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
        this.cardsInPlay = new ArrayList<>();
    }

    /**
     * Gets current life points of player.
     *
     * @return current life points
     */
    public int lifePoints() {
        return lifePoints;
    }

    /**
     * Sets the character of player.
     *
     * @param character character card of player
     */
    public void setCharacter(CharacterCard character) {
        this.character = character;
        this.lifePoints = role.role() == Role.SHERIFF ? this.character.maxLifePoints() + 1 : this.character.maxLifePoints();
    }

    /**
     * Gets the character of player.
     *
     * @return character of player
     */
    public CharacterCard character() {
        return character;
    }

    /**
     * Gets the name of player.
     *
     * @return name of player
     */
    public String name() {
        return name;
    }

    /**
     * Sets the role card of player.
     *
     * @param role role card of player
     */
    public void setRole(RoleCard role) {
        this.role = role;
    }

    /**
     * Gets the role card of player.
     *
     * @return role card of player
     */
    public RoleCard role() {
        return role;
    }

    /**
     * Gets the hand of player.
     *
     * @return hand of player
     */
    public Hand hand() {
        return hand;
    }

    /**
     * Gets the gun of the player.
     *
     * @return gun of player, null if it doesn't exist
     */
    public BlueCard gun() {
        if (isInPlay(Blue.VOLCANIC))
            return getCard(Blue.VOLCANIC);
        else if (isInPlay(Blue.SCHOFIELD))
            return getCard(Blue.SCHOFIELD);
        else if (isInPlay(Blue.REMINGTON))
            return getCard(Blue.REMINGTON);
        else if (isInPlay(Blue.REV_CARBINE))
            return getCard(Blue.REV_CARBINE);
        else if (isInPlay(Blue.WINCHESTER))
            return getCard(Blue.WINCHESTER);
        return null;
    }

    /**
     * Gets whether player has scope in play.
     *
     * @return true if player has scope, otherwise false
     */
    public boolean hasScope() {
        return isInPlay(Blue.SCOPE);
    }

    /**
     * Gets whether player has mustang in play.
     *
     * @return true if player has mustang in play, otherwise false
     */
    public boolean hasMustang() {
        return isInPlay(Blue.MUSTANG);
    }

    /**
     * Gets whether player has barrel in play.
     *
     * @return true if player has barrel in play, otherwise false
     */
    public boolean hasBarrel() {
        return isInPlay(Blue.BARREL);
    }

    /**
     * Gets whether player is currently in jail.
     *
     * @return true if player is in jail, otherwise false
     */
    public boolean inJail() {
        return isInPlay(Blue.JAIL);
    }

    /**
     * Gets whether dynamite is on player.
     *
     * @return true if dynamite is on player, otherwise false
     */
    public boolean hasDynamite() {
        return isInPlay(Blue.DYNAMITE);
    }

    /**
     * Gets the range of the gun player has in play.
     *
     * @return range of gun, null if it doesn't exist
     */
    public int gunRange() {
        return gun() != null ? gun().range() : 1;
    }

    /**
     * Gets whether player is still in game.
     *
     * @return true if player is still in, otherwise false
     */
    public boolean isAlive() {
        return lifePoints <= 0;
    }

    /**
     * Reduces player's current life points by one.
     */
    public void loseLife() {
        lifePoints -= 1;
        isAlive();
    }

    /**
     * Reduces player's current life points by a certain amount.
     *
     * @param life life points to reduce from player
     */
    public void loseLife(int life) {
        lifePoints -= life;
        isAlive();
    }

    /**
     * Adds one life point to player's current amount.
     *
     * @return true if life point was gained, otherwise false
     */
    public boolean gainLife() {
        if (lifePoints < character.maxLifePoints() || (lifePoints == character.maxLifePoints() && role.role() == Role.SHERIFF)) {
            lifePoints += 1;
            return true;
        }
        return false;
    }

    /**
     * Gets and removes a blue card from play.
     *
     * @param card card in play to get and remove
     * @return blue card in play, null if it doesn't exist
     */
    public BlueCard takeCard(Blue card) {
        return getIndexOf(card) != -1 ? cardsInPlay.remove(getIndexOf(card)) : null;
    }

    /**
     * Gets and removes a blue card from play.
     *
     * @param index index of blue card in play
     * @return blue card in play, null if it doesn't exist
     */
    public BlueCard takeCard(int index) {
        return cardsInPlay.remove(index);
    }

    public BlueCard takeRandomCard() {
        Random rand = new Random();
        return cardsInPlay.remove(rand.nextInt(cardsInPlay.size()));
    }

    /**
     * Gets and removes all cards from play.
     *
     * @return all cards in play for player
     */
    public List<Card> takeAllCardsFromPlay() {
        List<Card> cards = new ArrayList<>(cardsInPlay);
        cardsInPlay.clear();
        return cards;
    }

    /**
     * Gets and removes all the cards from player's hand.
     *
     * @return all cards from player's hand
     */
    public List<Card> takeAllCardsFromHand() {
        return hand.takeAll();
    }

    /**
     * Add a blue card to play.
     *
     * @param card card to add to play
     * @return card that gets replaced, null if it doesn't exist
     */
    public Card addToPlay(BlueCard card) {
        if (!isInPlay(card.name())) {
            List<Blue> guns = new ArrayList<>(Arrays.asList(Blue.VOLCANIC, Blue.SCHOFIELD, Blue.REMINGTON, Blue.REV_CARBINE, Blue.WINCHESTER));
            if (guns.contains(card.name())) {
                BlueCard oldGun = gun();
                cardsInPlay.add(card);
                cardsInPlay.remove(oldGun);
                return oldGun;
            } else {
                cardsInPlay.add(card);
                return null;
            }
        }
        BlueCard oldCard = getCard(card.name());
        cardsInPlay.add(card);
        cardsInPlay.remove(oldCard);
        return oldCard;
    }

    /**
     * Gets a blue card in play.
     *
     * @param name name of blue card to get
     * @return blue card in play, null if it doesn't exist
     */
    private BlueCard getCard(Blue name) {
        return cardsInPlay.get(getIndexOf(name));
    }

    /**
     * Gets not a certain card is in play.
     *
     * @param name name of card to check for
     * @return true if card is in play, otherwise false
     */
    private boolean isInPlay(Blue name) {
        for (BlueCard blueCard : cardsInPlay)
            if (blueCard.name() == name)
                return true;
        return false;
    }

    /**
     * Gets the index of a blue card in play.
     *
     * @param name name of blue card to check for
     * @return index of card in play, -1 if it doesn't exist
     */
    private int getIndexOf(Blue name) {
        for (int i = 0; i < cardsInPlay.size(); i++)
            if (cardsInPlay.get(i).name() == name)
                return i;
        return -1;
    }

    public List<BlueCard> getCardsInPlay() {
        return cardsInPlay;
    }


    @Override
    public String toString() {
        return name;
    }

    public int getLifePoints() {
        return lifePoints;
    }

    public CharacterCard getCharacter() {
        return character;
    }

    public RoleCard getRole() {
        return role;
    }

    public Hand getHand() {
        return hand;
    }

    public String getName() {
        return name;
    }
}