package unidad2.MetodoFabricacion;

import javax.swing.JComponent;

/**
 *
 * @author Alejandro
 */
public abstract class Figura extends JComponent{
    
    protected int dimension; 
    protected int tamaño;
    protected int x;
    protected int y;
    protected String nombre;

    public Figura(int dimension, int tamaño, int x, int y, String nombre) {
        this.dimension = dimension;
        this.tamaño = tamaño;
        this.x = x;
        this.y = y;
        this.nombre = nombre;
    }
    
    public abstract void dibujar();

    public int getDimension() {
        return dimension;
    }

    public void setDimension(int dimension) {
        this.dimension = dimension;
    }
    
    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }                  

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }        
}
