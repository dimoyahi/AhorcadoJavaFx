/*
 * EL AHORCADO. WindowAbout.java
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

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowAbout {

    public static void show() {

        ScrollPane scrollPane = new ScrollPane();

        String textAyuda1 = "Juego del Ahorcado - Versión: 1.0\n";
        String textAyuda2 = "Copyleft 2017 - Jesús Cuerda - Todos los "
                + "errores reservados\n";
        String textAyuda3 = "Aplicación gratuita y sin publicidad."
                + "\nColabora con un donativo vía ";
        String textRequisitos = "REQUISITOS\n";
        String textAyuda5 = "Aplicación multiplataforma desarrollada con "
                + "lenguaje de programación JAVA (OpenJDK 8).\n"
                + "Requiere tener instalado JRE (Java Runtime Environment) "
                + "disponible en ";
        String textAyuda51 = ". En linux, según la distribución, el paquete de "
                + "la versión libre puede recibir distintos nombres, como "
                + "openjdk-8, openjdk-8-jre o java-1.8.0-openjdk.\n\n";
        String textLicencia = "LICENCIA\n";
        String textAyuda7 = "Software libre de código abierto sujeto a la GNU "
                + "General Public License v.3. EL AHORCADO es software libre "
                + "distribuido con la esperanza de que sea útil, pero SIN NINGUNA "
                + "GARANTÍA.\n\n";
        String textAyuda8 = "This file is part of EL AHORCADO.\n"
                + "EL AHORCADO is free software: you can redistribute it and/or modify "
                + "it under the terms of the GNU General Public License as published by "
                + "the Free Software Foundation either version 3 of the License.\n"
                + "EL AHORCADO is distributed in the hope that it will be useful, "
                + "but WITHOUT ANY WARRANTY; without even the implied warranty of "
                + "MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the "
                + "GNU General Public License for more details. ";
        String textAyuda9 = "\n\nNota: Al pulsar un enlace se copia la "
                + "dirección en el portapapeles. Pégala en la barra de direcciones "
                + "de tu navegador para ir al enlace.";
        Text text1 = new Text(textAyuda1);
        Text text2 = new Text(textAyuda2);
        Text text3 = new Text(textAyuda3);
        Text text4 = new Text(textRequisitos);
        Text text5 = new Text(textAyuda5);
        Text text51 = new Text(textAyuda51);
        Text text6 = new Text(textLicencia);
        Text text7 = new Text(textAyuda7);
        Text text8 = new Text(textAyuda8);
        Text text9 = new Text(textAyuda9);

        Clipboard clipboard = Clipboard.getSystemClipboard();
        ClipboardContent content = new ClipboardContent();

        Hyperlink linkJava = new Hyperlink();
        linkJava.setText("JAVA");
        linkJava.setOnAction(e -> {
            content.putString("https://www.java.com/es/");
            clipboard.setContent(content);
        });
        Hyperlink linkPaypal = new Hyperlink();
        linkPaypal.setText("PayPal");
        linkPaypal.setOnAction(e -> {
            content.putString(
                    "https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=986PSAHLH6N4L");
            clipboard.setContent(content);
        });
        Hyperlink linkGNU = new Hyperlink();
        linkGNU.setText("GNU General Public License");
        linkGNU.setOnAction(e -> {
            content.putString("https://www.gnu.org/licenses/gpl-3.0.txt");
            clipboard.setContent(content);
        });

        text1.setFont(new Font(22.0));
        text2.setFont(new Font(20.0));
        text3.setFont(new Font(18.0));
        text1.setStyle("-fx-font-weight: bold");
        text1.setStyle("-fx-text-alignment: center");
        text2.setStyle("-fx-alignment: center");
        text3.setTextAlignment(TextAlignment.CENTER);

        text4.setFont(new Font(14.0));
        text4.setStyle("-fx-font-weight: bold");
        text5.setFont(new Font(14.0));
        text51.setFont(new Font(14.0));
        text6.setFont(new Font(14.0));
        text6.setStyle("-fx-font-weight: bold");
        text7.setFont(new Font(14.0));
        text8.setFont(new Font(14.0));

        text9.setFont(new Font(12.0));
        text9.setFill(Color.RED);

        TextFlow textFlowPane = new TextFlow();
        textFlowPane.setTextAlignment(TextAlignment.CENTER);
        textFlowPane.setPrefSize(700, 50);
        textFlowPane.setLineSpacing(5.0);
        textFlowPane.getChildren().addAll(text1, text2, text3, linkPaypal);

        TextFlow textFlowPane2 = new TextFlow();
        textFlowPane2.setTextAlignment(TextAlignment.JUSTIFY);
        textFlowPane2.setPrefSize(700, 480);
        textFlowPane2.setLineSpacing(3.0);
        textFlowPane2.getChildren().addAll(text4, text5, linkJava, text51,
                text6, text7, text8, linkGNU, text9);

        VBox pane = new VBox();
        pane.setSpacing(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().addAll(textFlowPane, textFlowPane2);
        pane.setAlignment(Pos.CENTER);

        scrollPane.setContent(pane);
        scrollPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);  //ALWAYS
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.AS_NEEDED);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("JUEGO DEL AHORCADO");
        Scene scene = new Scene(scrollPane, 750, 650);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
