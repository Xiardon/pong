import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
/**
 * Esta clase representa a la bola de juego.
 * 
 * @author (Marcos Alvarez Varela) 
 * @version (13/06/2017)
 */
public class Bola extends Circle
{
    private static final int RADIO = 5;
    private static final  Color COLOR = Color.RED;
    private static final int INICIAL_X = Juego.getAnchuraCampo() / 2; //Posicion incial en X de nuetra bola.
    private static final int INICIAL_Y = Juego.getAlturaCampo() / 2; //Poscicion incial en Y.
    private static int velocidadX;
    private static int velocidadY;
    
    /**
     * Constrictor de la clase.
     */
    public Bola(){
        setRadius(RADIO);
        setFill(COLOR);
        setTranslateX(INICIAL_X);
        setTranslateY(INICIAL_Y);
        velocidadX = 3;
        velocidadY = 3;
    }
    
    /**
     * Este metodo mueve la bola cada vez que se ejecuta, la regenera si se pierde y suma el punto al jugador correspondiente.
     */
    public void mover(){
        setTranslateX(getTranslateX() + velocidadX);
        setTranslateY(getTranslateY() + velocidadY);
        //Controlamos que si la bola se pierde vuelva a aparecer en el centro de nuevo.
        if(getTranslateX() > Juego.getAnchuraCampo()){
            setTranslateX(INICIAL_X);
            Juego.getJugador(1).sumarPunto();
        }else if(getTranslateX() < 0){
            setTranslateX(INICIAL_X);
            Juego.getJugador(2).sumarPunto();
        }
        comprobarColision();
       
    }
    
    /**
     * Metodo que comprueba si la bola colisiona con algun obejto y cambia la orientacion de la direccion
     * en funcion de que golpee.
     */
    private void comprobarColision(){
         //Controlamos que rebote arriba y abajo
        if(getBoundsInParent().getMaxY() >= Juego.getAlturaCampo() || 
         getBoundsInParent().getMinY() < 0){
            velocidadY = -velocidadY;
        }
        
        //Comprobamos si la bola rebota en algun jugador.
        if(getBoundsInParent().intersects(Juego.getJugador(1).getBoundsInParent()) || 
        getBoundsInParent().intersects(Juego.getJugador(2).getBoundsInParent())){
            velocidadX = -velocidadX;
        }
    }
}
