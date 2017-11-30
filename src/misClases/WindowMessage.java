package misClases;

import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.*;

public class WindowMessage {

    public static void show(String message, String title) {

        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle(title);
        stage.setMinWidth(350);

        Label lbl = new Label();
        lbl.setText(message);
        lbl.setFont(new Font(24.0));
        lbl.setAlignment(Pos.CENTER);

        Button btnOK = new Button();
        btnOK.setText("OK");
        btnOK.setPrefWidth(80.0);
        btnOK.setOnAction(e -> stage.close());

        VBox pane = new VBox(20);
        pane.setSpacing(30);
        pane.setPadding(new Insets(10, 20, 10, 20));
        pane.getChildren().addAll(lbl, btnOK);
        pane.setAlignment(Pos.CENTER);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }
}
