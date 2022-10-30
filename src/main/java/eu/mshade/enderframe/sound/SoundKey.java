package eu.mshade.enderframe.sound;

public interface SoundKey {

    String name();

    static SoundKey fromName(String name){
        return new DefaultSoundKey(name);
    }

    record DefaultSoundKey(String name) implements SoundKey {

    }
}
