package unidad2.MetodoFabricacion;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

/**
 *
 * @author Alejandro
 */
public class Texto extends Figura{

    public Texto(int dimension, int tamaño, int x, int y, String nombre) {
        super(dimension, tamaño, x, y, nombre);
        setSize(400, 450);
        dibujar();
    }
        
    @Override
    public void dibujar(){
        repaint();
    }  

    @Override
    public void paint(Graphics g) {
        super.paint( g ); 
        g.setFont( new Font( "Monospaced", Font.BOLD, dimension ) );
        g.setColor(Color.red);
        g.drawString(nombre, x, y);        
    }

    
}
