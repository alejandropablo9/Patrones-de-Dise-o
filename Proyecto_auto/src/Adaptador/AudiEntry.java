package Adaptador;

import Decorador.Audi;
import javax.swing.ImageIcon;

/**
 *
 * @author Alejandro
 */
public class AudiEntry {
    
    protected Audi audi;
    private final String imagePath;
    private ImageIcon image;
    
    public AudiEntry(Audi audi, String imagePath){
        this.audi = audi;
        this.imagePath = imagePath;
    }
    
    public ImageIcon getImage() {
        if(image == null){
            image = new ImageIcon(imagePath);
        }
        return image;
    }
    
    public String getImagePath() {
        return imagePath;
    }
    
    public String getModelo(){ return audi.getModelo(); }
    
    @Override
    public String toString(){ return getModelo(); }
    
    public Audi getAudi(){ return audi; }
}
