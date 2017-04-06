package sistemasolar.astros;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JComponent;

/**
 *
 * @author Alejandro
 */
public abstract class Astro extends JComponent implements MouseMotionListener{
    
    protected BufferedImage img;
    
    public Astro(){
        super.addMouseMotionListener(this);
    }
    
    public Astro(String url_imagen){
        super.addMouseMotionListener(this);
        try{
            img = ImageIO.read( new File( url_imagen ) );
            super.setBounds(0, 0, img.getWidth(), img.getHeight());
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
    }
        
    @Override
    public void mouseDragged(MouseEvent e) {
        setLocation(this.getX() + e.getX() - this.getWidth() / 2, this.getY() + e.getY() - this.getHeight() / 2);
        getParent().repaint();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        
    }
    
}
