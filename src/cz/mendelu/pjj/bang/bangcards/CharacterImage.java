package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */
public enum CharacterImage {
    BART_CASSIDY("./resources/char/bart_cassidy.png"), //
    BLACK_JACK("./resources/char/black_jack.png"), //
    CALAMITY_JANET("./resources/char/calamity_janet.png"), //Done
    EL_GRINGO("./resources/char/el_gringo.png"), //
    JESSE_JONES("./resources/char/jesse_jones.png"), //
    JOURDONNAIS("./resources/char/jourdonnais.png"), //
    KIT_CARLSON("./resources/char/kit_carlson.png"), //
    LUCKY_DUKE("./resources/char/lucky_duke.png"), //
    PAUL_REGRET("./resources/char/paul_regret.png"), //Done
    PEDRO_RAMIREZ("./resources/char/pedro_ramirez.png"), //Done
    ROSE_DOOLAN("./resources/char/rose_doolan.png"), //
    SID_KETCHUP("./resources/char/sid_ketchup.png"), //
    SLAB_THE_KILLER("./resources/char/slab_the_killer.png"), //
    SUZY_LAFAYETTE("./resources/char/suzy_lafayette.png"), //Done
    VULTURE_SAM("./resources/char/vulture_sam.png"), //
    WILLY_THE_KID("./resources/char/willy_the_kid.png"); //

    /**
     * Path to the image
     */
    private final String path;

    /**
     * Creates a new path to the character card's image.
     *
     * @param path path to the character card's image
     */
    CharacterImage(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
