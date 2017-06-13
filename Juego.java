import javafx.application.*;
import javafx.scene.*;
import javafx.stage.*;
import javafx.scene.paint.*;
import javafx.scene.shape.*;
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
    private static Scene escena; //La escena que introduciremos en nuestro escenario.
    private static Group grupo; //El grupo principal donde añadiremos los elementos del juego.
    
    /**
     * Constructor de nuestra clase
     */
    public Juego(){
        grupo = new Group();
        escena = new Scene(grupo, ANCHURA_CAMPO, ALTURA_CAMPO);
        
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
    /**
     * Sobreescribimos el metodo start de la clase Appication
     */
    @Override
    public void start(Stage escenario){
        crearCampo();
        escenario.setTitle("EL CLASICO PONG HEHCO POR MARCOS"); //Ponemos titulo a la ventana.
        escenario.setScene(escena); //Introducimos la escena en el escenario.
        escenario.show(); //Lo mostramos
        
    }
    
    /**
     * Este metodo crea el campo y lo añade al grupo, en este caso utilizamos la escena como campo
     * y lo personalizamos.
     */
    private void crearCampo(){
        escena.setFill(Color.SPRINGGREEN); //El fondo de la escena servira como campo verde.
        Rectangle lineaCentral = new Rectangle(3, ALTURA_CAMPO, Color.WHITE);
        lineaCentral.setTranslateX(ANCHURA_CAMPO / 2);
        grupo.getChildren().add(lineaCentral);
    }
}
