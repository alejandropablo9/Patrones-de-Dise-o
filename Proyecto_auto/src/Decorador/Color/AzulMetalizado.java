package Decorador.Color;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class AzulMetalizado extends Decorador{
    
    public AzulMetalizado(Audi audi) {
        super(audi);
    }
    
    @Override
    public double precio() {
        return audi.precio() + 9000.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\n" + "Color: Azul Metalizado";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }
    
}
