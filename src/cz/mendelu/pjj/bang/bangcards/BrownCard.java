package cz.mendelu.pjj.bang.bangcards;

import cz.mendelu.pjj.bang.cards.*;

/**
 * @author xdostal8
 */
public class BrownCard extends Card {

    /**
     * Name of brown card.
     */
    private final Brown name;

    /**
     * Creates a new brown card.
     *
     * @param name name of card
     */

    public BrownCard(Brown name, Value value, Suit suit) {
        super(value, suit, BrownImage.valueOf(name.getFilenameString()).toString());
        this.name = name;
    }

    /**
     * Gets the name of the card.
     *
     * @return name of card
     */
    public Brown name() {
        return name;
    }

    /**
     * Gets a String description of the brown card.
     *
     * @return string description of card
     */
    public String description() {
        return switch (name) {
            case BANG -> "Pomocí této karty mùžeš vystøelit na jakéhokoli hráèe, pokud na nìj dostøelíš.";
            case MISSED -> "Vyhneš se støelou z kulometu a kartì Bang.";
            case BEER -> "Pokud tuto kartu použiješ, vyléèí se ti život.";
            case CAT_BALOU ->
                    "Pomocí Cat Balou mùžeš nìkomu vzít jakoukoli kartu a hodíš ji do odhazovacího balíèku. (nezáleží na vzdálenosti hráèe)";
            case STAGECOACH -> "Díky této kartì si mùžeš vzít další dvì kary.";
            case PANIC -> "Vezmeš kartu si kartu od hráèe ve vzdálenosti 1";
            case DUEL ->
                    "Když zahrajete tuto kartu, vyzýváte jiného hráèe bez ohledu na vzdálenost na souboj. Vyzvaný hráè mùže odhodit kartu BANG!. Pokud tak uèiní, mùžete odhodit kartu BANG! vy atd. První z vás, který kartu BANG! neodhodí, ztrácí jeden život a poté souboj konèí. Karta Duel se nepovažuje za kartu Bang!";
            case WELLS_FARGO -> "Díky této kartì si mùžeš vzít další tøi karty.";
            case GATLING -> "Všichni ostatní hráèi musejí odhodit kartu Vedle, jinak ztrácí život.";
            case INDIANS -> "Všichni ostatní hráèi musí odhodit Bang, jinak ztratí jeden život.";
            case GENERAL_STORE ->
                    "Otoè tolik vrchních karet z balíèku, kolek je hráèù a každý si vezme jednu. Zaène ten co použil Hokynáøství a pokraèují hráèi po jeho levici.";
            case SALOON -> "Pokud tuto kartu použiješ tak se všem vyléèí jeden život.";
            default -> "???";
        };
    }

    @Override
    public String toString() {
        return name.toString() + " (" + super.toString() + ")";
    }
}