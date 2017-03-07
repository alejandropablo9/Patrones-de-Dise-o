package unidad2.MetodoFabricacion;

import java.awt.Color;

/**
 *
 * @author Alejandro
 */
public class ManipularTexto extends Manipulador{
       
    public ManipularTexto(){       
       super();      
       setBackground(Color.WHITE);    
       //crearFigura();       
       //add(figura);
    }
    
    @Override
    public void crearFigura(){
        //figura = new Texto(24, 100, 30, 30, "Metodo de Fabricación"); 
        System.out.println(nombre);
        figura = new Texto(dimension, tamaño, x, y, nombre); 
    }
    
    @Override
    public void escalar(int valor){
        figura.setDimension(valor);
        figura.dibujar();
    }        
}
