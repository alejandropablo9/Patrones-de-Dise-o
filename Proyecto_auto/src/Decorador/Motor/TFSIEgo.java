package Decorador.Motor;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class TFSIEgo extends Decorador{

    public TFSIEgo(Audi audi) {
        super(audi);
    }
    
    @Override
    public double precio() {
        return audi.precio() + 74000.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\n" + "1.4 TFSI Ego, 125 HP, 6 Vel.";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }    
}
