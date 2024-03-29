package eu.mshade.enderframe.sound;

import eu.mshade.enderframe.entity.Player;

public class SoundEffect {

    protected final String soundName;
    protected final SoundPosition soundPosition;
    protected final float soundVolume;
    protected final int soundPitch;

    public SoundEffect(SoundKey soundKey, SoundPosition soundPosition, float soundVolume, int soundPitch) {
        this.soundName = soundKey.name();
        this.soundPosition = soundPosition;
        this.soundVolume = soundVolume;
        this.soundPitch = soundPitch;
    }

    public SoundEffect(String soundName, SoundPosition soundPosition, float soundVolume, int soundPitch) {
        this.soundName = soundName;
        this.soundPosition = soundPosition;
        this.soundVolume = soundVolume;
        this.soundPitch = soundPitch;
    }

    public void createSound(Player player) {
        player.getMinecraftSession().sendSoundEffect(this);
    }

    public String getSoundName() {
        return soundName;
    }

    public SoundPosition getSoundPosition() {
        return soundPosition;
    }

    public float getSoundVolume() {
        return soundVolume;
    }

    public int getSoundPitch() {
        return soundPitch;
    }
}
