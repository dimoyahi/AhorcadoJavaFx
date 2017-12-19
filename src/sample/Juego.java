/*
 * EL AHORCADO. Juego.java
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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

/**
 * Selecciona una palabra
 * y gestiona el marcador de resultados
 */
public class Juego {

    private String palabraSecreta;
    private int erroresCometidos;
    private String palabraRayada;
    private String[] arrayOculto;
    private int victorias;
    private int derrotas;
    private Button btnClear = new Button();
    private final String PATH_CONFIG = System.getProperty("user.home");
    private final File ARCHIVO = new File(PATH_CONFIG, ".ahorcado.properties");

    private final String[] ANIMALES = {"abeja", "abejorro", "aguila", "almeja",
            "anaconda", "araña", "asno", "atun", "avestruz", "avispa", "ballena",
            "besugo", "bufalo", "buho", "buitre", "burro", "caballo", "cabra",
            "caiman", "camaleon", "camello", "canario", "cangrejo", "caracol",
            "cebra", "cerdo", "ciervo", "cigala", "cobra", "conejo", "cotorra",
            "coyote", "delfin", "elefante", "foca", "gacela", "gallo", "gacela",
            "garza", "gato", "gavilan", "gaviota", "gorila", "gorrion", "grillo",
            "guepardo", "gusano", "halcon", "hamster", "hiena", "hormiga",
            "iguana", "jabali", "jaguar", "jineta", "jirafa", "koala",
            "lagarto", "langosta", "lechuza", "leon", "leopardo", "lemur",
            "libelula", "liebre", "lince", "llama", "lobo", "lombriz", "loro",
            "mariposa", "marmota", "marsopa", "mejillon", "mono", "mosca",
            "mula", "nutria", "orca", "oso", "ostra", "oveja", "paloma",
            "pantera", "pato", "pavo", "perdiz", "perro", "pinguino", "piton",
            "pulga", "pulpo", "puma", "rana", "raton", "salmon", "sapo",
            "tiburon", "tigre", "topo", "toro", "tortuga", "trucha", "tucan",
            "vaca", "vibora", "zorro"};
    private final String[] COLORES = {"azul", "amarillo", "violeta", "marron",
            "rojo", "blanco", "negro", "gris", "morado", "naranja", "verde",
            "ambar", "añil", "beige", "beis", "carmesi", "celeste", "colorado",
            "crema", "escarlata", "fucsia", "rosa", "granate", "lila", "magenta",
            "ocre", "purpura"};
    private final String[] FLORES = {"amapola", "rosa", "clavel", "margarita",
            "azalea", "camelia", "geranio", "jazmin", "lirio", "orquidea",
            "narciso", "tulipan", "nenufar", "girasol", "dalia"};
    private final String[] DEPORTES = {"aerobic", "ajedrez", "arco", "billar",
            "bolos", "boxeo", "beisbol", "ciclismo", "cricket", "escalada",
            "esgrima", "esqui", "futbol", "golf", "gimnasia", "hipica", "hockey",
            "judo", "karate", "lucha", "natacion", "paddle", "patinaje", "petanca",
            "pingpong", "polo", "rugby", "tenis", "tiro", "voleibol"};
    private final String[] ALIMENTOS = {"queso", "pizza", "chorizo", "jamon",
            "salami", "paella", "pastel", "bizcocho", "macarrones", "menestra",
            "ensalada", "sopa", "chocolate", "salsa", "huevo", "crema", "leche",
            "guarnición", "chuleta", "flan", "ceviche", "cocido", "tortilla",
            "tarta", "pure", "albondiga", "gazpacho", "tortita", "taco",
            "bocadillo", "torrezno", "fideua", "croqueta", "salmorejo", "empanada",
            "sandwich", "pisto", "fabada", "escalibada", "lentejas", "churro",
            "ensaimada", "morcilla", "yogur", "turron", "papas", "porrusalda",
            "callos", "torrija", "butifarra"};
    private final String[] QUIMICOS = {"litio", "helio", "fosforo", "azufre",
            "niquel", "hierro", "plata", "mercurio", "polonio", "plomo", "fluor",
            "hidrogeno", "carbono", "oxigeno", "sodio", "magnesio", "aluminio",
            "silicio", "cloro", "potasio", "calcio", "titanio", "cobalto",
            "cobre", "zinc", "estroncio", "cadmio", "yodo", "estaño", "platino",
            "radon", "uranio", "molibdeno"};
    private final String[] VEHICULOS = {"coche", "moto", "bicicleta", "tren",
            "barco", "avion", "helicoptero", "autobus", "automovil", "trineo",
            "carruaje", "yate", "lancha", "submarino", "canoa", "avioneta",
            "parapente", "cohete", "metro", "tranvia", "funicular", "ferrocarril",
            "camion", "camioneta", "tractor", "motocarro", "furgoneta", "buque",
            "kayak", "piragua", "velero", "carro", "carroza", "monopatin",
            "triciclo"};
    private final String[] CUERPO = {"brazo", "mano", "cabeza", "pierna",
            "cuello", "cadera", "rodilla", "dedo", "oreja", "nariz", "cara", "codo",
            "ombligo", "espalda", "tobillo", "garganta", "ceja", "mejilla",
            "boca", "barbilla", "lengua", "parpado", "pestaña", "hombro",
            "muñeca", "pulgar", "muslo", "talon", "cerebro", "corazon", "higado",
            "riñon", "pulmon", "pancreas", "vejiga", "cintura", "pecho", "piel",
            "diente", "nalga"};
    private final String[] PRENDAS = {"abrigo", "guante", "bufanda", "camisa",
            "calcetin", "corbata", "pantalon", "falda", "camiseta", "zapato",
            "sombrero", "media", "chaqueta", "cinturon", "blusa", "gorro",
            "sueter", "jersey", "traje", "boina", "vestido", "bota", "sandalia",
            "chancla", "correa", "liga"};
    private final String[] OFICIOS = {"medico", "enfermero", "maestro",
            "pintor", "albañil", "abogado", "zapatero", "psicologo", "fontanero",
            "carpintero", "banquero", "profesor", "mecanico", "periodista",
            "juez", "electricista", "escritor", "informatico", "portero", "policia",
            "dentista", "futbolista", "chofer", "sastre", "cerrajero", "pastor",
            "agricultor", "carnicero", "panadero", "dependiente", "ingeniero",
            "arquitecto", "matematico", "biologo", "fisico", "quimico", "filosofo",
            "arqueologo", "farmaceutico", "geografo", "historiador", "sociologo",
            "musico", "economista", "radiologo", "ganadero"};
    private final String[] NUMEROS = {"quince", "doce", "trece", "catorce",
            "siete", "cien", "siete", "ocho", "nueve", "diez", "cero", "cuatro",
            "cinco", "treinta", "cuarenta", "cincuenta", "millon", "sesenta",
            "setenta", "ochenta", "noventa"};

