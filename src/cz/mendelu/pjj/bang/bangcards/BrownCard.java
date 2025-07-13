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
            case BANG -> "Pomoc� t�to karty m��e� vyst�elit na jak�hokoli hr��e, pokud na n�j dost�el�.";
            case MISSED -> "Vyhne� se st�elou z kulometu a kart� Bang.";
            case BEER -> "Pokud tuto kartu pou�ije�, vyl��� se ti �ivot.";
            case CAT_BALOU ->
                    "Pomoc� Cat Balou m��e� n�komu vz�t jakoukoli kartu a hod� ji do odhazovac�ho bal��ku. (nez�le�� na vzd�lenosti hr��e)";
            case STAGECOACH -> "D�ky t�to kart� si m��e� vz�t dal�� dv� kary.";
            case PANIC -> "Vezme� kartu si kartu od hr��e ve vzd�lenosti 1";
            case DUEL ->
                    "Kdy� zahrajete tuto kartu, vyz�v�te jin�ho hr��e bez ohledu na vzd�lenost na souboj. Vyzvan� hr�� m��e odhodit kartu BANG!. Pokud tak u�in�, m��ete odhodit kartu BANG! vy atd. Prvn� z v�s, kter� kartu BANG! neodhod�, ztr�c� jeden �ivot a pot� souboj kon��. Karta Duel se nepova�uje za kartu Bang!";
            case WELLS_FARGO -> "D�ky t�to kart� si m��e� vz�t dal�� t�i karty.";
            case GATLING -> "V�ichni ostatn� hr��i musej� odhodit kartu Vedle, jinak ztr�c� �ivot.";
            case INDIANS -> "V�ichni ostatn� hr��i mus� odhodit Bang, jinak ztrat� jeden �ivot.";
            case GENERAL_STORE ->
                    "Oto� tolik vrchn�ch karet z bal��ku, kolek je hr��� a ka�d� si vezme jednu. Za�ne ten co pou�il Hokyn��stv� a pokra�uj� hr��i po jeho levici.";
            case SALOON -> "Pokud tuto kartu pou�ije� tak se v�em vyl��� jeden �ivot.";
            default -> "???";
        };
    }

    @Override
    public String toString() {
        return name.toString() + " (" + super.toString() + ")";
    }
}