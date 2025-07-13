package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */
public enum Character {
    BART_CASSIDY("BART CASSIDY"),
    BLACK_JACK("BLACK JACK"),
    CALAMITY_JANET("CALAMITY JANET"),
    EL_GRINGO("EL GRINGO"),
    JESSE_JONES("JESSE JONES"),
    JOURDONNAIS("JOURDONNAIS"),
    KIT_CARLSON("KIT CARLSON"),
    LUCKY_DUKE("LUCKY DUKE"),
    PAUL_REGRET("PAUL REGRET"),
    PEDRO_RAMIREZ("PEDRO RAMIREZ"),
    ROSE_DOOLAN("ROSE DOOLAN"),
    SID_KETCHUM("SID KETCHUP"),
    SLAB_THE_KILLER("SLAB THE KILLER"),
    SUZY_LAFAYETTE("SUZY LAFAYETTE"),
    VULTURE_SAM("VULTURE SAM"),
    WILLY_THE_KID("WILLY THE KID");

    /**
     * Name of character
     */
    private final String name;

    /**
     * Creates a new Character.
     *
     * @param name name of character
     */
    Character(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Gets a string representation of the file name
     *
     * @return string representation of the file name
     */
    public String getFilenameString() {
        return name.replaceAll(" ", "_");
    }
}
