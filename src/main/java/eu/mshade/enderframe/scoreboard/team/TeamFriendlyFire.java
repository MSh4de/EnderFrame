package eu.mshade.enderframe.scoreboard.team;

public enum TeamFriendlyFire {

    OFF(0),
    ON(1),
    FRIENDLY_INVISIBLES(3);

    private final int friendlyFire;

    TeamFriendlyFire(int friendlyFire) {
        this.friendlyFire = friendlyFire;
    }

    public int getFriendlyFire() {
        return friendlyFire;
    }
}
