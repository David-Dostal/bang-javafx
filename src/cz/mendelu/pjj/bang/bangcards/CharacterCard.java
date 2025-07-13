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
            case BART_CASSIDY -> "(4 životy): Vždy, když ztratíte život, doberte si okamžitì jednu kartu z " +
                    "\nbalíèku hracích karet. Tato schopnost neúèinkuje, pokud byste mìli ztratit svùj poslední život.";
            case BLACK_JACK -> "(4 životy): Ve svém tahu v 1. fázi musíte ukázat ostatním druhou kartu, kterou si " +
                    "\ndobíráte. Pokud je srdcová nebo kárová, doberte si ještì jednu kartu (tu ostatním neukazujte).";
            case CALAMITY_JANET -> """
                    (4 životy): Mùžete používat karty BANG! jako Vedle ! a naopak.\s
                    Když zahrajete ve svém tahu kartu Vedle ! jako BANG!, nemùžete zahrát další kartu BANG!\s
                    (pokud nemáte ve høe Volcanic).""";
            case EL_GRINGO -> """
                    (3 životy): Vždy, když díky nìjakému hráèi ztratíte životy, vezmìte si z jeho ruky
                    náhodnì jednu kartu za každý život, o který pøijdete. Tato schopnost neúèinkuje, pokud byste\s
                    mìli ztratit svùj poslední život. Když dotyèný hráè nemá v ruce dostatek karet, respektive žádné\s
                    karty, máte smùlu ! Nezapomeòte, že zranìní zpùsobená Dynamitem se ne pøiøazují žádnému hráèi.\s
                    Jestliže zahrajete Duel a pøijdete o život, protože neodhodíte kartu BANG!, kartu si od protivníka neberete.""";
            case JESSE_JONES -> "(4 životy): Ve svém tahu v 1. fázi si mùžete vybrat, zda si první kartu vezmete " +
                    "\nnáhodnì z ruky jiného hráèe nebo doberte z dobíracího balíèku. Druhou kartu si vždy dobíráte z balíèku.";
            case JOURDONNAIS -> """
                    (4 životy): Díky schopnosti této postavy máte k dispozici imaginární Barel, tj.\s
                    mùžete „sejmout“, jsteli cílem efektu BANG!, a pøi otoèení srdcové karty je tento efekt zrušen.\s
                    Skuteènou kartu Barel mùžete mít ve høe rovnìž, takže máte možnost zkusit zrušit efekt BANG! dvakrát, aniž byste museli hrát kartu Vedle!\s""";
            case KIT_CARLSON -> "(4 životy): Ve svém tahu v 1. fázi se mùžete podívat na vrchní tøi karty z \n" +
                    "dobíracího balíèku ; dvì z nich si doberte a zbývající položte zpìt na vršek balíèku lícem dolù.";
            case LUCKY_DUKE -> "(4 životy): Kdykoli máte „sejmout“, otoète vrchní dvì karty z dobíracího balíèku \n" +
                    "a vyberte si, kterou z nich použijete. Obì karty se potom odhodí. ";
            case PAUL_REGRET -> """
                    (3 životy) : Díky schopnosti této postavy máte k dispozici imaginárního Mustanga;
                     pro ostatní hráèe se tedy nacházíte ve vzdálenosti o 1 vyšší. Skuteènou kartu Mustang mùžete mít
                     ve høe rovnìž; v takovém pøípadì se budete pro ostatní nacházet ve vzdálenosti dokonce o 2 vìtší.""";
            case PEDRO_RAMIREZ -> "(4 životy): Ve svém tahu v 1. fázi si mùžete vybrat, zda si první kartu vezmete \n" +
                    "z vršku hromádky odhozených nebo doberte z dobíracího balíèku. Druhou kartu si vždy dobíráte z balíèku. ";
            case ROSE_DOOLAN -> """
                    (4 životy): Díky schopnosti této postavy máte k dispozici imaginární Hledí;\s
                    ostatní hráèi se tedy pro vás nachází ve vzdálenosti o 1 menší. Skuteènou kar tu Hledí mùžete\s
                    mít ve høe rovnìž; v takovém pøípadì se pro vás budou ostatní nacházet ve vzdálenosti dokonce o 2 menší.""";
            case SID_KETCHUM -> """
                    (4 životy): Mùžete kdykoli odhodit dvì karty z ruky a vyléèit si tak jeden\s
                    život. Pokud chcete a mùžete, smíte tuto schopnost použít vícekrát za tah. Nezapomeòte ale,\s
                    že nemùže mít více životù, než kolik èiní poèáteèní množství. Takto se mùžete zachránit, i\s
                    kdybyste mìli pøijít o poslední život.\s""";
            case SLAB_THE_KILLER -> "(4 životy): Hráè, který chce zrušit vaši kartu BANG!, musí použít dva \n" +
                    "efekty Vedle ! Úspìšné „sejmutí“ u karty Barel zastoupí pouze jeden z nich. ";
            case SUZY_LAFAYETTE -> """
                    (4 životy): Jakmile nemáte v ruce žádnou kartu, smíte si dobrat jednu\s
                    kartu z dobíracího balíèku. Bìhem Duelu tato schopnost nefunguje: jestliže máte jako poslední\s
                    kartu v ruce BANG!, který odhodíte, a druhý hráè odhodí následnì rovnìž kartu BANG!, prohráváte\s
                    a ztrácíte život. Teprve poté si doberete kartu. Jestliže èelíte kartì BANG! zahrané Slabem the\s
                    Killerem a máte v ruce jako poslední kartu Vedle !, mùžete ji zahrát a dobrat si další kartu.\s
                    Jestliže to bude rovnìž Vedle !, smíte ho zahrát a Slabùv BANG! tak zrušit.""";
            case VULTURE_SAM -> """
                    (4 životy): Kdykoli je nìjaká postava zabita, vezmìte si do ruky všechny karty,\s
                    které má její hráè v ruce a ve høe. Pokud jste Šerifem a zabijete svého Zástupce,\s
                    nejprve si vezmìte do ruky všechny uvedené karty zabité postavy, avšak ihned poté je\s
                    musíte spolu se všemi svými pùvodními kartami odhodit.""";
            case WILLY_THE_KID -> "(4 životy): Ve svém tahu smíte zahrát libovolný poèet karet BANG!";
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