    private String pista;

    /**
     * Constructor
     */
    Juego() {
        palabraSecreta = "AHORCADO";
        erroresCometidos = 0;
        pista = "Empieza una partida y hablamos";
    }

    // Métodos para obtener y establecer palabra secreta

    /**
     * Combina todos los arrays para obtener una palabra al azar
     * @param arrays Arrays de palabras
     * @return Devuelve un array de 2 números:
     * el primero establece el array seleccionado (categoría)
     * y el segundo marca la posición de la palabra en ese array
     */
    private int[] combinarArrays(String[]... arrays){

        // CALCULA LONGITUD GLOBAL
        int[] lenArrays = new int[arrays.length];
        int finalLength = 0;
        for (int i = 0; i < arrays.length; i++) {
            finalLength += arrays[i].length;
            lenArrays[i] = arrays[i].length;
        }

        // POSICIÓN ALEATORIA EN LA LONGITUD GLOBAL
        int posTotal = (int) (Math.random() * finalLength);
        //SecureRandom numeroAleatorio = new SecureRandom();
        //int posTotal = numeroAleatorio.nextInt(finalLength);

        // establece a qué array pertenece esa posicion
        int sumatorio = 0;
        int contadorSet = 0;
        int acumulado = 0;
        for (int lenArray : lenArrays) {
            sumatorio += lenArray;
            if (sumatorio > posTotal) {
                break;
            } else {
                contadorSet += 1;
                acumulado += lenArray;
            }
        }

        // establece la posición en el array
        int posSet = posTotal - acumulado;
        return new int[]{contadorSet, posSet};
    }

