package misClases;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class WindowHelp {

    public static void show() {

        ScrollPane scrollPane = new ScrollPane();

        String textAyuda1 = "Esta aplicación revive el clásico juego de lápiz "
            + "y papel 'El Ahorcado'.\n\n";
        String textAyuda2 = "El objetivo de este juego es descubrir una palabra "
            + "oculta acertando las letras que la componen. Para ello, el "
            + "programa propone aleatoriamente una palabra entre una multitud "
            + "de temas variados (animales, deportes, flores, elementos "
            + "químicos, colores, etc.) y dibuja una raya por cada letra de la "
            + "palabra secreta.\n\n";
        String textAyuda3 = "Después el jugador deberá seleccionar sucesivamente "
            + "las letras para descubrir la palabra oculta. Si la palabra secreta "
            + "contiene esa letra, aparecerá en su lugar correspondiente "
            + "(tantas veces como se repita).\n\n";
        String textAyuda4 = "En caso contrario, por cada error se dibuja una "
            + "parte de la figura del ahorcado (cabeza, tronco y extremidades) "
            + "y cada vez se está un poquito más cerca de 'morir' en la horca.\n\n";
        String textAyuda5 = "Se gana el juego si se completa la palabra antes "
            + "de dibujar completamente el monigote del ahorcado, y se pierde "
            + "si 'mueres' en la horca (al sexto error).\n\n";
        String textAyuda6 = "Durante el juego puedes solicitar una pista desde "
            + "el icono ? situado en la esquina superior derecha de la ventana "
            + "de la aplicación.\n\n";
        String textAyuda7 = "La aplicación guarda los resultados acumulados, "
            + "que se pueden ver desde el Menú -> Marcador.\n\n";
        String textAyuda8 = "Desde el Menú -> Sonido se pueden activar o "
            + "desactivar los efectos sonoros de la aplicación.";

        Text text1 = new Text(textAyuda1);
        Text text2 = new Text(textAyuda2);
        Text text3 = new Text(textAyuda3);
        Text text4 = new Text(textAyuda4);
        Text text5 = new Text(textAyuda5);
        Text text6 = new Text(textAyuda6);
        Text text7 = new Text(textAyuda7);
        Text text8 = new Text(textAyuda8);

        text1.setFont(new Font(20.0));
        text1.setStyle("-fx-font-weight: bold");

        text2.setFont(new Font(14.0));
        text3.setFont(new Font(14.0));
        text4.setFont(new Font(14.0));
        text5.setFont(new Font(14.0));
        text6.setFont(new Font(14.0));
        text7.setFont(new Font(14.0));
        text8.setFont(new Font(14.0));

        TextFlow textFlowPane = new TextFlow();
        textFlowPane.setTextAlignment(TextAlignment.JUSTIFY);
        textFlowPane.setPrefSize(700, 500);
        textFlowPane.setLineSpacing(5.0);

        textFlowPane.getChildren().addAll(text1, text2, text3, text4, text5,
            text6, text7, text8);

        VBox pane = new VBox();
        pane.setSpacing(10);
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.getChildren().addAll(textFlowPane);
        pane.setAlignment(Pos.CENTER);

        scrollPane.setContent(pane);
        scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);
        scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("JUEGO DEL AHORCADO");
        Scene scene = new Scene(scrollPane, 750, 550);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
