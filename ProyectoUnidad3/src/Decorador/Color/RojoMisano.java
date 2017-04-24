package Decorador.Color;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class RojoMisano extends Decorador {
    
    public RojoMisano(Audi audi) {
        super(audi);
    }
    
    @Override
    public double precio() {
        return audi.precio() + 18000.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\n" + "Color: Rojo Misano";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }
  
}
