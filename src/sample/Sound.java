/*
 * EL AHORCADO. Sound.java
 *
 * Aplicación de escritorio que revive el clásico juego de lápiz y papel 'El Ahorcado'
 *
 * AUTOR: Jesús Cuerda
 *
 * VERSION: 1.0 - Actualizado: 10/12/2017
 *
 * LICENCIA: Software libre de código abierto sujeto a la GNU General Public License v.3,
 * distribuido con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA.
 * Todos los errores reservados.
 *
 * VER EN: https://github.com/Webierta/AhorcadoJavaFx *
 */

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

    private enum Volume {
        MUTE, LOW
    }
    //public static Volume volume = Volume.LOW;
    private static  Volume volume; // = Volume.LOW;
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

    public static void mute(){
        volume = Volume.MUTE;
    }
    public static void noMute(){
        volume = Volume.LOW;
    }

    public void play(){
        if (volume != Volume.MUTE) {
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0);
            clip.start();
        }
    }

}
