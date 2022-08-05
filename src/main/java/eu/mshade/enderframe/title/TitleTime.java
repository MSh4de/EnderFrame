package eu.mshade.enderframe.title;

public class TitleTime {

    private final int fadeIn;
    private final int stay;
    private final int fadeOut;

    public TitleTime(int fadeIn, int stay, int fadeOut) {
        this.fadeIn = fadeIn;
        this.stay = stay;
        this.fadeOut = fadeOut;
    }

    public int getFadeIn() {
        return fadeIn;
    }

    public int getStay() {
        return stay;
    }

    public int getFadeOut() {
        return fadeOut;
    }

    @Override
    public String toString() {
        return "TitleTime{" +
                "fadeIn=" + fadeIn +
                ", stay=" + stay +
                ", fadeOut=" + fadeOut +
                '}';
    }
}
