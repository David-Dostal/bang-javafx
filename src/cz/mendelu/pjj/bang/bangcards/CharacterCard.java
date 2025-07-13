package cz.mendelu.pjj.bang.bangcards;


import cz.mendelu.pjj.bang.cards.Card;

/**
 * @author xdostal8
 */
public class CharacterCard extends Card {

    /**
     * Number of maximum life points for the character
     */
    private final int maxLifePoints;
    /**
     * Name of character
     */
    private final Character name;

    /**
     * Creates a new character card.
     *
     * @param name name of character
     */
    public CharacterCard(Character name) {
        super(CharacterImage.valueOf(name.getFilenameString()).toString());
        this.name = name;
        this.maxLifePoints = name == Character.PAUL_REGRET || name == Character.EL_GRINGO ? 3 : 4;
    }

    /**
     * Gets the maximum number of life points of character.
     *
     * @return maximum life points
     */
    public int maxLifePoints() {
        return maxLifePoints;
    }

    public String description() {
        return switch (name) {
            case BART_CASSIDY -> "(4 �ivoty): V�dy, kdy� ztrat�te �ivot, doberte si okam�it� jednu kartu z " +
                    "\nbal��ku hrac�ch karet. Tato schopnost ne��inkuje, pokud byste m�li ztratit sv�j posledn� �ivot.";
            case BLACK_JACK -> "(4 �ivoty): Ve sv�m tahu v 1. f�zi mus�te uk�zat ostatn�m druhou kartu, kterou si " +
                    "\ndob�r�te. Pokud je srdcov� nebo k�rov�, doberte si je�t� jednu kartu (tu ostatn�m neukazujte).";
            case CALAMITY_JANET -> """
                    (4 �ivoty): M��ete pou��vat karty BANG! jako Vedle ! a naopak.\s
                    Kdy� zahrajete ve sv�m tahu kartu Vedle ! jako BANG!, nem��ete zahr�t dal�� kartu BANG!\s
                    (pokud nem�te ve h�e Volcanic).""";
            case EL_GRINGO -> """
                    (3 �ivoty): V�dy, kdy� d�ky n�jak�mu hr��i ztrat�te �ivoty, vezm�te si z jeho ruky
                    n�hodn� jednu kartu za ka�d� �ivot, o kter� p�ijdete. Tato schopnost ne��inkuje, pokud byste\s
                    m�li ztratit sv�j posledn� �ivot. Kdy� doty�n� hr�� nem� v ruce dostatek karet, respektive ��dn�\s
                    karty, m�te sm�lu ! Nezapome�te, �e zran�n� zp�soben� Dynamitem se ne p�i�azuj� ��dn�mu hr��i.\s
                    Jestli�e zahrajete Duel a p�ijdete o �ivot, proto�e neodhod�te kartu BANG!, kartu si od protivn�ka neberete.""";
            case JESSE_JONES -> "(4 �ivoty): Ve sv�m tahu v 1. f�zi si m��ete vybrat, zda si prvn� kartu vezmete " +
                    "\nn�hodn� z ruky jin�ho hr��e nebo doberte z dob�rac�ho bal��ku. Druhou kartu si v�dy dob�r�te z bal��ku.";
            case JOURDONNAIS -> """
                    (4 �ivoty): D�ky schopnosti t�to postavy m�te k dispozici imagin�rn� Barel, tj.\s
                    m��ete �sejmout�, jsteli c�lem efektu BANG!, a p�i oto�en� srdcov� karty je tento efekt zru�en.\s
                    Skute�nou kartu Barel m��ete m�t ve h�e rovn�, tak�e m�te mo�nost zkusit zru�it efekt BANG! dvakr�t, ani� byste museli hr�t kartu Vedle!\s""";
            case KIT_CARLSON -> "(4 �ivoty): Ve sv�m tahu v 1. f�zi se m��ete pod�vat na vrchn� t�i karty z \n" +
                    "dob�rac�ho bal��ku ; dv� z nich si doberte a zb�vaj�c� polo�te zp�t na vr�ek bal��ku l�cem dol�.";
            case LUCKY_DUKE -> "(4 �ivoty): Kdykoli m�te �sejmout�, oto�te vrchn� dv� karty z dob�rac�ho bal��ku \n" +
                    "a vyberte si, kterou z nich pou�ijete. Ob� karty se potom odhod�. ";
            case PAUL_REGRET -> """
                    (3 �ivoty) : D�ky schopnosti t�to postavy m�te k dispozici imagin�rn�ho Mustanga;
                     pro ostatn� hr��e se tedy nach�z�te ve vzd�lenosti o 1 vy���. Skute�nou kartu Mustang m��ete m�t
                     ve h�e rovn�; v takov�m p��pad� se budete pro ostatn� nach�zet ve vzd�lenosti dokonce o 2 v�t��.""";
            case PEDRO_RAMIREZ -> "(4 �ivoty): Ve sv�m tahu v 1. f�zi si m��ete vybrat, zda si prvn� kartu vezmete \n" +
                    "z vr�ku hrom�dky odhozen�ch nebo doberte z dob�rac�ho bal��ku. Druhou kartu si v�dy dob�r�te z bal��ku. ";
            case ROSE_DOOLAN -> """
                    (4 �ivoty): D�ky schopnosti t�to postavy m�te k dispozici imagin�rn� Hled�;\s
                    ostatn� hr��i se tedy pro v�s nach�z� ve vzd�lenosti o 1 men��. Skute�nou kar tu Hled� m��ete\s
                    m�t ve h�e rovn�; v takov�m p��pad� se pro v�s budou ostatn� nach�zet ve vzd�lenosti dokonce o 2 men��.""";
            case SID_KETCHUM -> """
                    (4 �ivoty): M��ete kdykoli odhodit dv� karty z ruky a vyl��it si tak jeden\s
                    �ivot. Pokud chcete a m��ete, sm�te tuto schopnost pou��t v�cekr�t za tah. Nezapome�te ale,\s
                    �e nem��e m�t v�ce �ivot�, ne� kolik �in� po��te�n� mno�stv�. Takto se m��ete zachr�nit, i\s
                    kdybyste m�li p�ij�t o posledn� �ivot.\s""";
            case SLAB_THE_KILLER -> "(4 �ivoty): Hr��, kter� chce zru�it va�i kartu BANG!, mus� pou��t dva \n" +
                    "efekty Vedle ! �sp�n� �sejmut� u karty Barel zastoup� pouze jeden z nich. ";
            case SUZY_LAFAYETTE -> """
                    (4 �ivoty): Jakmile nem�te v ruce ��dnou kartu, sm�te si dobrat jednu\s
                    kartu z dob�rac�ho bal��ku. B�hem Duelu tato schopnost nefunguje: jestli�e m�te jako posledn�\s
                    kartu v ruce BANG!, kter� odhod�te, a druh� hr�� odhod� n�sledn� rovn� kartu BANG!, prohr�v�te\s
                    a ztr�c�te �ivot. Teprve pot� si doberete kartu. Jestli�e �el�te kart� BANG! zahran� Slabem the\s
                    Killerem a m�te v ruce jako posledn� kartu Vedle !, m��ete ji zahr�t a dobrat si dal�� kartu.\s
                    Jestli�e to bude rovn� Vedle !, sm�te ho zahr�t a Slab�v BANG! tak zru�it.""";
            case VULTURE_SAM -> """
                    (4 �ivoty): Kdykoli je n�jak� postava zabita, vezm�te si do ruky v�echny karty,\s
                    kter� m� jej� hr�� v ruce a ve h�e. Pokud jste �erifem a zabijete sv�ho Z�stupce,\s
                    nejprve si vezm�te do ruky v�echny uveden� karty zabit� postavy, av�ak ihned pot� je\s
                    mus�te spolu se v�emi sv�mi p�vodn�mi kartami odhodit.""";
            case WILLY_THE_KID -> "(4 �ivoty): Ve sv�m tahu sm�te zahr�t libovoln� po�et karet BANG!";
        };
    }

    /**
     * Gets the name of character on card.
     *
     * @return name of character
     */
    public Character name() {
        return name;
    }

    @Override
    public String toString() {
        return name.toString();
    }
}