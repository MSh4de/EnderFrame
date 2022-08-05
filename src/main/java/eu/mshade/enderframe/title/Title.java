package eu.mshade.enderframe.title;

import eu.mshade.enderframe.entity.Player;
import eu.mshade.enderframe.mojang.chat.TextComponent;
import eu.mshade.enderframe.protocol.SessionWrapper;

public class Title {

    protected TextComponent title;
    protected TextComponent subtitle;
    protected TitleTime titleTime;

    public void showTitle(Player player) {
        SessionWrapper sessionWrapper = player.getSessionWrapper();
        sessionWrapper.sendTitle(TitleAction.SET_TITLE, this);

        if (subtitle != null) {
            sessionWrapper.sendTitle(TitleAction.SET_SUBTITLE, this);
        }

        if (titleTime != null) {
            sessionWrapper.sendTitle(TitleAction.SET_TIME, this);
        }
    }

    public void hide(Player player) {
        player.getSessionWrapper().sendTitle(TitleAction.HIDE, null);
    }

    public void reset(Player player) {
        player.getSessionWrapper().sendTitle(TitleAction.RESET, null);
    }

    public Title setTitle(TextComponent title) {
        this.title = title;
        return this;
    }

    public Title setSubtitle(TextComponent subtitle) {
        this.subtitle = subtitle;
        return this;
    }

    public Title setTitleTime(TitleTime titleTime) {
        this.titleTime = titleTime;
        return this;
    }

    public TextComponent getTitle() {
        return title;
    }

    public TextComponent getSubtitle() {
        return subtitle;
    }

    public TitleTime getTitleTime() {
        return titleTime;
    }

    @Override
    public String toString() {
        return "Title{" +
                "title=" + title +
                ", subtitle=" + subtitle +
                ", titleTime=" + titleTime +
                '}';
    }
}
