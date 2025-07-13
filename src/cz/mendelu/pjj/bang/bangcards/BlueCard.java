package cz.mendelu.pjj.bang.bangcards;

import cz.mendelu.pjj.bang.cards.*;

/**
 * @author xdostal8
 */
public class BlueCard extends Card {

    /**
     * Name of blue card
     */
    private final Blue name;

    /**
     * Creates a new blue card.
     *
     * @param name name of card
     */
    public BlueCard(Blue name, Value value, Suit suit) {
        super(value, suit, BlueImage.valueOf(name.getFilenameString()).toString());
        this.name = name;
    }

    /**
     * Gets the name of the blue card.
     *
     * @return name of card
     */
    public Blue name() {
        return name;
    }

    /**
     * Gets the range of the blue card gun.
     *
     * @return range of gun, 0 if not a gun
     */
    public int range() {
        return switch (name) {
            case VOLCANIC -> 1;
            case SCHOFIELD -> 2;
            case REMINGTON -> 3;
            case REV_CARBINE -> 4;
            case WINCHESTER -> 5;
            default -> 0;
        };
    }

    /**
     * Gets a String description of the blue card.
     *
     * @return string description of blue card
     */
    public String description() {
        return switch (name) {
            case BARREL ->
                    "\"L�zni si!\" Kdy� m�te ve h�e Barel a stanete se c�lem efektu BANG! (a� ji� v d�sledku samot-n� karty BANG! nebo n�jak� jin� karty), m��ete �sejmout�. Pokud oto��te srdco-vou kartu, BANG! je zru�en (jako kdybyste zahr�li kartu Vedle!). V opa�n�m p��-pad� v�s Barel neochr�n�, ale st�le m�te mo�nost zru�it efekt BANG! jin�m zp�so-bem (nap��klad kartou Vedle!).";
            case MUSTANG ->
                    "Jestli�e m�te ve h�e Mustanga, nach�z�te se pro ostatn� hr��e ve vzd�lenosti o 1 v�t��. Z va�eho hlediska se v�ak ostatn� hr��i nach�zej� v norm�ln�ch vzd�lenostech.";
            case SCOPE ->
                    "Jestli�e m�te ve h�e Hled�, v�ichni ostatn� hr��i se pro v�s nach�z� ve vzd�lenosti o 1 men��. Z pohledu ostatn�ch hr��� se v�ak vy sami nach�z�te v b�n� vzd�lenosti. Vzd�lenosti ni��� ne� 1 se pova�uj� za rovn� 1.";
            case JAIL ->
                    "\"L�zni si!\" Tuto kartu m��ete vylo�it p�ed libovoln�ho hr��e s v�jimkou �erifa, ��m� ho uv�zn�te! Pokud se ocitnete ve v�zen�, na za��tku sv�ho tahu, tj. p�ed 1. f�z� (dob-r�n�m dvou karet), �sejm�te�. Jestli�e oto��te srdcovou kartu, poda�� se v�m z v�-zen� uprchnout; karta V�zen� se odhod� a pokra�ujete norm�ln� sv�m tahem. V opa�n�m p��pad� se karta V�zen� odhod� a vy o sv�j tah p�ijdete. St�le v�ak z�st�-v�te mo�n�m c�lem pro karty BANG! a m��ete hr�t karty Vedle! a Pivo mimo vlastn� tah.";
            case DYNAMITE ->
                    "\"L�zni si!\" Jestli�e zahrajete tuto kartu, vylo�te ji p�ed sebe. Dynamit zde z�stane, dokud ne-p�ijdete znovu na �adu. Jakmile za�ne v� dal�� tah (a Dynamit je st�le ve h�e), mus�te p�ed 1. f�z� (dobr�n�m dvou karet) �sejmout�: pokud oto��te kartu mezi pikovou dvojkou a dev�tkou v�etn�, Dynamit exploduje (odhod� se) a ztr�c�te okam�it� 3 �ivoty. V opa�n�m p��pad� se Dynamit p�esune k hr��i po va�� levici, kter� ve sv�m tahu provede tot� ov��en�. Hr��i si mezi sebou Dynamit p�esunuj�, dokud neexploduje (s v��e popsan�m efektem) nebo nen� odstran�n kartami jako Panika! nebo Cat Balou. Pokud se Dynamit ocitne u jednoho hr��e sou�asn� s kar-tou V�zen�, jako prvn� se vyhodnot� Dynamit. Kdy� je postava zabita Dynamitem, nep�ipisuje se toto zabit� ��dn�mu z hr���.";
            case VOLCANIC ->
                    "Jestli�e m�te ve h�e tuto kartu, m��ete hr�t ve sv�m tahu libovoln� po�et karet BANG! Tyto karty mohou m�t za c�l jednoho �i v�ce hr���, ov�em pouze ve vzd�lenosti 1.";
            case SCHOFIELD -> "P�i vylo�en� zvy�uje dosah na 2.";
            case REMINGTON -> "P�i vylo�en� zvy�uje dosah na 3.";
            case REV_CARBINE -> "P�i vylo�en� zvy�uje dosah na 4.";
            case WINCHESTER -> "P�i vylo�en� zvy�uje dosah na 5.";
        };
    }


    @Override
    public String toString() {
        return name.toString() + " (" + super.toString() + ")";
    }
}