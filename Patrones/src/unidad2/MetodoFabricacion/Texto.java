package unidad2.MetodoFabricacion;

import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Alejandro
 */
public class Texto extends Figura{

    public Texto(int dimension, int x, int y, String nombre) {
        super(dimension, x, y, nombre);
        setSize(700, 800);
    }
        
    @Override
    public void dibujar(){
        repaint();
    }  

    @Override
    public void paint(Graphics g) {
        super.paint( g ); 
        g.setFont( new Font( "Monospaced", Font.BOLD, dimension ) );
        g.drawString(nombre, x, y);
        
    }

    
}
