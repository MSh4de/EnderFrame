package eu.mshade.enderframe.world;

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
}
