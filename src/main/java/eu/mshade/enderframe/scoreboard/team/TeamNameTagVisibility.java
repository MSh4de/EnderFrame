package eu.mshade.enderframe.scoreboard.team;

public enum TeamNameTagVisibility {

    ALWAYS("always"),
    HIDE_FOR_OTHER_TEAMS("hideForOtherTeams"),
    HIDE_FOR_OWN_TEAM("hideForOwnTeam"),
    NEVER("never");

    private final String nameTagVisibility;

    TeamNameTagVisibility(String nameTagVisibility) {
        this.nameTagVisibility = nameTagVisibility;
    }

    public String getNameTagVisibility() {
        return nameTagVisibility;
    }
}
