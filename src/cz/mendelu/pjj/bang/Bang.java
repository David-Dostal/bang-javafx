package cz.mendelu.pjj.bang;

import cz.mendelu.pjj.bang.bangcards.Character;
import cz.mendelu.pjj.bang.bangcards.*;
import cz.mendelu.pjj.bang.cards.*;
import cz.mendelu.pjj.bang.deck.Deck;
import cz.mendelu.pjj.bang.deck.Discard;
import cz.mendelu.pjj.bang.deck.Hand;

import java.io.IOException;
import java.util.*;

/**
 * @author xdostal
 */
public class Bang {
    /**
     * Player that is currently playing
     */
    private static Player currentPlayer;
    /**
     * Another player that is currently displayed
     */
    private static Player displayedOtherPlayer;
    /**
     * List of players
     */
    private static final List<Player> players = new ArrayList<>();
    /**
     * List of character cards
     */
    private static final Card[] characters = new Card[]{
            new CharacterCard(Character.BART_CASSIDY),
            new CharacterCard(Character.BLACK_JACK),
            new CharacterCard(Character.CALAMITY_JANET),
            new CharacterCard(Character.EL_GRINGO),
            new CharacterCard(Character.JESSE_JONES),
            new CharacterCard(Character.JOURDONNAIS),
            new CharacterCard(Character.KIT_CARLSON),
            new CharacterCard(Character.LUCKY_DUKE),
            new CharacterCard(Character.PAUL_REGRET),
            new CharacterCard(Character.PEDRO_RAMIREZ),
            new CharacterCard(Character.ROSE_DOOLAN),
            new CharacterCard(Character.SID_KETCHUM),
            new CharacterCard(Character.SLAB_THE_KILLER),
            new CharacterCard(Character.SUZY_LAFAYETTE),
            new CharacterCard(Character.VULTURE_SAM),
            new CharacterCard(Character.WILLY_THE_KID)
    };
    /**
     * List of playable cards
     */
    private static final Card[] cards = new Card[]{
            new BrownCard(Brown.SALOON, Value.FIVE, Suit.HEARTS),
            new BrownCard(Brown.GENERAL_STORE, Value.NINE, Suit.CLUBS),
            new BrownCard(Brown.GENERAL_STORE, Value.QUEEN, Suit.SPADES),
            new BrownCard(Brown.INDIANS, Value.KING, Suit.DIAMONDS),
            new BrownCard(Brown.INDIANS, Value.ACE, Suit.DIAMONDS),
            new BrownCard(Brown.GATLING, Value.TEN, Suit.HEARTS),
            new BrownCard(Brown.WELLS_FARGO, Value.THREE, Suit.HEARTS),
            new BrownCard(Brown.DUEL, Value.QUEEN, Suit.DIAMONDS),
            new BrownCard(Brown.DUEL, Value.EIGHT, Suit.CLUBS),
            new BrownCard(Brown.DUEL, Value.JACK, Suit.SPADES),
            new BrownCard(Brown.PANIC, Value.ACE, Suit.HEARTS),
            new BrownCard(Brown.PANIC, Value.JACK, Suit.HEARTS),
            new BrownCard(Brown.PANIC, Value.QUEEN, Suit.HEARTS),
            new BrownCard(Brown.PANIC, Value.EIGHT, Suit.DIAMONDS),
            new BrownCard(Brown.STAGECOACH, Value.NINE, Suit.SPADES),
            new BrownCard(Brown.STAGECOACH, Value.NINE, Suit.SPADES),
            new BrownCard(Brown.CAT_BALOU, Value.TEN, Suit.DIAMONDS),
            new BrownCard(Brown.CAT_BALOU, Value.NINE, Suit.DIAMONDS),
            new BrownCard(Brown.CAT_BALOU, Value.JACK, Suit.DIAMONDS),
            new BrownCard(Brown.CAT_BALOU, Value.KING, Suit.HEARTS),
            new BrownCard(Brown.BEER, Value.TEN, Suit.HEARTS),
            new BrownCard(Brown.BEER, Value.SEVEN, Suit.HEARTS),
            new BrownCard(Brown.BEER, Value.EIGHT, Suit.HEARTS),
            new BrownCard(Brown.BEER, Value.JACK, Suit.HEARTS),
            new BrownCard(Brown.BEER, Value.SIX, Suit.HEARTS),
            new BrownCard(Brown.BEER, Value.NINE, Suit.HEARTS),
            new BrownCard(Brown.MISSED, Value.QUEEN, Suit.HEARTS),
            new BrownCard(Brown.MISSED, Value.SEVEN, Suit.SPADES),
            new BrownCard(Brown.MISSED, Value.KING, Suit.CLUBS),
            new BrownCard(Brown.MISSED, Value.THREE, Suit.SPADES),
            new BrownCard(Brown.MISSED, Value.TEN, Suit.CLUBS),
            new BrownCard(Brown.MISSED, Value.SIX, Suit.SPADES),
            new BrownCard(Brown.MISSED, Value.FOUR, Suit.SPADES),
            new BrownCard(Brown.MISSED, Value.TWO, Suit.SPADES),
            new BrownCard(Brown.MISSED, Value.JACK, Suit.CLUBS),
            new BrownCard(Brown.MISSED, Value.ACE, Suit.CLUBS),
            new BrownCard(Brown.MISSED, Value.EIGHT, Suit.SPADES),
            new BrownCard(Brown.MISSED, Value.FIVE, Suit.SPADES),
            new BrownCard(Brown.BANG, Value.TWO, Suit.CLUBS),
            new BrownCard(Brown.BANG, Value.FIVE, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.QUEEN, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.NINE, Suit.CLUBS),
            new BrownCard(Brown.BANG, Value.JACK, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.THREE, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.SEVEN, Suit.CLUBS),
            new BrownCard(Brown.BANG, Value.SIX, Suit.CLUBS),
            new BrownCard(Brown.BANG, Value.THREE, Suit.CLUBS),
            new BrownCard(Brown.BANG, Value.QUEEN, Suit.HEARTS),
            new BrownCard(Brown.BANG, Value.SIX, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.ACE, Suit.SPADES),
            new BrownCard(Brown.BANG, Value.ACE, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.SEVEN, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.TWO, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.ACE, Suit.HEARTS),
            new BrownCard(Brown.BANG, Value.FOUR, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.KING, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.FOUR, Suit.CLUBS),
            new BrownCard(Brown.BANG, Value.FIVE, Suit.CLUBS),
            new BrownCard(Brown.BANG, Value.EIGHT, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.NINE, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.TEN, Suit.DIAMONDS),
            new BrownCard(Brown.BANG, Value.KING, Suit.HEARTS),
            new BrownCard(Brown.BANG, Value.EIGHT, Suit.CLUBS),
            new BlueCard(Blue.DYNAMITE, Value.TWO, Suit.HEARTS),
            new BlueCard(Blue.JAIL, Value.FOUR, Suit.HEARTS),
            new BlueCard(Blue.JAIL, Value.JACK, Suit.SPADES),
            new BlueCard(Blue.JAIL, Value.TEN, Suit.SPADES),
            new BlueCard(Blue.VOLCANIC, Value.TEN, Suit.CLUBS),
            new BlueCard(Blue.VOLCANIC, Value.TEN, Suit.SPADES),
            new BlueCard(Blue.SCHOFIELD, Value.JACK, Suit.CLUBS),
            new BlueCard(Blue.SCHOFIELD, Value.QUEEN, Suit.CLUBS),
            new BlueCard(Blue.SCHOFIELD, Value.KING, Suit.SPADES),
            new BlueCard(Blue.REMINGTON, Value.KING, Suit.CLUBS),
            new BlueCard(Blue.REV_CARBINE, Value.ACE, Suit.SPADES),
            new BlueCard(Blue.WINCHESTER, Value.EIGHT, Suit.SPADES),
            new BlueCard(Blue.SCOPE, Value.ACE, Suit.SPADES),
            new BlueCard(Blue.MUSTANG, Value.EIGHT, Suit.HEARTS),
            new BlueCard(Blue.MUSTANG, Value.NINE, Suit.HEARTS),
            new BlueCard(Blue.BARREL, Value.KING, Suit.SPADES),
            new BlueCard(Blue.BARREL, Value.QUEEN, Suit.SPADES)

    };
    /**
     * Deck of cards that can be drawn
     */
    private static Deck deck;
    /**
     * Discard pile of used cards
     */
    private static Discard discard;
    /**
     * Tracks whether current player has yet played Bang! card
     */
    private static boolean bangPlayed;

