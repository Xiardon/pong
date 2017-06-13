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
        velocidadX = 1;
        velocidadY = 0;
    }
    
    /**
     * Este metodo mueve la bola cada vez que se ejecuta.
     */
    public void mover(){
        setTranslateX(getTranslateX() + velocidadX);
        setTranslateY(getTranslateY() + velocidadY);
        //Controlamos que si la bola se pierde vuelva a aparecer en el centro de nuevo.
        if(getTranslateX() > Juego.getAnchuraCampo() || getTranslateX() < 0){
            setTranslateX(INICIAL_X);
        }
        //Controlamos que rebote arriba y abajo
        if(getBoundsInParent().getMaxY() > Juego.getAlturaCampo() || 
        getBoundsInParent().getMinY() < Juego.getAlturaCampo()){
            velocidadY = -velocidadY;
        }
    }
}
