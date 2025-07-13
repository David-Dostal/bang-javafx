package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */
public enum Brown {
    BANG("Bang"),
    MISSED("Missed"),
    BEER("Beer"),
    CAT_BALOU("Cat Balou"),
    STAGECOACH("Stagecoach"),
    PANIC("Panic"),
    DUEL("Duel"),
    WELLS_FARGO("Wells Fargo"),
    GATLING("Gatling"),
    INDIANS("Indians"),
    GENERAL_STORE("General Store"),
    SALOON("Saloon");

    /**
     * Name of brown card
     */
    private final String name;

    /**
     * Creates a new brown card name.
     *
     * @param name name of brown card
     */
    Brown(String name) {
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
        return name.replaceAll(" ", "_").toUpperCase();
    }


}