    /**
     * Gets a player that is currently displayed above the currently playing player.
     *
     * @return other displayed player
     */
    public static Player getDisplayedOtherPlayer() {
        return displayedOtherPlayer;
    }

    /**
     * Set the player that is currently displayed above the currently playing player.
     *
     * @param displayedOtherPlayer the new player that is displayed above the playing one
     */
    public static void setDisplayedOtherPlayer(Player displayedOtherPlayer) {
        Bang.displayedOtherPlayer = displayedOtherPlayer;
    }

    /**
     * Setups all the necessary game components: players, playable cards, role cards, character cards, deck
     */
    private static void setup() {
        createPlayers();
        Deck roleDeck = createRoles();
        roleDeck.shuffle();
        setRoles(roleDeck);
        Deck characterDeck = new Deck(new ArrayList<>(Arrays.asList(characters)));
        characterDeck.shuffle();
        setCharacters(characterDeck);
        ArrayList<Card> newCards = new ArrayList<>(Arrays.asList(cards));
        deck = new Deck(newCards);
        deck.shuffle();
        giveStartingHands();
        discard = new Discard();
    }

    /**
     * Creates and adds 4 new players to the game
     */
    private static void createPlayers() {
        players.add(new Player("Hráč 1"));
        players.add(new Player("Hráč 2"));
        players.add(new Player("Hráč 3"));
        players.add(new Player("Hráč 4"));
    }

