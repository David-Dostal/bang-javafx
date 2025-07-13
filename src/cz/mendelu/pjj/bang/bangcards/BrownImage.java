package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */
public enum BrownImage {
    BANG("./resources/brown/bang.png"),
    MISSED("./resources/brown/missed.png"),
    BEER("./resources/brown/beer.png"),
    CAT_BALOU("./resources/brown/cat_balou.png"),
    STAGECOACH("./resources/brown/stagecoach.png"),
    PANIC("./resources/brown/panic.png"),
    DUEL("./resources/brown/duel.png"),
    WELLS_FARGO("./resources/brown/wells_fargo.png"),
    GATLING("./resources/brown/gatling.png"),
    INDIANS("./resources/brown/indians.png"),
    GENERAL_STORE("./resources/brown/general_store.png"),
    SALOON("./resources/brown/saloon.png");
    /**
     * Path to the image
     */
    private final String path;

    /**
     * Creates a new path to the brown card's image.
     *
     * @param path path to the brown card's image
     */
    BrownImage(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
