package misClases;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileReader;
import java.io.Writer;
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

public class Juego {

    private String palabraSecreta;
    private int erroresCometidos;
    private String palabraRayada;
    private String[] arrayOculto;
    private int victorias;
    private int derrotas;

    private final String[] animales = {"abeja", "abejorro", "aguila", "almeja",
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
    private final String[] colores = {"azul", "amarillo", "violeta", "marron",
        "rojo", "blanco", "negro", "gris", "morado", "naranja", "verde",
        "ambar", "añil", "beige", "beis", "carmesi", "celeste", "colorado",
        "crema", "escarlata", "fucsia", "rosa", "granate", "lila", "magenta",
        "ocre", "purpura"};
    private final String[] flores = {"amapola", "rosa", "clavel", "margarita",
        "azalea", "camelia", "geranio", "jazmin", "lirio", "orquidea",
        "narciso", "tulipan", "nenufar", "girasol", "dalia"};
    private final String[] deportes = {"aerobic", "ajedrez", "arco", "billar",
        "bolos", "boxeo", "beisbol", "ciclismo", "cricket", "escalada",
        "esgrima", "esqui", "futbol", "golf", "gimnasia", "hipica", "hockey",
        "judo", "karate", "lucha", "natacion", "paddle", "patinaje", "petanca",
        "pingpong", "polo", "rugby", "tenis", "tiro", "voleibol"};
    private final String[] alimentos = {"queso", "pizza", "chorizo", "jamon",
        "salami", "paella", "pastel", "bizcocho", "macarrones", "menestra",
        "ensalada", "sopa", "chocolate", "salsa", "huevo", "crema", "leche",
        "guarnición", "chuleta", "flan", "ceviche", "cocido", "tortilla",
        "tarta", "pure", "albondiga", "gazpacho", "tortita", "taco",
        "bocadillo", "torrezno", "fideua", "croqueta", "salmorejo", "empanada",
        "sandwich", "pisto", "fabada", "escalibada", "lentejas", "churro",
        "ensaimada", "morcilla", "yogur", "turron", "papas", "porrusalda",
        "callos", "torrija", "butifarra"};
    private final String[] quimicos = {"litio", "helio", "fosforo", "azufre",
        "niquel", "hierro", "plata", "mercurio", "polonio", "plomo", "fluor",
        "hidrogeno", "carbono", "oxigeno", "sodio", "magnesio", "aluminio",
        "silicio", "cloro", "potasio", "calcio", "titanio", "cobalto",
        "cobre", "zinc", "estroncio", "cadmio", "yodo", "estaño", "platino",
        "radon", "uranio", "molibdeno"};
    private final String[] vehiculos = {"coche", "moto", "bicicleta", "tren",
        "barco", "avion", "helicoptero", "autobus", "automovil", "trineo",
        "carruaje", "yate", "lancha", "submarino", "canoa", "avioneta",
        "parapente", "cohete", "metro", "tranvia", "funicular", "ferrocarril",
        "camion", "camioneta", "tractor", "motocarro", "furgoneta", "buque",
        "kayak", "piragua", "velero", "carro", "carroza", "monopatin",
        "triciclo"};
    private final String[] cuerpo = {"brazo", "mano", "cabeza", "pierna",
        "cuello", "cadera", "rodilla", "dedo", "oreja", "nariz", "cara", "codo",
        "ombligo", "espalda", "tobillo", "garganta", "ceja", "mejilla",
        "boca", "barbilla", "lengua", "parpado", "pestaña", "hombro",
        "muñeca", "pulgar", "muslo", "talon", "cerebro", "corazon", "higado",
        "riñon", "pulmon", "pancreas", "vejiga", "cintura", "pecho", "piel",
        "diente", "nalga"};
    private final String[] prendas = {"abrigo", "guante", "bufanda", "camisa",
        "calcetin", "corbata", "pantalon", "falda", "camiseta", "zapato",
        "sombrero", "media", "chaqueta", "cinturon", "blusa", "gorro",
        "sueter", "jersey", "traje", "boina", "vestido", "bota", "sandalia",
        "chancla", "correa", "liga"};
    private final String[] oficios = {"medico", "enfermero", "maestro",
        "pintor", "albañil", "abogado", "zapatero", "psicologo", "fontanero",
        "carpintero", "banquero", "profesor", "mecanico", "periodista",
        "juez", "electricista", "escritor", "informatico", "portero", "policia",
        "dentista", "futbolista", "chofer", "sastre", "cerrajero", "pastor",
        "agricultor", "carnicero", "panadero", "dependiente", "ingeniero",
        "arquitecto", "matematico", "biologo", "fisico", "quimico", "filosofo",
        "arqueologo", "farmaceutico", "geografo", "historiador", "sociologo",
        "musico", "economista", "radiologo", "ganadero"};
    private final String[] numeros = {"quince", "doce", "trece", "catorce",
        "siete", "cien", "siete", "ocho", "nueve", "diez", "cero", "cuatro",
        "cinco", "treinta", "cuarenta", "cincuenta", "millon", "sesenta",
        "setenta", "ochenta", "noventa"};

    private String pista;

    public Juego() {
        palabraSecreta = "AHORCADO";
        erroresCometidos = 0;
        pista = "Empieza una partida y hablamos";
    }
    // Métodos para obtener y establecer palabra secreta
    public int[] combinarArrays (String[]... arrays){
        // POSICION GLOBAL AL AZAR
        int[] lenArrays = new int[arrays.length];
        int finalLength = 0;
        for (int i = 0; i < arrays.length; i++) {
            finalLength += arrays[i].length;
            lenArrays[i] = arrays[i].length;
        }
        int posTotal = (int) (Math.random() * finalLength);
        // establece a qué array pertenece esa posicion
        int sumatorio = 0;
        int contadorSet = 0;
        int acumulado = 0;
        for (int i = 0; i < lenArrays.length; i++) {
            sumatorio += lenArrays[i];
            if(sumatorio > posTotal) {
                break;
            } else {
                contadorSet += 1;
                acumulado += lenArrays[i];
            }
        }
        // establece la posición en el array
        int posSet = posTotal - acumulado;

        int[] valores = {contadorSet, posSet};
        return valores;
    }
    public String obtenerPalabra() {
        // extrae al azar categoría y posicion
        int[] valorPalabra = combinarArrays(animales, colores, flores,
            deportes, alimentos, quimicos, vehiculos, cuerpo, prendas,
            oficios, numeros);
        // establece palabra y pista
        int categoria = valorPalabra[0];
        int posCat = valorPalabra[1];
        String palabra;
        switch (categoria) {
            case 0: pista = "Animal";
                    palabra = animales[posCat];
                    break;
            case 1: pista = "Color";
                    palabra = colores[posCat];
                    break;
            case 2: pista = "Flor";
                    palabra = flores[posCat];
                    break;
            case 3: pista = "Deporte o juego";
                    palabra = deportes[posCat];
                    break;
            case 4: pista = "Alimento o plato cocinado";
                    palabra = alimentos[posCat];
                    break;
            case 5: pista = "Elemento químico";
                    palabra = quimicos[posCat];
                    break;
            case 6: pista = "Vehículo o medio de transporte";
                    palabra = vehiculos[posCat];
                    break;
            case 7: pista = "Parte del cuerpo u órgano interno";
                    palabra = cuerpo[posCat];
                    break;
            case 8: pista = "Prenda de vestir o complemento";
                    palabra = prendas[posCat];
                    break;
            case 9: pista = "Profesión u oficio";
                    palabra = oficios[posCat];
                    break;
            case 10:pista = "Un número";
                    palabra = numeros[posCat];
                    break;
            default:pista = "Lo siento, me he quedado sin palabras";
                    palabra = "ahorcado";
                    break;
        }
        String palabraUp = palabra.toUpperCase();
        palabraSecreta = palabraUp;
        return palabraUp;
    }

    // Método para recuperar la palabra secreta
    public String getPalabraSecreta() {
        return palabraSecreta;
    }
    // Método para establecer una nueva palabra secreta  ??
    //~ public void setPalabraSecreta(String nuevaPalabra) {
        //~ palabraSecreta = nuevaPalabra;
    //~ }

    // Método para recuperar número de errores
    public int getErroresCometidos() {
        return erroresCometidos;
    }
    // Método para reiniciar número de errores
    public void resetErrores () {
        erroresCometidos = 0;
    }
    // Método para actualizar número de errores
    public void setErroresCometidos() {
        erroresCometidos++;
    }

    // Método para ocultar palabra secreta
    public String[] ocultarPalabra (String palSec) {
        String paOculta = "";
        int nLetras = palSec.length();
        String[] palabraOculta = new String[nLetras];
        for (int i = 0; i < palabraOculta.length; i++) {
            palabraOculta[i] = "_";
            paOculta += "_ ";
        }
        palabraRayada = paOculta;
        arrayOculto = palabraOculta;
        return palabraOculta;
    }

    // Método para recuperar palabra rayada
    public String getPalRayada(){
        return palabraRayada;
    }

    // Método para actualizar palabra rayada
    public void setPalRayada (String nuevaRayada) {
        palabraRayada = nuevaRayada;
    }

    // Método para recuperar array oculto
    public String[] getArrayOculto(){
        return arrayOculto;
    }
    // Método para actualizar array oculto
    public void setArrayOculto (String[] nuevoArray) {
        arrayOculto = nuevoArray;
    }

    // Método para recuperar la pista
    public String getPista(){
        return pista;
    }

    // Marcador
    public int getVictorias(){
        return victorias;
    }
    public int getDerrotas(){
        return derrotas;
    }
    public void gameWin(boolean win){
        if (win == true)  {
            victorias += 1;
        } else {
            derrotas += 1;
        }
        // escribir en archivo
        escribirArchivo(victorias, derrotas);
    }
    public void getMarcador(){
        // leer archivo
        String dirName = "config";
        String fileName = ".conf.txt";
        File pathDir = new File(dirName);
        File fileMarcador = new File(pathDir, fileName);
        if (fileMarcador.exists() && fileMarcador.canRead()) {
            try {
                //FileInputStream archivo = new FileInputStream("./config/.conf.txt");
                File archivo = new File("./config/.conf.txt");
                //~ BufferedReader buffer = new BufferedReader(
                    //~ new InputStreamReader(archivo));
                BufferedReader buffer = new BufferedReader(
                    new FileReader(archivo));
                String linea;
                String marcas = "";
                while ((linea = buffer.readLine()) != null) {
                    marcas += linea + "-";
                }
                buffer.close();
                // set victorias y derrotas
                String marcasSin = marcas.substring(0, marcas.length()-1);
                int guionPos = marcasSin.indexOf('-');
                String vic = marcasSin.substring(0, guionPos);
                String der = marcasSin.substring(guionPos+1);
                victorias = Integer.parseInt(vic);
                derrotas = Integer.parseInt(der);
            } catch(FileNotFoundException ex) {
                ex.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            escribirArchivo(0, 0);
        }
    }
    public void clearMarcador(){
        victorias = 0;
        derrotas = 0;
        // escribir en archivo valores 0 (o eliminar archivo)
        escribirArchivo(0, 0);
    }
    public void escribirArchivo(int win, int los){
        try {
            String dirName = "config";
            String fileName = ".conf.txt";
            File pathDir = new File(dirName);
            File file = new File(pathDir, fileName);
            Writer output = new BufferedWriter(new FileWriter(file));
            String content = win + "\n" + los;
            output.write(content);
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
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
        try {
            Image imageV = new Image(
                new FileInputStream("./res/img/triunfos.png"));
            imageViewV = new ImageView(imageV);
            imageViewV.setFitHeight(64);
            imageViewV.setFitWidth(64);
            imageViewV.setPreserveRatio(true);
            iconos.getChildren().add(imageViewV);
        } catch (FileNotFoundException ex) {
            // insert code to run when exception occurs
            System.out.println(ex.getMessage());
        }
        try {
            Image imageD = new Image(
                new FileInputStream("./res/img/derrotas.png"));
            imageViewD = new ImageView(imageD);
            imageViewD.setFitHeight(64);
            imageViewD.setFitWidth(64);
            imageViewD.setPreserveRatio(true);
                  iconos.getChildren().add(imageViewD);
        } catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }

        Label lblV = new Label();
        String vic = String.valueOf(victorias);
        lblV.setText(vic);
        lblV.setFont(Font.loadFont("file:./res/fonts/tiza.ttf", 38));
        lblV.setAlignment(Pos.CENTER);

        Label guion = new Label();
        guion.setText(" - ");
        guion.setFont(Font.loadFont("file:./res/fonts/tiza.ttf", 38));
        guion.setAlignment(Pos.CENTER);

        Label lblD = new Label();
        String der = String.valueOf(derrotas);
        lblD.setText(der);
        lblD.setFont(Font.loadFont("file:./res/fonts/tiza.ttf", 38));
        //~ lblD.setStyle("-fx-color: #121");
        //~ lblD.setTextFill(Color.web("#121"));
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

        Button btnClear = new Button();
        btnClear.setText("Limpiar");
        btnClear.setPrefWidth(80.0);
        btnClear.setOnAction(e -> {
            //~ clearMarcador();
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
