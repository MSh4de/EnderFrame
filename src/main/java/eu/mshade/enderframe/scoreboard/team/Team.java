package eu.mshade.enderframe.scoreboard.team;

import eu.mshade.enderframe.mojang.chat.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Team {

    private final TeamMode teamMode;
    private final TeamNameTagVisibility teamNameTagVisibility;
    private final TeamFriendlyFire teamFriendlyFire;
    private final ChatColor teamColor;
    private String teamName = "";
    private String teamDisplayName = "";
    private String teamPrefix = "";
    private String teamSuffix = "";
    private int playerCount = 0;
    private List<String> playersName = new ArrayList<>();

    public Team(TeamBuilder teamBuilder) {
        this.teamMode = teamBuilder.teamMode;
        this.teamNameTagVisibility = teamBuilder.teamNameTagVisibility;
        this.teamFriendlyFire = teamBuilder.teamFriendlyFire;
        this.teamName = teamBuilder.teamName;
        this.teamDisplayName = teamBuilder.teamDisplayName;
        this.teamPrefix = teamBuilder.teamPrefix;
        this.teamSuffix = teamBuilder.teamSuffix;
        this.teamColor = teamBuilder.teamColor;
        this.playerCount = teamBuilder.playersName.size();
        this.playersName = teamBuilder.playersName;
    }

    public TeamMode getTeamMode() {
        return teamMode;
    }

    public TeamNameTagVisibility getTeamNameTagVisibility() {
        return teamNameTagVisibility;
    }

    public TeamFriendlyFire getTeamFriendlyFire() {
        return teamFriendlyFire;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getTeamDisplayName() {
        return teamDisplayName;
    }

    public String getTeamPrefix() {
        return teamPrefix;
    }

    public String getTeamSuffix() {
        return teamSuffix;
    }

    public ChatColor getTeamColor() {
        return teamColor;
    }

    public int getPlayerCount() {
        return playerCount;
    }

    public List<String> getPlayersName() {
        return playersName;
    }

    public static class TeamBuilder {
        private TeamMode teamMode;
        private TeamNameTagVisibility teamNameTagVisibility;
        private TeamFriendlyFire teamFriendlyFire;
        private ChatColor teamColor;
        private String teamName;
        private String teamDisplayName;
        private String teamPrefix;
        private String teamSuffix;
        private List<String> playersName;

        public TeamBuilder setTeamMode(TeamMode teamMode) {
            this.teamMode = teamMode;
            return this;
        }

        public TeamBuilder setTeamNameTagVisibility(TeamNameTagVisibility teamNameTagVisibility) {
            this.teamNameTagVisibility = teamNameTagVisibility;
            return this;
        }

        public TeamBuilder setTeamFriendlyFire(TeamFriendlyFire teamFriendlyFire) {
            this.teamFriendlyFire = teamFriendlyFire;
            return this;
        }

        public TeamBuilder setTeamName(String teamName) {
            this.teamName = teamName;
            return this;
        }

        public TeamBuilder setTeamDisplayName(String teamDisplayName) {
            this.teamDisplayName = teamDisplayName;
            return this;
        }

        public TeamBuilder setTeamPrefix(String teamPrefix) {
            this.teamPrefix = teamPrefix;
            return this;
        }

        public TeamBuilder setTeamSuffix(String teamSuffix) {
            this.teamSuffix = teamSuffix;
            return this;
        }

        public TeamBuilder setTeamColor(ChatColor teamColor) {
            this.teamColor = teamColor;
            return this;
        }

        public TeamBuilder setPlayersName(List<String> playersName) {
            this.playersName = playersName;
            return this;
        }

        public Team buildTeam() {
            return new Team(this);
        }
    }
}