import java.io.FileInputStream;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.effect.Light;
import javafx.scene.effect.Lighting;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCombination;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import misClases.Juego;
import misClases.Sound;
import misClases.WindowAbout;
import misClases.WindowHelp;
import misClases.WindowMessage;

public class Ahorcado extends Application {

    Juego nuevoJuego = new Juego();

    ImageView imageView;
    Label textSecret = new Label();
    final String teclas1 = "ABCDEFGHI";
    final String teclas2 = "JKLMNÑOPQ";
    final String teclas3 = "RSTUVWXYZ";
    VBox teclado = new VBox();
    ImageView viewHelp;

    @Override
    public void start(Stage primaryStage) throws Exception {
        // recuperar marcador (leer archivo)
        nuevoJuego.getMarcador();

        // Imagen central
        Image image = new Image(new FileInputStream("./res/img/7.png") );
        imageView = new ImageView(image);
        imageView.setFitHeight(403);
        imageView.setFitWidth(435);
        imageView.setPreserveRatio(true);

        // Letras
        textSecret.setFont(Font.loadFont("file:./res/fonts/tiza.ttf", 38));
        textSecret.setTextFill(Color.web("#FFFFFF"));
        textSecret.setTextAlignment(TextAlignment.CENTER);
        textSecret.setText("AHORCADO");

        // teclado
        HBox fila1 = addHBox(teclas1);
        HBox fila2 = addHBox(teclas2);
        HBox fila3 = addHBox(teclas3);
        teclado.setVisible(false);
        teclado.getChildren().addAll(fila1, fila2, fila3);
        teclado.setSpacing(2);
        teclado.setPadding(new Insets(10, 0, 10, 0));
        teclado.setStyle("-fx-background-color: #112211;"); //336699

        // Menú Juego
        Menu menuGame = new Menu("Juego");
        // item nuevo juego
        MenuItem itemNew = new MenuItem("Nuevo");
        itemNew.setAccelerator(KeyCombination.keyCombination("Ctrl+N"));
        itemNew.setOnAction( e -> {reset();});
        // ítem marcador
        MenuItem itemMarcas = new MenuItem("Marcador");
        itemMarcas.setOnAction(e -> {
            nuevoJuego.mostrarMarcador();
        });
        // ítem mute
        CheckMenuItem itemMute = new CheckMenuItem("Sonido");
        itemMute.setSelected(true);
        itemMute.setOnAction( e-> {
            if (itemMute.isSelected() == true) {
                System.out.println("SONIDO");
                Sound.volume = Sound.Volume.LOW;
            } else {
                System.out.println("MUTE");
                Sound.volume = Sound.Volume.MUTE;
            }
        });
        // separador
        SeparatorMenuItem separator= new SeparatorMenuItem();
        // ítem salir
        MenuItem itemExit = new MenuItem("Exit");
        itemExit.setAccelerator(KeyCombination.keyCombination("Ctrl+X"));
        //~ itemExit.setOnAction(actionEvent -> Platform.exit());
        itemExit.setOnAction(e -> System.exit(0));
        menuGame.getItems().addAll(itemNew, itemMarcas, itemMute,
            separator, itemExit);

        // Menú Info
        Menu menuInfo = new Menu("Info");
        // ítem ayuda
        MenuItem itemHelp = new MenuItem("Ayuda");
        itemHelp.setOnAction(e-> {WindowHelp.show();});
        // ítem acerca de
        MenuItem itemAbout = new MenuItem("Créditos");
        itemAbout.setOnAction(e-> {WindowAbout.show();});
        menuInfo.getItems().addAll(itemHelp, itemAbout);

        // Barra de Menú
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(menuGame, menuInfo);
        VBox topMenu = new VBox();
        topMenu.getChildren().add(menuBar);

        // Icono Pista
        Image imgHelp = new Image(new FileInputStream("./res/img/pista.png"));
        viewHelp = new ImageView(imgHelp);
        viewHelp.setFitHeight(32);
        viewHelp.setFitWidth(32);
        viewHelp.setPreserveRatio(true);

        Rectangle r1 = new Rectangle(32,32);
        r1.setFill(Color.TRANSPARENT);
        r1.setStyle("-fx-cursor: hand;");
        r1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent t) {
                WindowMessage.show(nuevoJuego.getPista(), "PISTA");
            }
        });

        StackPane stack = new StackPane();
        stack.getChildren().addAll(viewHelp, r1);
        stack.setAlignment(Pos.CENTER_RIGHT);
        StackPane.setMargin(viewHelp, new Insets(0, 10, 0, 0));
        StackPane.setMargin(r1, new Insets(0, 10, 0, 0));

        // windows root
        VBox root = new VBox();
        root.setAlignment(Pos.BASELINE_CENTER);
        root.getChildren().addAll(topMenu, stack, imageView,
            textSecret, teclado);
        VBox.setVgrow(stack, Priority.ALWAYS);
        VBox.setMargin(stack, new Insets(10, 10, 0, 0));
        VBox.setMargin(textSecret, new Insets(20, 10, 0, 10));
        VBox.setMargin(teclado, new Insets(20, 0, 10, 0));
        root.setStyle("-fx-background: #2b552b;");

        // Scene and show the stage
        Scene scene = new Scene(root, 650, 730);
        primaryStage.setScene(scene);
        primaryStage.setTitle("JUEGO DEL AHORCADO");
        primaryStage.setMinWidth(500);
        primaryStage.setMinHeight(730);
        primaryStage.show();
    }

    public void comprobarLetra(String letra){
        String palabra = nuevoJuego.getPalabraSecreta();
        String[] paroleOculta = nuevoJuego.getArrayOculto();

        int pos = 0;
        boolean acierto = false;
        for (int i = 0; i < palabra.length(); i++){
            if (palabra.charAt(i) == letra.charAt(0)) {
               paroleOculta[pos] = letra;
               acierto = true;
            }
            pos += 1;
        }

        if (acierto == false){
            nuevoJuego.setErroresCometidos();
            int errores = nuevoJuego.getErroresCometidos() + 1;
            if(errores <= 6){
                //sonido fallo
                Sound.SOUNDERROR.play();
                imageView.setImage(new Image(
                    "file:./res/img/" + errores + ".png"));
                if(errores == 6){
                    Lighting lighting = new Lighting();
                    lighting.setDiffuseConstant(1.0);
                    lighting.setSpecularConstant(0.0);
                    lighting.setSpecularExponent(0.0);
                    lighting.setSurfaceScale(0.0);
                    lighting.setLight(new Light.Distant(45, 45, Color.RED));
                    viewHelp.setEffect(lighting);
                }
            } else {
                // Ventana HAS PERDIDO LA PALABRA ERA... ¿OTRA?
                //sonido game over
                Sound.SOUNDOVER.play();
                nuevoJuego.gameWin(false);
                String msgGameOver = "La palabra era " + palabra;
                WindowMessage.show(msgGameOver, "AHORCADO");
                reset();
            }
        } else {
            // ACTUALIZAR LETRAS actualizar array
            nuevoJuego.setArrayOculto(paroleOculta);
            String[] arraySecreto = nuevoJuego.getArrayOculto();
            // mostrar
            String parole = "";
            for (String element: arraySecreto) {
                parole += element + " ";
            }
            nuevoJuego.setPalRayada(parole);
            textSecret.setText(nuevoJuego.getPalRayada());
            // game over: gana
            int totalAciertos = 0;
            for (int i = 0; i < arraySecreto.length; i++) {
                //~ if (arraySecreto[i] != "_") {
                if (arraySecreto[i].equals("_")){
                    totalAciertos += 1;
                }
            }
            if (totalAciertos == palabra.length()){
                nuevoJuego.gameWin(true);
                //sonido victoria
                Sound.SOUNDWIN.play();
                String msgGameOver = "Enhorabuena, has ganado";
                WindowMessage.show(msgGameOver, "AHORCADO");
                reset();
            } else {
                //sonido acierto
                Sound.SOUNDACIERTO.play();
            }
        }
    }

    public HBox addHBox(String teclasX) {
        HBox tecladoR = new HBox();
        //tecladoR.setPadding(new Insets(15, 12, 15, 12));
        tecladoR.setSpacing(2);
        //tecladoR.setStyle("-fx-background-color: #336699;");
        tecladoR.setAlignment(Pos.CENTER);

        String[] teclado1 = teclasX.split("");
        for (String tec: teclado1){
            Button nameBtn = new Button(" _" + tec + " ");
            nameBtn.setPrefSize(40, 40);
            nameBtn.setStyle("-fx-cursor: hand;");
            //nameBtn.setStyle("-fx-padding: 10;");
            tecladoR.getChildren().add(nameBtn);
            nameBtn.setOnAction(e -> {
                nameBtn.setDisable(true);
                comprobarLetra(tec);
            });
        }
        return tecladoR;
    }

    public void reset(){
        // reiniciar imagen
        imageView.setImage(new Image("file:./res/img/1.png"));
        // obtener palabra al azar del banco
        String palNueva = nuevoJuego.obtenerPalabra();
        // ocultar palabra
        String[] palabraOculta = nuevoJuego.ocultarPalabra(palNueva);
        //mostrar
        textSecret.setText(nuevoJuego.getPalRayada());
        //reiniciar teclado
        teclado.getChildren().clear();
        HBox fila1 = addHBox(teclas1);
        HBox fila2 = addHBox(teclas2);
        HBox fila3 = addHBox(teclas3);
        teclado.getChildren().addAll(fila1, fila2, fila3);
        teclado.setVisible(true);
        //reiniciar errores
        nuevoJuego.resetErrores();
        //reiniciar pista
        viewHelp.setEffect(null);
    }

    public static void main(String args[]){
        launch(args);
    }

}
