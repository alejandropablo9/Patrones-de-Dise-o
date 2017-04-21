package Decorador.Motor;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class TFSIUrban extends Decorador{

    public TFSIUrban(Audi audi) {
        super(audi);
    }

    @Override
    public double precio() {
        return audi.precio() + 27000.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\n" + "1.4 TFSI Urban, 125 HP, 6 Vel.";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }
    
}
