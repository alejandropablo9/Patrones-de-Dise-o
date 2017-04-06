package unidad2.Decorador.Examen;

/**
 *
 * @author Alejandro
 */
public abstract class CadenaDecorador implements Cadena{

    protected Cadena c;
    
    public CadenaDecorador(Cadena c){
        this.c = c;
    }
    
}
