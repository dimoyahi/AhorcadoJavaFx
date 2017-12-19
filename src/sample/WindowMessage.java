/*
 * EL AHORCADO. WindowMessage.java
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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * Ventana con un mensaje
 */
public class WindowMessage {

    /**
     * Muestra la ventana modal
     * @param message Contenido del mensaje
     * @param title Título de la ventana
     */
    public static void show(String message, String title) {

        final Stage STAGE = new Stage();
        STAGE.initModality(Modality.APPLICATION_MODAL);
        STAGE.setTitle(title);
        STAGE.setMinWidth(350);

        Label lbl = new Label();
        lbl.setText(message);
        lbl.setFont(new Font(24.0));
        lbl.setAlignment(Pos.CENTER);

        Button btnOK = new Button();
        btnOK.setText("OK");
        btnOK.setPrefWidth(80.0);
        btnOK.setOnAction(e -> STAGE.close());

        VBox pane = new VBox(20);
        pane.setSpacing(30);
        pane.setPadding(new Insets(10, 20, 10, 20));
        pane.getChildren().addAll(lbl, btnOK);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        STAGE.setScene(scene);
        STAGE.showAndWait();
    }

}
