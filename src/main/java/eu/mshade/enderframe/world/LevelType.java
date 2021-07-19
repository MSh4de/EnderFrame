package eu.mshade.enderframe.world;

public enum LevelType {

    DEFAULT("default"),
    FLAT("flat"),
    LARGEBIOMES("largeBiomes"),
    AMPLIFIED("amplified"),
    DEFAULT_1_1("default_1_1");

    private String name;

    LevelType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
