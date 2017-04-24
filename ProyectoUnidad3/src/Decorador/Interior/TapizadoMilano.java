package Decorador.Interior;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class TapizadoMilano extends Decorador{

    public TapizadoMilano(Audi audi) {
        super(audi);
    }
    
    @Override
    public double precio() {
        return audi.precio() + 0.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\n" + "Piel Milano, Tapizado de asiento: Azul láser-Negro-Azul láser, Tablero: Negro-Negro, Alfombra: Negro, Toldo: Gris titanio";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }
     
}
