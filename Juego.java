import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
import javafx.animation.*;
/**
 * Esta es la clase principal que se encargara de lanzar el juego y crear el campo.
 * 
 * @author (Marcos Alvarez VArela) 
 * @version (13/06/2017)
 */
public class Juego extends Application
{
    private static final int ANCHURA_CAMPO = 500;
    private static final int ALTURA_CAMPO = 400;
    private static final Bola BOLA = new Bola(); //La bola del juego.
    private static Scene escena; //La escena que introduciremos en nuestro escenario.
    private static Group grupo; //El grupo principal donde añadiremos los elementos del juego.
    private static int numeroJugadores;
    //Los jugadores.
    private static Jugador jugador1;
    private static Jugador jugador2;

    /**
     * Constructor de nuestra clase
     */
    public Juego(){
        grupo = new Group();
        escena = new Scene(grupo, ANCHURA_CAMPO, ALTURA_CAMPO);
        numeroJugadores = 0;

    }

    public static void main(String[] args){
        launch(args);
    }

    /**
     * Sobreescribimos el metodo start de la clase Application
     */
    @Override
    public void start(Stage escenario){
        crearCampo();
        crearJugadores();
        escenario.setTitle("EL CLASICO PONG HECHO POR MARCOS"); //Ponemos titulo a la ventana.
        escenario.setScene(escena); //Introducimos la escena en el escenario.
        escenario.show(); //Lo mostramos
        AnimationTimer animacion = new AnimationTimer(){
                @Override
                public void handle(long now){
                    BOLA.mover();
                    jugador1.mover();
                    jugador2.mover();
                }
            };
        animacion.start();
        
        escena.setOnKeyPressed(event -> {
            switch(event.getCode()){
                case UP:
                jugador1.moverArriba();
                break;
                
                case DOWN:
                jugador1.moverAbajo();
                break;
                
                case W:
                jugador2.moverArriba();
                break;
                
                case S:
                jugador2.moverAbajo();
                break;
            }
            });

    }

    /**
     * Este metodo crea el campo y lo añade al grupo junto con sus elementis, en este caso 
     * utilizamos la escena como campo y lo personalizamos.
     */
    private void crearCampo(){
        escena.setFill(Color.SPRINGGREEN); //El fondo de la escena servira como campo verde.
        Rectangle lineaCentral = new Rectangle(3, ALTURA_CAMPO, Color.WHITE);
        lineaCentral.setTranslateX(ANCHURA_CAMPO / 2);
        grupo.getChildren().addAll(lineaCentral, BOLA);
    }

    /**
     * Metodo que crea los jugadores.
     */
    private void crearJugadores(){
        while(numeroJugadores < 2){
            if(numeroJugadores == 0){
                jugador1 = new Jugador();
            }else{
                jugador2 = new Jugador();
            }
            numeroJugadores++;
        }
        grupo.getChildren().addAll(jugador1, jugador2);
    }

    /**
     * Metodo al que se le pasa por parametro el numero de jugador y nos lo devuelve.
     */
    public static Jugador getJugador(int numeroJugador){
        Jugador jugador = null;
        if(numeroJugador == 1){
            jugador = jugador1;
        }else{
            jugador = jugador2;
        }
        return jugador;
    }

    public static int getAnchuraCampo(){
        return ANCHURA_CAMPO;
    }

    public static int getAlturaCampo(){
        return ALTURA_CAMPO;
    }

    public static int getNumeroJugadores(){
        return numeroJugadores;
    }
}
