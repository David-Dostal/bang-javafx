package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */
public enum BlueImage {
    BARREL("./resources/blue/barrel.png"),
    MUSTANG("./resources/blue/mustang.png"),
    SCOPE("./resources/blue/scope.png"),
    JAIL("./resources/blue/jail.png"),
    DYNAMITE("./resources/blue/dynamite.png"),
    VOLCANIC("./resources/blue/volcanic.png"),
    SCHOFIELD("./resources/blue/schofield.png"),
    REMINGTON("./resources/blue/remington.png"),
    REV_CARBINE("./resources/blue/rev_carbine.png"),
    WINCHESTER("./resources/blue/winchester.png");
    /**
     * Path to the image
     */
    private final String path;

    /**
     * Creates a new path to the blue card's image.
     *
     * @param path path to the blue card's image
     */
    BlueImage(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }
}
