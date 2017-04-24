package Adaptador;

import Decorador.Audi;
import javax.swing.ImageIcon;

/**
 *
 * @author Alejandro
 */
public class ComponentEntry {
    
    protected Audi audi;
    private final String imagePath;
    private ImageIcon image;
    private final String nombre;
    
    public ComponentEntry(Audi audi, String nombre, String imagePath){
        this.nombre = nombre;
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
    
    @Override
    public String toString(){ return nombre; }
    
    public Audi getComponent(){ return audi; }
    
}
