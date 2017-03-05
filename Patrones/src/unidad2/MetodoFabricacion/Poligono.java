package unidad2.MetodoFabricacion;

import java.awt.Graphics;

/**
 *
 * @author Alejandro
 */
public class Poligono extends Figura{
    
    private int x,y;
    private int x1,y1,x2,y2,w,h;

    public Poligono(int dimension, int x, int y, String nombre) {
        super(dimension, x, y, nombre);  
        setSize(700, 800);
        x1 = x;
        y1 = y;        
        dibujar();
    }
                    
    @Override
    public void dibujar(){
        x2 = x1 + dimension;
        y2 = y1 + dimension;
        this.repaint();                
    }
    
    @Override
    public void paint(Graphics g){
        super.paint( g );        
        int width = this.x1 - this.x2;
        int height = this.y1 - this.y2;
        w = Math.abs( width );
        h = Math.abs( height );
        x = width < 0 ? x1 : x2;            
        y = height < 0 ? y1 : y2;
        if(nombre.equals("Cuadrado"))
            g.drawRect( x, y , w, h );
        else if(nombre.equals("Circulo"))
            g.drawOval(x, y, w, h);            
        else if(nombre.equals("Triangulo"))            
            g.drawPolygon( new Triangulo(x1,y1,x2,y2) );
    }           
}
