package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */

public enum RoleImage {
    SHERIFF("./resources/role/sheriff.png"),
    DEPUTY("./resources/role/deputy.png"),
    OUTLAW("./resources/role/outlaw.png"),
    RENEGADE("./resources/role/renegade.png");


    private final String path;

    /**
     * Creates a new path to the character role's image.
     *
     * @param path path to the character role's image
     */
    RoleImage(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return path;
    }

    public String getPath() {
        return path;
    }
}
