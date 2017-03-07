package unidad2.MetodoFabricacion;

/**
 *
 * @author Alejandro
 */
public class Polygon extends java.awt.Polygon{
    
    private float grado = 0; 
    private final int posX = 200;
    private final int posY = 100;
    private final double PI = Math.PI;
    
    Polygon(int lados, int radio){
        float t = (float) 360 / lados;
        for(int i = 0; i < lados; i++){
        	addPoint((int) (radio * Math.cos(PI * grado / 180) + posX), (int) (radio * Math.sin(PI * grado / 180) + posY));
        	grado += t;
        	addPoint((int) (radio * Math.cos(PI * grado / 180) + posX), (int) (radio * Math.sin(PI * grado / 180) + posY));                
    	}
    }
    
}