    /**
     * Creates and adds 4 new role cards to the game
     */
    private static Deck createRoles() {
        Card sheriff = new RoleCard(Role.SHERIFF);
        Card outlaw = new RoleCard(Role.OUTLAW);
        Card renegade = new RoleCard(Role.RENEGADE);
        //Card deputy = new RoleCard(Role.DEPUTY);
        return new Deck(new ArrayList<>(Arrays.asList(sheriff, renegade, outlaw, outlaw)));
    }

    /**
     * Randomly assigns roles to the players
     *
     * @param roles deck of roles that will be assigned
     */
    private static void setRoles(Deck roles) {
        for (Player player : players)
            player.setRole((RoleCard) roles.draw());
    }

    /**
     * Gets a player that is a sheriff
     *
     * @return player that is sheriff
     */
    private static Player getSheriff() {
        for (Player player : players)
            if (player.role().role() == Role.SHERIFF)
                return player;
        return null;
    }

    /**
     * Randomly assigns characters to the players
     *
     * @param characters deck of characters that will be assigned
     */
    private static void setCharacters(Deck characters) {
        for (Player player : players) {
            player.setCharacter((CharacterCard) characters.draw());
        }
    }

    /**
     * Gives random cards from decks to all player's hands
     */
    private static void giveStartingHands() {
        for (Player player : players)
            for (int i = 0; i < player.lifePoints(); i++)
                player.hand().add(deck.draw());
    }

    /**
     * Gets player roles that are still alive
     *
     * @return roles that are left
     */
    private static List<Role> getRolesLeft() {
        List<Role> rolesLeft = new ArrayList<>();
        for (Player player : players)
            rolesLeft.add(player.role().role());
        return rolesLeft;
    }

    /**
     * Check whether the current game has ended.
     *
     * @return true if the game ending conditions are met, false otherwise
     */
    private static boolean isGameOver() {
        return !(getRolesLeft().contains(Role.SHERIFF) &&
                (getRolesLeft().contains(Role.OUTLAW) || getRolesLeft().contains(Role.RENEGADE)));
    }

    /**
     * Returns, which role has won the game
     *
     * @return Role that has won the game
     */
    public static Role getWinner() {
        List<Role> rolesLeft = getRolesLeft();
        if (rolesLeft.contains(Role.SHERIFF)) return Role.SHERIFF;
        if (rolesLeft.size() > 1 || rolesLeft.contains(Role.OUTLAW)) return Role.OUTLAW;
        return Role.RENEGADE;
    }

    /**
     * Based on the winning conditions displays who have won
     */
    private static void displayWinMessage() {
        switch (getWinner()) {
            case SHERIFF -> System.out.println("Výherce = Šerif!");
            case OUTLAW -> System.out.println("Výherce = Banditi!");
            case RENEGADE -> System.out.println("Výherce = Odpadlík!");
        }
    }

    /**
     * Based on the winning returns a string containing the winner
     */
    public static String getWinMessage() {
        String winner;
        switch (getWinner()) {
            case SHERIFF -> winner = "Výherce = Šerif!";
            case OUTLAW -> winner = "Výherce = Banditi!";
            case RENEGADE -> winner = "Výherce = Odpadlík!";
            default -> throw new IllegalStateException("Unexpected value: " + getWinner());
        }
        return winner;
    }

