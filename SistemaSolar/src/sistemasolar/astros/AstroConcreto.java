package sistemasolar.astros;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author Alejandro
 */
public class AstroConcreto extends Astro implements MouseListener{
    protected int x_imagen, y_imagen;
    protected String nombre;
     
    public AstroConcreto(String nombre, String url_img){
        super(url_img);
        this.nombre = nombre;
        super.addMouseListener(this);
    }
    
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, x_imagen, y_imagen, null);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {  
        
    }

    @Override
    public void mousePressed(MouseEvent e) {    
        //
    }

    @Override
    public void mouseReleased(MouseEvent e) {        
    }

    @Override
    public void mouseEntered(MouseEvent e) {        
    }

    @Override
    public void mouseExited(MouseEvent e) {        
    }
}
