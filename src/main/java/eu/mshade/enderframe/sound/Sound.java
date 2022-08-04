package eu.mshade.enderframe.sound;

import eu.mshade.enderframe.entity.Player;

public class Sound {

    protected final SoundName soundName;
    protected final SoundPosition soundPosition;
    protected final float soundVolume;

    public Sound(SoundName soundName, SoundPosition soundPosition, float soundVolume) {
        this.soundName = soundName;
        this.soundPosition = soundPosition;
        this.soundVolume = soundVolume;
    }

    public void createSound(Player player) {
        player.getSessionWrapper().sendSoundEffect(this);
    }

    public SoundName getSoundName() {
        return soundName;
    }

    public SoundPosition getSoundPosition() {
        return soundPosition;
    }

    public float getSoundVolume() {
        return soundVolume;
    }
}
