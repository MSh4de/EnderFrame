package eu.mshade.enderframe.world;

import java.util.Objects;

public class WorldLevel {

    private String name;
    private long seed;
    private LevelType levelType;
    private Dimension dimension;
    private Difficulty difficulty;

    public WorldLevel(String name, long seed, LevelType levelType, Dimension dimension, Difficulty difficulty) {
        this.name = name;
        this.seed = seed;
        this.levelType = levelType;
        this.dimension = dimension;
        this.difficulty = difficulty;
    }

    public String getName() {
        return name;
    }

    public long getSeed() {
        return seed;
    }

    public LevelType getLevelType() {
        return levelType;
    }

    public Dimension getDimension() {
        return dimension;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorldLevel that = (WorldLevel) o;
        return seed == that.seed && Objects.equals(name, that.name) && levelType == that.levelType && dimension == that.dimension && difficulty == that.difficulty;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, seed, levelType, dimension, difficulty);
    }
}
