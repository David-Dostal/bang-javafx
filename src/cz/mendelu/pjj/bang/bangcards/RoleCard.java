package cz.mendelu.pjj.bang.bangcards;

import cz.mendelu.pjj.bang.cards.Card;

/**
 * @author xdostal8
 */

public class RoleCard extends Card {
    /**
     * Role on card
     *
     * @see Role
     */
    private final Role role;

    /**
     * Create a new role card.
     *
     * @param role role of card
     */
    public RoleCard(Role role) {
        super(RoleImage.valueOf(role.toString()).toString());
        this.role = role;

    }

    /**
     * Get the role of the card.
     *
     * @return role on card
     * @see Role
     */
    public Role role() {
        return role;
    }

    /**
     * Get a String description of the role card.
     *
     * @return description on card
     */
    public String description() {
        if (role == Role.SHERIFF)
            return "Zabij všechny Bandity a Odpadlíka!";
        else if (role == Role.DEPUTY)
            return "Ochraňuj Šerifa! Zabij všechny Bandity a Odpadlíka!";
        else if (role == Role.OUTLAW)
            return "Zabij Šerifa!";
        else
            return "Zůstaň poslední naživu!";
    }

    @Override
    public String toString() {
        return role.toString();
    }
}