    /**
     * Returns the player that will be playing next
     *
     * @param player previous player
     * @return next player
     */
    public static Player nextPlayer(Player player) {
        return players.indexOf(player) == players.size() - 1 ? players.get(0) : players.get(players.indexOf(player) + 1);
    }

    /**
     * Removes suggested player from the game and displays the killer
     *
     * @param player dead player
     * @param killer player that killed him
     */
    private static void removePlayer(Player player, Player killer) {
        players.remove(player);
        discard.add(player.takeAllCardsFromPlay());
        discard.add(player.takeAllCardsFromHand());
        System.out.println(player.name() + " byl zabit!");
        System.out.println(player.name() + " byl " + player.role().toString() + ".\n");
        if (killer != null) {
            if (player.role().role() == Role.OUTLAW) {
                killer.hand().add(deck.draw());
                killer.hand().add(deck.draw());
                killer.hand().add(deck.draw());
                System.out.println(killer.name() + " dobírá tři karty za zabití bandity.\n");
            }
        }
    }

    /**
     * Draws a card from the deck
     * if the deck is empty, the discarded pille will be shuffled and added into the deck
     *
     * @return Role that has won the game
     */
    private static Card drawCard() {
        if (deck.isEmpty()) {
            deck.add(discard.top(discard.size()));
            deck.shuffle();
        }
        return deck.draw();
    }

    /**
     * Discards indexed card on current player's table
     *
     * @param index Index of the card
     */
    public static void discardCardOnTable(int index) {
        discard.add(getCurrentPlayer().takeCard(index));
    }

    /**
     * Discards indexed card in current player's hand
     *
     * @param index Index of the card
     */
    public static void discardCardInHand(int index) {
        discard.add(getCurrentPlayer().hand().take(index));
    }

    /**
     * Main method that is used for players to play cards
     *
     * @param player          player that has played the card
     * @param card            the card that was played
     * @param secondaryAction used to specify wanted action
     */
    public static void play(Player player, Card card, boolean secondaryAction) throws IOException {
        if (card instanceof BlueCard) {
            playBlueCard(player, (BlueCard) card);
        } else if (card instanceof BrownCard) {
            playBrownCard(player, (BrownCard) card, secondaryAction);
        }
        if (isGameOver()) {
            endGame();
        }
    }

    /**
     * Gets the discard pile
     *
     * @return discard pile
     */
    public static Discard getDiscard() {
        return discard;
    }

    /**
     * Method that ends the game
     * Displays the win message and brings user to the end screen
     */
    public static void endGame() throws IOException {
        displayWinMessage();
        Main.loadEndScreen();
    }

    /**
     * Used to play blue cards
     *
     * @param player that has played the card
     * @param card   that has been played
     */
    private static void playBlueCard(Player player, BlueCard card) {
        if ((card).name() == Blue.JAIL) {
            playJail(player, card);
        } else {
            Card replacedCard = player.addToPlay(card);
            if (replacedCard != null)
                discard.add(replacedCard);
        }
    }

    /**
     * Used to play brown cards
     *
     * @param player          that has played the card
     * @param card            that has been played
     * @param secondaryAction used to specify wanted action
     */
    private static void playBrownCard(Player player, BrownCard card, boolean secondaryAction) {
        switch (card.name()) {
            case BANG -> playBang(player, card);
            case MISSED -> playMissed(player, card);
            case BEER -> playBeer(player, card);
            case SALOON -> playSaloon(card);
            case STAGECOACH -> playStagecoach(player, card);
            case WELLS_FARGO -> playWellsFargo(player, card);
            case PANIC -> playPanic(player, card, secondaryAction);
            case CAT_BALOU -> playCatBalou(player, card, secondaryAction);
            case GATLING -> playGatling(player, card);
            case INDIANS -> playIndians(player, card);
            case GENERAL_STORE -> playGeneralStore(card);
            case DUEL -> playDuel(player, card);
        }
    }

