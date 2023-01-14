package eu.mshade.enderframe.world;

public enum Difficulty {

    PEACEFUL(0),
    EASY(1),
    NORMAL(2),
    HARD(3);

    private int id;

    Difficulty(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
