import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;
/**
 * Esta clase representa al jugador, tendra forma rectangular y simulara un raqueta que tratara de hacer
 * rebotar la bola.
 * 
 * @author (Marcos Alvarez Varela) 
 * @version (14/06/2017)
 */
public class Jugador extends Rectangle
{
    private static final int ANCHURA_JUGADOR = 5;
    private static final int ALTURA_JUGADOR = 30;
    private int puntuacion;
    private int posicionInicialX;
    private final int POSICION_INCIAL_Y = Juego.getAlturaCampo() / 2 - (ALTURA_JUGADOR / 2);
    private Color color;
    
    /**
     * Constructor de la clase.
     */
    public Jugador(){
        setWidth(ANCHURA_JUGADOR);
        setHeight(ALTURA_JUGADOR);
        puntuacion = 0;
        setTranslateY(POSICION_INCIAL_Y);
        if(Juego.getNumeroJugadores() == 0){
            posicionInicialX = 5;
            color = Color.BLACK;
        }else{
            posicionInicialX = 490;
            color = Color.BLUEVIOLET;
        }
        setFill(color);
        setTranslateX(posicionInicialX);
    }
}