    /**
     * Gets list of players, that are in range from the specified player
     *
     * @param player that we want to get the players in range from
     * @return List<Player> players that are in range
     */
    private static List<Player> playersInRange(Player player) {
        int vision;
        int distance;
        List<Player> playersInRange = new ArrayList<>();
        for (Player p : players) {
            if (p != player) {
                vision = player.hasScope() ? player.gunRange() + 1 : player.gunRange();
                distance = Math.min(Math.abs(players.indexOf(p) - players.indexOf(player)), players.size() - Math.abs(Math.abs(players.indexOf(p) - players.indexOf(player))));
                if (p.hasMustang()) distance++;
                if (vision >= distance) playersInRange.add(p);
            }
        }
        return playersInRange;
    }

    /**
     * Gets list of players, that are in a range of 1 from the specified player
     *
     * @param player that we want to get the players in range from
     * @return List<Player> players that are in range
     */
    private static List<Player> playersInRangeOne(Player player) {
        List<Player> playersInRangeOne = new ArrayList<>();
        int range;
        for (Player p : players) {
            if (p != player) {
                range = Math.min(Math.abs(players.indexOf(p) - players.indexOf(player)), players.size() - Math.abs(Math.abs(players.indexOf(p) - players.indexOf(player))));
                if (p.hasMustang()) range++;
                if (player.hasScope()) range--;
                if (range <= 1) playersInRangeOne.add(p);
            }
        }
        return playersInRangeOne;
    }

    /**
     * Gets list of all players in the game where the specified player is not included
     *
     * @param player that we do not want to include
     * @return List<Player> players that are in game minus the specified player
     */
    private static List<Player> otherPlayers(Player player) {
        List<Player> otherPlayers = new ArrayList<>();
        for (Player p : players)
            if (p != player)
                otherPlayers.add(p);
        return otherPlayers;
    }

    /**
     * Puts the specified player into the draw phase
     *
     * @param player that will be put into a draw phase
     */
    private static void drawPhase(Player player) {
        bangPlayed = false;
        player.hand().add(drawCard());
        player.hand().add(drawCard());
        System.out.println();
        System.out.println(player.name() + " si dobral dvě karty na začátku kola.");
    }

    /**
     * Puts the specified player into the discard phase
     *
     * @param player that will be put into the discard phase
     */
    private static boolean discardPhase(Player player) {
        if (player.hand().size() > player.lifePoints()) {
            System.out.println("Pro ukončení kola se musíš ještě zbavit " +
                    (player.hand().size() - player.lifePoints()) + " karet z ruky.");
            return false;
        } else {
            return true;
        }
    }

    /**
     * Method that is called when Bang! is used.
     * Determines, whether the user can play Bang! under current conditions - if not, the card is returned into his hand.
     *
     * @param player that has played bang
     * @param card   Bang! card that has been played
     */
    private static void playBang(Player player, BrownCard card) {
        if (playersInRange(currentPlayer).contains(displayedOtherPlayer)) {
            if (!bangPlayed || (player.gun() != null && player.gun().name() == Blue.VOLCANIC)) {
                respondToBang(displayedOtherPlayer, player);
                bangPlayed = true;
                discard.add(card);
            } else {
                System.out.println("Bang! Můžeš zahrát jen jednou za kolo (bez Volcanic).");
                player.hand().add(card);
            }
        } else {
            System.out.println("Hráč se nenachází v dosahu tvého dostřelu. Bang! nelze zahrát");
            player.getHand().add(card);
        }
    }

    /**
     * Method that is called when the player is being attacked by the shooter with the Bang! card
     * Determines, whether the user will take damage, block the damage with a barrel or dodge it with Miss!
     *
     * @param player  that is being attacked
     * @param shooter that used the Bang! card
     */
    private static void respondToBang(Player player, Player shooter) {
        if (resolveBarrel(player)) {
            boolean tookAction = false;
            for (int i = 0; i < player.getHand().size(); i++) {
                if (player.getHand().getHand().get(i) instanceof BrownCard && (((BrownCard) player.getHand().getHand().get(i)).name() == Brown.MISSED)) {
                    System.out.println(player.name() + " použil Vedle!");
                    discard.add(player.getHand().take(i));
                    tookAction = true;
                    break;
                }
            }
            if (!tookAction) {
                System.out.println(player.name() + " ztratil život po zásahu kartou Bang!");
                player.loseLife();
                if (player.isAlive())
                    removePlayer(player, shooter);
            }
        }
    }

    /**
     * This method warns the player that he cannot use Missed! card on its own and puts it back into his hands
     *
     * @param player that has played the card
     * @param card   the Missed! card
     */
    private static void playMissed(Player player, BrownCard card) {
        System.out.println("Během svého kola nemůžeš zahrát kartu Vedle!");
        player.hand().add(card);
    }

