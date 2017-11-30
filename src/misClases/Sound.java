package misClases;

import java.io.File;
import java.io.IOException;
//~ import java.net.MalformedURLException;
//~ import java.net.URL;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public enum Sound {

    SOUNDERROR("./res/media/error.wav"),
    SOUNDACIERTO("./res/media/acierto.wav"),
    SOUNDWIN("./res/media/victoria.wav"),
    SOUNDOVER("./res/media/gameover.wav");

    public static enum Volume {
        MUTE, LOW, MEDIUM, HIGH
    }

    public static Volume volume = Volume.LOW;

    private Clip clip;

    Sound(String fileName) {
        try {
            File file = new File(fileName);
            if (file.exists()) {
                AudioInputStream sound = AudioSystem.getAudioInputStream(file);
                clip = AudioSystem.getClip();
                clip.open(sound);
            } else {
                throw new RuntimeException("Sound: file not found: " + fileName);
            }
            //~ URL url = this.getClass().getClassLoader().getResource(fileName);
            //~ AudioInputStream sound = AudioSystem.getAudioInputStream(url);
            //~ clip = AudioSystem.getClip();
            //~ clip.open(sound);
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Unsupported Audio File: " + e);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Input/Output Error: " + e);
        } catch (LineUnavailableException e) {
            e.printStackTrace();
            throw new RuntimeException("Sound: Line Unavailable Exception Error: " + e);
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
    //~ public void loop(){
        //~ clip.loop(Clip.LOOP_CONTINUOUSLY);
    //~ }
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
