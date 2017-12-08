package sample;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

public enum Sound {

    SOUNDERROR("resources/media/error.wav"),
    SOUNDACIERTO("resources/media/acierto.wav"),
    SOUNDWIN("resources/media/victoria.wav"),
    SOUNDOVER("resources/media/gameover.wav");

    public enum Volume {
        MUTE, LOW
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
    /* public void stop(){
        clip.stop();
    }*/
    //~ public void mute() {
    //~ volume = Volume.MUTE;
    //~ }
    // Optional static method to pre-load all the sound files.
    /* static void init() {
        values(); // calls the constructor for all the elements
    }*/

}
