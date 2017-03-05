package unidad1.ejemploAdaptador;

import javax.swing.ImageIcon;

/**
 *
 * @author Alejandro
 */
class BookEntry {
    
    private final String title;
    private final String imagePath;
    private ImageIcon image;

    public BookEntry(String title, String imagePath) {
        this.title = title;
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
        
    public String getTitle() { return title; }
    
    @Override
    public String toString(){ return title; }
}
