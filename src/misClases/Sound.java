package misClases;

import java.io.BufferedInputStream;
import java.io.InputStream;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public enum Sound {

    SOUNDERROR("/res/media/error.wav"),
    SOUNDACIERTO("/res/media/acierto.wav"),
    SOUNDWIN("/res/media/victoria.wav"),
    SOUNDOVER("/res/media/gameover.wav");

    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH
    }

    public static Volume volume = Volume.LOW;

    private Clip clip;

    Sound(String fileName){

        try (InputStream audio = getClass().getResourceAsStream(fileName)) {
            InputStream buffer = new BufferedInputStream(audio);
            try (AudioInputStream sound = AudioSystem.getAudioInputStream(buffer)) {
                clip = AudioSystem.getClip();
                clip.open(sound);
            }
        } catch (Exception e) {
           e.printStackTrace();
        }

    }

    // play, stop, loop the sound clip
    public void play(){
        if (volume != Volume.MUTE) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0);
            clip.start();
        }
    }
    public void stop(){
        clip.stop();
    }
    //~ public void mute() {
        //~ volume = Volume.MUTE;
    //~ }
    // Optional static method to pre-load all the sound files.
    static void init() {
        values(); // calls the constructor for all the elements
    }
}