    /**
     * Establece la palabra secreta
     * y la pista
     * @return Palabra secreta en mayúsculas
     */
    public String obtenerPalabra() {
        // extrae al azar categoría y posicion
        int[] valorPalabra = combinarArrays(ANIMALES, COLORES, FLORES,
                DEPORTES, ALIMENTOS, QUIMICOS, VEHICULOS, CUERPO, PRENDAS,
                OFICIOS, NUMEROS);

        // establece palabra y pista
        String palabra;
        switch (valorPalabra[0]) {
            case 0: pista = "Animal";
                palabra = ANIMALES[valorPalabra[1]];
                break;
            case 1: pista = "Color";
                palabra = COLORES[valorPalabra[1]];
                break;
            case 2: pista = "Flor";
                palabra = FLORES[valorPalabra[1]];
                break;
            case 3: pista = "Deporte o juego";
                palabra = DEPORTES[valorPalabra[1]];
                break;
            case 4: pista = "Alimento o plato cocinado";
                palabra = ALIMENTOS[valorPalabra[1]];
                break;
            case 5: pista = "Elemento químico";
                palabra = QUIMICOS[valorPalabra[1]];
                break;
            case 6: pista = "Vehículo o medio de transporte";
                palabra = VEHICULOS[valorPalabra[1]];
                break;
            case 7: pista = "Parte del cuerpo u órgano interno";
                palabra = CUERPO[valorPalabra[1]];
                break;
            case 8: pista = "Prenda de vestir o complemento";
                palabra = PRENDAS[valorPalabra[1]];
                break;
            case 9: pista = "Profesión u oficio";
                palabra = OFICIOS[valorPalabra[1]];
                break;
            case 10:pista = "Un número";
                palabra = NUMEROS[valorPalabra[1]];
                break;
            default:pista = "Lo siento, me he quedado sin palabras";
                palabra = "ahorcado";
                break;
        }
        String palabraUp = palabra.toUpperCase();
        palabraSecreta = palabraUp;
        return palabraUp;
    }

    /**
     * Obtiene la palabra secreta
     * @return String
     */
    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    /**
     * Recupera la cuenta de errores cometidos
     * @return número entero
     */
    public int getErroresCometidos() {
        return erroresCometidos;
    }

    /**
     * Reinicia los errores cometidos a 0
     */
    public void resetErrores () {
        erroresCometidos = 0;
    }

    /**
     * Actualiza el número de errores
     */
    public void setErroresCometidos() {
        erroresCometidos++;
    }

