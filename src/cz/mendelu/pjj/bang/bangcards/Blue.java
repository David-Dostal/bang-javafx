package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */
public enum Blue {
    BARREL("Barrel"),
    MUSTANG("Mustang"),
    SCOPE("Scope"),
    JAIL("Jail"),
    DYNAMITE("Dynamite"),
    VOLCANIC("Volcanic"),
    SCHOFIELD("Schofield"),
    REMINGTON("Remington"),
    REV_CARBINE("Rev Carbine"),
    WINCHESTER("Winchester");

    /**
     * Name of blue card
     */
    private final String name;

    /**
     * Creates a new blue card name.
     *
     * @param name name of blue card
     */
    Blue(String name) {
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