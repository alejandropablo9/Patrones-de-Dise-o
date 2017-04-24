package Decorador.Interior;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class TapizadoPielAlcantara extends Decorador{

    public TapizadoPielAlcantara(Audi audi) {
        super(audi);
    }
    
    @Override
    public double precio() {
        return audi.precio() + 16500.00;
    }

    @Override
    public String getDescripcion() {
         return audi.getDescripcion() + "\n" + "Combinación Alcantara/piel, Tapizado de asiento: Negro-Negro-Gris roca, Tablero: Negro-Negro, Alfombra: Negro, Toldo: Gris titanio";
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }
    
}
