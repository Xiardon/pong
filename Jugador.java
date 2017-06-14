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
    private int velocidad;
    private boolean colision;
    
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
        velocidad = 0;
        colision = false;
    }
    
    /**
     * Metodo que mueve al jugador y le da velocidad
     */
    public void mover(){
        setTranslateY(getTranslateY() + velocidad);
        //Comprobamos si el jugador llega a los limites del campo no le permitimos moverse.
        if(getBoundsInParent().getMinY() <= 0 || getBoundsInParent().getMaxY() >= Juego.getAlturaCampo()){
            velocidad = 0;
        }
    }
    
    /**
     * Metodo que cambia la orienctacion del movimiento hacia arriba.
     */
    public void moverArriba(){
        if(getBoundsInParent().getMinY() > 0){
            velocidad = -3;
        }
        
    }
    
    /**
     * Metodo que cambia la orientacion del movimiento hacia abajo.
     */
    public void moverAbajo(){
        if(getBoundsInParent().getMaxY() < Juego.getAlturaCampo()){
            velocidad = 3;
        }
        
    }
    
    public int getPuntuacion(){
        return puntuacion;
    }
    
    public Color getColor(){
        return color;
    }
    
    /**
     * Este metodo suma un punto al jugador.
     */
    public void sumarPunto(){
        puntuacion++;
    }
}
