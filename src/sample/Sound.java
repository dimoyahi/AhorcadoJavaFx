/*
 * EL AHORCADO. Sound.java
 *
 * Aplicación de escritorio que revive el clásico juego de lápiz y papel 'El Ahorcado'
 *
 * AUTOR: Jesús Cuerda
 *
 * VERSION: 1.1 - Actualizado: 19/12/2017
 *
 * LICENCIA: Software libre de código abierto sujeto a la GNU General Public License v.3,
 * distribuido con la esperanza de que sea útil, pero SIN NINGUNA GARANTÍA.
 * Todos los errores reservados.
 *
 * VER EN: https://github.com/Webierta/AhorcadoJavaFx
 */

package sample;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.BufferedInputStream;
import java.io.InputStream;

/**
 * Gestiona los efectos de sonido del juego
 */
public enum Sound {

    SOUNDERROR("resources/media/error.wav"),
    SOUNDACIERTO("resources/media/acierto.wav"),
    SOUNDWIN("resources/media/victoria.wav"),
    SOUNDOVER("resources/media/gameover.wav");

    private boolean volumen;
    private Clip clip;

    /**
     * Constructor
     * @param fileName Ruta del archivo de sonido
     */
    Sound(String fileName){
        volumen = true;
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

    /**
     * Cambia variable volumen
     * @param volumen boolean
     */
    public void setVolumen(boolean volumen){
        this.volumen = volumen;
    }

    /**
     * Obtiene valor de volumen
     * @return boolean
     */
    private boolean isVolumen(){
        return volumen;
    }

    /**
     * Reproduce el sonido
     */
    public void play(){
        if(isVolumen()){
            if (clip.isRunning()) {
                clip.stop();
            }
            clip.setFramePosition(0);
            clip.start();
        }
    }

}
