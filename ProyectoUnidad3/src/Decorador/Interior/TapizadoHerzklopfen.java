package Decorador.Interior;

import Decorador.Audi;
import Decorador.Decorador;

/**
 *
 * @author Alejandro
 */
public class TapizadoHerzklopfen extends Decorador{

    public TapizadoHerzklopfen(Audi audi) {
        super(audi);
    }

    @Override
    public double precio() {
        return audi.precio() + 0.00;
    }

    @Override
    public String getDescripcion() {
        return audi.getDescripcion() + "\n" + "Acabado de tela Herzklopfen, Tapizado de asiento: Negro-Negro-Gris roca, Tablero: Negro-Negro, Alfombra: Negro, Toldo: Gris titanio"; 
    }

    @Override
    public String getModelo() {
        return audi.getModelo();
    }       
      
}