    /**
     * Handles when the player plays card Beer!
     * Based on the rules, it either restores player's lives by discarding the card or it displays the appropriate
     * message and gives it back to player's hand
     *
     * @param player that has played the card
     * @param card   the Beer! card
     */
    private static void playBeer(Player player, BrownCard card) {
        if (players.size() == 2) {
            System.out.println("Karta Pivo nelze zahrát, když zbývají pouze dva hráči.");
            player.hand().add(card);
        } else if (player.gainLife()) {
            System.out.println("Obnovil sis jeden život.");
            discard.add(card);
        } else {
            System.out.println("Už máš maximální počet životů!");
            player.hand().add(card);
        }
    }

    /**
     * Handles the Saloon card
     * gives all players one life or displays the appropriate message
     *
     * @param card the saloon card
     */
    private static void playSaloon(BrownCard card) {
        for (Player player : players)
            player.gainLife();
        discard.add(card);
    }

    /**
     * Handles the Stage coach card
     * specified player draws two cards and discard's the stage coach card
     *
     * @param card   the Stage coach card
     * @param player the player that has played the card
     */
    private static void playStagecoach(Player player, BrownCard card) {
        player.hand().add(deck.draw());
        player.hand().add(deck.draw());
        discard.add(card);
    }

    /**
     * Handles the Wells Fargo card
     * specified player draws three cards and discard's the Wells Fargo card
     *
     * @param card   the Wells Fargo card
     * @param player the player that has played the card
     */
    private static void playWellsFargo(Player player, BrownCard card) {
        player.hand().add(deck.draw());
        player.hand().add(deck.draw());
        player.hand().add(deck.draw());
        discard.add(card);
    }

    /**
     * Handles the Panic card
     * based on the specified action, player either steals a random card from another player's hand or table.
     * If there are no cards in his hand or on table, or if he is not in the range of 1, the card will be returned
     * to player's hand.
     *
     * @param card   the Panic! card
     * @param player the player that has played the card
     */
    private static void playPanic(Player player, BrownCard card, boolean secondaryAction) {
        Player target = displayedOtherPlayer;
        if (playersInRangeOne(currentPlayer).contains(target)) {
            if (secondaryAction) {
                if (displayedOtherPlayer.hand().size() == 0) {
                    System.out.println("Paniku nelze zahrát na prázdnou ruku.");
                    player.getHand().add(card);
                } else {
                    player.hand().add(target.hand().takeRandom());
                    discard.add(card);
                }
            } else {
                if (displayedOtherPlayer.getCardsInPlay().size() == 0) {
                    System.out.println("Paniku nelze zahrát na prázdný stůl.");
                    player.getHand().add(card);
                } else {
                    player.hand().add(target.takeRandomCard());
                    discard.add(card);
                }
            }
        } else {
            System.out.println("Hráč se nenachází v dosahu 1. Paniku nelze zahrát");
            player.getHand().add(card);
        }
    }

    /**
     * Handles the Cat Balou card
     * based on the specified action, player either discards a random card from another player's hand or table.
     * If there are no cards in his hand or on table, the card will be returned to player's hand.
     *
     * @param card   the Cat Balou card
     * @param player the player that has played the card
     */
    private static void playCatBalou(Player player, BrownCard card, boolean secondaryAction) {
        Player target = displayedOtherPlayer;
        if (secondaryAction) {
            if (displayedOtherPlayer.hand().size() == 0) {
                System.out.println("Cat Balou nelze zahrát na prázdnou ruku.");
                player.getHand().add(card);
            } else {
                discard.add(card);
                discard.add(target.hand().takeRandom());
            }
        } else {
            if (displayedOtherPlayer.getCardsInPlay().size() == 0) {
                System.out.println("Cat Balou nelze zahrát na prázdný stůl.");
                player.getHand().add(card);
            } else {
                discard.add(card);
                discard.add(target.takeRandomCard());
            }
        }
    }

