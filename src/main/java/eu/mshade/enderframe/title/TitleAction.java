package eu.mshade.enderframe.title;

public enum TitleAction {

    SET_TITLE(0),
    SET_SUBTITLE(1),
    SET_TIME(2),
    HIDE(3),
    RESET(4);

    private final int action;

    TitleAction(int action) {
        this.action = action;
    }

    public int getAction() {
        return action;
    }
}
