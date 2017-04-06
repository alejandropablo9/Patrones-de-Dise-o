package sistemasolar.astros;

/**
 *
 * @author Alejandro
 */
public class GalaxiaViaLactea extends Galaxia{

    public GalaxiaViaLactea(int nume_astros, Astro astro) {
        super(nume_astros, astro);
    }
    
    public GalaxiaViaLactea( int num_astros, String nombre, String ruta_imagen ){
        super( num_astros, nombre, ruta_imagen );
    }

    @Override
    public boolean agregar(Astro astro) {
        System.out.println("agregar astro");
        return true;
    }   
}