    /**
     * Handles the Gatling card
     * This card uses the Bang! action on all players (not including the player who has played it)
     * Players can either Miss! it, successfully use barrel, or take damage.
     *
     * @param card   the Gatling card
     * @param player the player that has played the card
     */
    private static void playGatling(Player player, BrownCard card) {
        discard.add(card);
        for (Player p : otherPlayers(player)) {
            if (resolveBarrel(p)) {
                boolean tookAction = false;
                for (int i = 0; i < p.getHand().size(); i++) {
                    if (p.getHand().getHand().get(i) instanceof BrownCard && (((BrownCard) p.getHand().getHand().get(i)).name() == Brown.MISSED)) {
                        System.out.println(p.name() + " použil Vedle! na Kulomet.");
                        discard.add(p.getHand().take(i));
                        tookAction = true;
                        break;
                    }
                }
                if (!tookAction) {
                    System.out.println(p.name() + " ztratil život po útoku Kulometu.");
                    p.loseLife();
                    if (p.isAlive())
                        removePlayer(p, player);
                }
            }
        }
    }

    /**
     * Handles the Indians! card
     * This card uses the Bang! action on all players (not including the player who has played it)
     * Players can either Bang! it, or take damage.
     *
     * @param card   the Gatling card
     * @param player the player that has played the card
     */
    private static void playIndians(Player player, BrownCard card) {
        discard.add(card);
        for (Player p : otherPlayers(player)) {
            boolean tookAction = false;
            for (int i = 0; i < p.getHand().size(); i++) {
                if (p.getHand().getHand().get(i) instanceof BrownCard && (((BrownCard) p.getHand().getHand().get(i)).name() == Brown.BANG)) {
                    System.out.println(p.name() + " použil Bang! na kartu Indiáni!");
                    discard.add(p.getHand().take(i));
                    tookAction = true;
                    break;
                }
            }
            if (!tookAction) {
                System.out.println(p.name() + " Ztratil život po útoku Indiánů.");
                p.loseLife();
                if (p.isAlive())
                    removePlayer(p, player);
            }
        }
    }

    /**
     * Handles the General Store card
     * This card creates a new hand of cards according to the current number of players, and each player then
     * draws one random card
     *
     * @param card the Gatling card
     */
    private static void playGeneralStore(BrownCard card) {
        discard.add(card);
        Hand hand = new Hand();
        int i = 0;
        while (++i <= players.size()) hand.add(drawCard());
        for (Player p : getPlayers()) {
            p.hand().add(hand.takeRandom());
        }
    }

    /**
     * Handles the Duel card
     * This card initialises a duel between two players and discards the duel card
     *
     * @param card   the Duel card
     * @param player that has initialised the duel
     */
    private static void playDuel(Player player, BrownCard card) {
        discard.add(card);
        respondToDuel(player, displayedOtherPlayer);
    }

    /**
     * Handles the initialised duel
     * The duel ends when one of the players no longer can play the Bang! card.
     * The loser loses one life.
     *
     * @param p1 player that has initialised/used the Bang! card
     * @param p2 player that is responding to the duel
     */
    private static void respondToDuel(Player p1, Player p2) {
        boolean tookAction = false;
        for (int i = 0; i < p2.getHand().size(); i++) {
            if (p2.getHand().getHand().get(i) instanceof BrownCard && (((BrownCard) p2.getHand().getHand().get(i)).name() == Brown.BANG)) {
                System.out.println(p2.name() + "pokračuje v duelu zahráním karty Bang!");
                discard.add(p2.getHand().take(i));
                tookAction = true;
                respondToDuel(p2, p1);
                break;
            }
        }
        if (!tookAction) {
            System.out.println(p2.name() + " ztrácí život a ukončuje duel.");
            p2.loseLife();
            if (p2.isAlive())
                removePlayer(p2, p1);
        }
    }

    /**
     * Handles the ignited Dynamite card
     * Player that currently has ignited Dynamite in possession draws a random card
     * If he draws a Spade card that has value 1-9, the Dynamite is discarded, and he loses 3 lives
     * If he draws any other card, the card is discarded and the Dynamite is passed to the next player
     *
     * @param player player that currently has an ignited Dynamite
     */
    private static boolean resolveDynamite(Player player) {
        if (player.hasDynamite()) {
            System.out.println("Musíš si líznout kartu kvůli Dynamitu");
            Card card = drawCard();
            System.out.println("si líznul " + card.toString() + ".");
            if (card.value().value() < 10 && card.suit() == Suit.SPADES) {
                player.loseLife(3);
                System.out.println("Dynamit vybuchl!\n");
                discard.add(player.takeCard(Blue.DYNAMITE));
                if (player.isAlive()) {
                    removePlayer(player, null);
                    return true;
                }
            } else {
                System.out.println("Jsi v bezpečí. Dynamit nevybuchl.\n");
                nextPlayer(player).addToPlay(player.takeCard(Blue.DYNAMITE));
            }
            return false;
        }
        return false;
    }

