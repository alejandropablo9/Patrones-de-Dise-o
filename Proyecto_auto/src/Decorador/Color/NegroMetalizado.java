package Decorador.Color;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class NegroMetalizado  extends Decorador{
    
    public NegroMetalizado(Audi audi) {
        super(audi);
    }
    
    @Override
    public double precio() {
        return audi.precio() + 0.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\nColor: Negro Metalizado";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }
        
}
