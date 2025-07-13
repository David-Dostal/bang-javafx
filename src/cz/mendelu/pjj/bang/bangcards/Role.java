package cz.mendelu.pjj.bang.bangcards;

/**
 * @author xdostal8
 */

public enum Role {
    SHERIFF("SHERIFF"),
    DEPUTY("DEPUTY"),
    OUTLAW("OUTLAW"),
    RENEGADE("RENEGADE");
    /**
     * Name of role card
     */
    private final String name;

    /**
     * Creates a new role card name.
     *
     * @param name name of role card
     */
    Role(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