    /**
     * Handles the Jail card placed by another player
     * Player that currently has Jail card in-front of him draws a card
     * If he draws a Hearth card, he is released from prison, can normally play and the Jail card is discarded
     * If he draws any other card, he is still stuck in Jail and his round is skipped
     *
     * @param player player that currently has an ignited Dynamite
     */
    private static boolean resolveJail(Player player) {
        if (player.inJail()) {
            System.out.println(player.name() + " Musíš si líznout kartu kvůli Vězení.");
            Card card = drawCard();
            System.out.println(player.name() + " si líznul " + card.toString() + ".");
            discard.add(player.takeCard(Blue.JAIL));
            if (card.suit() == Suit.HEARTS) {
                System.out.println(player.name() + " úspešně utekl z vězení.\n");
            } else {
                System.out.println(player.name() + " se nepovedlo utéct z vězení.\n");
                return false;
            }
        }
        return true;
    }

    /**
     * Handles the Barrel card that is currently on player's table
     * Player that currently has Barrel card in-front of him and is attacked by a Bang! action will automatically
     * draw a card. If the card is Hearths, the Barrel card is discarded and the Bang!
     * Otherwise, the Barrel card stays on Table and the Bang! action continues.
     *
     * @param player player that currently has a Barrel card on his table
     */
    private static boolean resolveBarrel(Player player) {
        if (player.hasBarrel()) {
            System.out.println(player.name() + " si líznul kartu pro použití Barelu.");
            Card card = drawCard();
            System.out.println(player.name() + " si líznul " + card.toString() + ".");
            if (card.suit() == Suit.HEARTS) {
                System.out.println(player.name() + " úspěšně použil Barel.\n");
                return false;
            }
            System.out.println(player.name() + " nepoužil Barel.\n");
        }
        return true;
    }

    /**
     * Handles the Jail card
     * If the displayed player is eligible, he will be put into a jail. Otherwise, the card will be returned to
     * player's hand;
     *
     * @param player player that has played the Jail card
     * @param card   the Jail card
     */
    private static void playJail(Player player, BlueCard card) {
        Player target = displayedOtherPlayer;
        if (target.role().role() == Role.SHERIFF || target.inJail()) {
            System.out.println("Kartu vězení nelze použít na Šerifa, nebo hráče, který se již ve vězení nachází.\n");
            player.getHand().add(card);
        } else {
            target.addToPlay(card);
        }
    }

    /**
     * Prepares the game - launches the setup, assigns the current player to the player that has started as sheriff
     * and puts him into the draw phase
     */
    public static void setupGame() {
        setup();
        currentPlayer = getSheriff(); //set starting player to whoever is Sheriff
        displayedOtherPlayer = nextPlayer(currentPlayer);
        drawPhase(currentPlayer);
    }

    /**
     * Ends turn for the current player, if the conditions have been met
     */
    public static void endTurn() {
        if (discardPhase(currentPlayer)) {
            nextRound();
        }
    }

    /**
     * Prepares the new currentPlayer and displayedOtherPlayer for the next round.
     * Also resolves active Dynamite and Jail cards.
     */
    public static void nextRound() {
        currentPlayer = nextPlayer(currentPlayer);
        displayedOtherPlayer = nextPlayer(currentPlayer);
        int position;
        position = players.indexOf(currentPlayer);
        if (resolveDynamite(currentPlayer)) { //true if player dies to dynamite
            currentPlayer = position == players.size() ? players.get(0) : players.get(position);
            setDisplayedOtherPlayer(nextPlayer(currentPlayer));
        }
        if (!resolveJail(currentPlayer)) { //true if player fails jail escape
            currentPlayer = nextPlayer(currentPlayer);
            setDisplayedOtherPlayer(nextPlayer(currentPlayer));
        }
        drawPhase(currentPlayer);
    }

    /**
     * Returns current player
     *
     * @return current player
     */
    public static Player getCurrentPlayer() {
        return currentPlayer;
    }

    /**
     * Returns all players
     *
     * @return all players
     */
    public static List<Player> getPlayers() {
        return players;
    }

    /**
     * Initializes the game
     */
    public static void main() {
        setupGame();
    }
}