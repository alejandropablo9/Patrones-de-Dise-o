package unidad2.MetodoFabricacion;

import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */
public abstract class Manipulador extends JPanel{
    
    protected Figura figura;
    protected int x, y, dimension, tamaño;
    protected String nombre;
    
    public Manipulador(){ 
        init();          
    }
    
    private void init(){          
        this.setLayout(null);        
        this.setSize(400, 450);                   
    }
            
    public void trasladar(int x, int y){        
        figura.setX(figura.getX() + x);
        figura.setY(figura.getY() + y);
        figura.dibujar();
    }
    
    public abstract void crearFigura();
    
    public abstract void escalar(int valor);

    public void manipular(int x, int y, int d, int t, String n){
        this.x = x;
        this.y = y;
        this.dimension = d;
        this.tamaño = t;
        this.nombre = n;      
    }
    
    public void presentacion(){
        add(figura);
    }

}
