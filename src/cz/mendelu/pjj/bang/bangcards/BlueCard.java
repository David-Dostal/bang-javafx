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
                    "\"Lízni si!\" Když máte ve høe Barel a stanete se cílem efektu BANG! (a již v dùsledku samot-né karty BANG! nebo nìjaké jiné karty), mùžete „sejmout“. Pokud otoèíte srdco-vou kartu, BANG! je zrušen (jako kdybyste zahráli kartu Vedle!). V opaèném pøí-padì vás Barel neochrání, ale stále máte možnost zrušit efekt BANG! jiným zpùso-bem (napøíklad kartou Vedle!).";
            case MUSTANG ->
                    "Jestliže máte ve høe Mustanga, nacházíte se pro ostatní hráèe ve vzdálenosti o 1 vìtší. Z vašeho hlediska se však ostatní hráèi nacházejí v normálních vzdálenostech.";
            case SCOPE ->
                    "Jestliže máte ve høe Hledí, všichni ostatní hráèi se pro vás nachází ve vzdálenosti o 1 menší. Z pohledu ostatních hráèù se však vy sami nacházíte v bìžné vzdálenosti. Vzdálenosti nižší než 1 se považují za rovné 1.";
            case JAIL ->
                    "\"Lízni si!\" Tuto kartu mùžete vyložit pøed libovolného hráèe s výjimkou Šerifa, èímž ho uvìzníte! Pokud se ocitnete ve vìzení, na zaèátku svého tahu, tj. pøed 1. fází (dob-ráním dvou karet), „sejmìte“. Jestliže otoèíte srdcovou kartu, podaøí se vám z vì-zení uprchnout; karta Vìzení se odhodí a pokraèujete normálnì svým tahem. V opaèném pøípadì se karta Vìzení odhodí a vy o svùj tah pøijdete. Stále však zùstá-váte možným cílem pro karty BANG! a mùžete hrát karty Vedle! a Pivo mimo vlastní tah.";
            case DYNAMITE ->
                    "\"Lízni si!\" Jestliže zahrajete tuto kartu, vyložte ji pøed sebe. Dynamit zde zùstane, dokud ne-pøijdete znovu na øadu. Jakmile zaène váš další tah (a Dynamit je stále ve høe), musíte pøed 1. fází (dobráním dvou karet) „sejmout“: pokud otoèíte kartu mezi pikovou dvojkou a devítkou vèetnì, Dynamit exploduje (odhodí se) a ztrácíte okamžitì 3 životy. V opaèném pøípadì se Dynamit pøesune k hráèi po vaší levici, který ve svém tahu provede totéž ovìøení. Hráèi si mezi sebou Dynamit pøesunují, dokud neexploduje (s výše popsaným efektem) nebo není odstranìn kartami jako Panika! nebo Cat Balou. Pokud se Dynamit ocitne u jednoho hráèe souèasnì s kar-tou Vìzení, jako první se vyhodnotí Dynamit. Když je postava zabita Dynamitem, nepøipisuje se toto zabití žádnému z hráèù.";
            case VOLCANIC ->
                    "Jestliže máte ve høe tuto kartu, mùžete hrát ve svém tahu libovolný poèet karet BANG! Tyto karty mohou mít za cíl jednoho èi více hráèù, ovšem pouze ve vzdálenosti 1.";
            case SCHOFIELD -> "Pøi vyložení zvyšuje dosah na 2.";
            case REMINGTON -> "Pøi vyložení zvyšuje dosah na 3.";
            case REV_CARBINE -> "Pøi vyložení zvyšuje dosah na 4.";
            case WINCHESTER -> "Pøi vyložení zvyšuje dosah na 5.";
        };
    }


    @Override
    public String toString() {
        return name.toString() + " (" + super.toString() + ")";
    }
}