package Decorador.Motor;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class TFSISline extends Decorador{

    public TFSISline(Audi audi) {
        super(audi);
    }

    @Override
    public double precio() {
        return audi.precio() + 27000.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\n" + "1.8 TFSI S line, 192 HP, S tronic";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }
    
    
}