    /**
     * Oculta la palabra secreta
     * @param palSec Nueva palabra
     */
    public void ocultarPalabra (String palSec) {
        StringBuilder paOculta = new StringBuilder();
        int nLetras = palSec.length();
        String[] palabraOculta = new String[nLetras];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = "_";
            // paOculta += "_ ";
            paOculta.append("_ ");
        }
        palabraRayada = paOculta.toString();
        arrayOculto = palabraOculta;
    }

    /**
     * Recupera la palabra rayada
     * @return palabra rayada
     */
    public String getPalRayada(){
        return palabraRayada;
    }

    /**
     * Actualiza palabra rayada
     * @param nuevaRayada Palabra oculta
     */
    public void setPalRayada (String nuevaRayada) {
        palabraRayada = nuevaRayada;
    }

    /**
     * Recupera array oculto
     * @return array oculto
     */
    public String[] getArrayOculto(){
        return arrayOculto;
    }

    /**
     * Actualiza array oculto
     * @param nuevoArray Array de letras de la palabra oculta
     */
    public void setArrayOculto (String[] nuevoArray) {
        arrayOculto = nuevoArray;
    }

    /**
     * Recupera la pista
     * @return Pista sobre la categoría de la palabra secreta
     */
    public String getPista(){
        return pista;
    }

    /**
     * Marcador
     * Cuenta victorias y derrotas
     * y las escribe en archivo
     * @param win true = victoria
     */
    public void gameWin(boolean win){
        if (win)  {
            victorias += 1;
        } else {
            derrotas += 1;
        }
        // escribir en archivo
        escribirArchivo(victorias, derrotas);
    }

    /**
     * Recupera datos desde archivo propiedades para leer marcador
     * Si no encuentra el archivo: lo escribe
     */
    public void getMarcador() {

        if (ARCHIVO.exists() && ARCHIVO.canRead()) {
            try {
                Properties props = new Properties();
                FileInputStream reader = new FileInputStream(ARCHIVO);
                props.load(reader);
                victorias = Integer.parseInt(props.getProperty("victorias"));
                derrotas = Integer.parseInt(props.getProperty("derrotas"));
                reader.close();
            } catch (FileNotFoundException e) {
                System.out.println("ARCHIVO NO ENCONTRADO O CORRUPTO");
                escribirArchivo(0, 0);
            } catch (IOException e) {
                System.out.println("NO ENCONTRADO");
                escribirArchivo(0, 0);
            }
        } else {
            escribirArchivo(0, 0);
        }
    }

    /**
     * Escribe marcador en archivo propiedades
     * @param win victorias
     * @param los derrotas
     */
    private void escribirArchivo(int win, int los) {

        if (!ARCHIVO.exists() && !ARCHIVO.canRead()){
            try {
                BufferedWriter writer = new BufferedWriter(new FileWriter(ARCHIVO));
                writer.close();
            } catch (IOException e) {
                System.out.println("NO CREADO");
            }
        }

        try {
            Properties properties = new Properties();
            properties.setProperty("victorias", String.valueOf(win));
            properties.setProperty("derrotas", String.valueOf(los));
            FileOutputStream marca = new FileOutputStream(ARCHIVO);
            properties.store(marca,"MARCADOR AHORCADO");
            marca.close();
        } catch (IOException e) {
            System.out.println("ERROR AL ESCRIBIR");
            btnClear.setDisable(true);
            String msgErrorMarcador = "El archivo que almacena el marcador no ha podido ser creado.\n"
                    + "El juego funcionará con normalidad pero los resultados no se guardarán.";
            WindowMessage.show(msgErrorMarcador, "ERROR");
        }
    }

    /**
     * Ventana marcador
     */
    public void mostrarMarcador () {
        Stage stage = new Stage();
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("MARCADOR");
        stage.setMinWidth(350);

        HBox iconos = new HBox();
        iconos.setPadding(new Insets(25, 12, 0, 12));
        iconos.setSpacing(60);
        iconos.setAlignment(Pos.CENTER);
        ImageView imageViewV;
        ImageView imageViewD;
        Image imageV = new Image(this.getClass()
                .getResourceAsStream("resources/img/triunfos.png"));

        imageViewV = new ImageView(imageV);
        imageViewV.setFitHeight(64);
        imageViewV.setFitWidth(64);
        imageViewV.setPreserveRatio(true);
        iconos.getChildren().add(imageViewV);

        Image imageD = new Image(this.getClass()
                .getResourceAsStream("resources/img/derrotas.png"));
        imageViewD = new ImageView(imageD);
        imageViewD.setFitHeight(64);
        imageViewD.setFitWidth(64);
        imageViewD.setPreserveRatio(true);
        iconos.getChildren().add(imageViewD);

        Label lblV = new Label();
        String vic = String.valueOf(victorias);
        lblV.setText(vic);
        //~ lblV.setFont(Font.loadFont("file:res/fonts/tiza.ttf", 38));
        Font customFont = Font.loadFont(Juego.this.getClass()
                .getResource("resources/fonts/tiza.ttf").toExternalForm(), 38);
        lblV.setFont(customFont);
        lblV.setAlignment(Pos.CENTER);

        Label guion = new Label();
        guion.setText(" - ");
        //~ guion.setFont(Font.loadFont("file:res/fonts/tiza.ttf", 38));
        guion.setFont(customFont);
        guion.setAlignment(Pos.CENTER);

        Label lblD = new Label();
        String der = String.valueOf(derrotas);
        lblD.setText(der);
        //~ lblD.setFont(Font.loadFont("file:res/fonts/tiza.ttf", 38));
        lblD.setFont(customFont);
        lblD.setAlignment(Pos.CENTER);

        HBox etiquetas = new HBox();
        etiquetas.setPadding(new Insets(0, 12, 15, 12));
        etiquetas.setSpacing(20);
        //~ etiquetas.setStyle("-fx-background-color: #121;");
        etiquetas.setAlignment(Pos.CENTER);
        etiquetas.getChildren().addAll(lblV, guion, lblD);

        Button btnOK = new Button();
        btnOK.setText("OK");
        btnOK.setPrefWidth(80.0);
        btnOK.setOnAction(e -> stage.close());

        //Button btnClear = new Button();
        btnClear.setText("Limpiar");
        btnClear.setPrefWidth(80.0);
        btnClear.setOnAction(e -> {
            victorias = 0;
            derrotas = 0;
            // escribir en archivo valores 0 (o eliminar archivo)
            escribirArchivo(0, 0);
            lblV.setText("0");
            lblD.setText("0");
        });

        HBox botones = new HBox();
        botones.setPadding(new Insets(15, 12, 15, 12));
        botones.setSpacing(10);
        //~ botones.setStyle("-fx-background-color: #336699;");
        botones.setAlignment(Pos.CENTER);
        botones.getChildren().addAll(btnOK, btnClear);

        VBox pane = new VBox();
        pane.setSpacing(20);
        pane.setPadding(new Insets(10, 20, 10, 20));
        pane.getChildren().addAll(iconos, etiquetas, botones);
        pane.setAlignment(Pos.CENTER);
        VBox.setMargin(iconos, new Insets(20, 10, 0, 10));
        VBox.setMargin(etiquetas, new Insets(0, 20, 10, 20));
        VBox.setMargin(botones, new Insets(20, 10, 5, 10));
        pane.setStyle("-fx-background: #121;");

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.showAndWait();
    }

}
