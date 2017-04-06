package sistemasolar.astros;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public abstract class Galaxia extends Astro{
    protected ArrayList<Astro> astros;  
    
    public Galaxia(int nume_astros, Astro astro){
        super.setBounds(0, 0, astro.getWidth(), astro.getHeight());
        astros = new ArrayList<Astro>();
        agregar( astro );
    }
    
    public Galaxia( int nume_astros, String nombre, String ruta_imagen ){
        this( nume_astros, new AstroConcreto( nombre, ruta_imagen ) );
    }
    
    public abstract boolean agregar ( Astro astro);
}
