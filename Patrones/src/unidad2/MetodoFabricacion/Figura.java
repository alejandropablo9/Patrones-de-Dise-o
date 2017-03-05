package unidad2.MetodoFabricacion;

import javax.swing.JComponent;

/**
 *
 * @author Alejandro
 */
public abstract class Figura extends JComponent{
    
    protected int dimension; 
    protected int x;
    protected int y;
    protected String nombre;

    public Figura(int dimension, int x, int y, String nombre) {
        this.dimension = dimension;
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

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }        

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }        
    
}
