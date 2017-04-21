package Decorador;

/**
 *
 * @author Alejandro
 */
public abstract class Decorador implements Audi{
    protected Audi audi;
    
    public Decorador(Audi audi){
        this.audi = audi;
    }
    
}
