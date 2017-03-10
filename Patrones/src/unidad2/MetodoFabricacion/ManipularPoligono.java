package unidad2.MetodoFabricacion;

import java.awt.Color;
import javafx.scene.layout.BorderPane;
import javax.swing.BorderFactory;

/**
 *
 * @author Alejandro
 */
public class ManipularPoligono extends Manipulador{
   
    public ManipularPoligono(){
       super();      
        setBackground(Color.WHITE);
        setBorder(BorderFactory.createLineBorder(Color.blue));
    }
   
    @Override
    public void crearFigura(){
       //figura = new Poligono(100, 200, 30, 30, "Triangulo");
       figura = new Poligono(dimension, tamaño, x, y, nombre); 
    }

    @Override
    public void escalar(int valor) {
        figura.setTamaño(valor);
        figura.dibujar();
    }       
}
