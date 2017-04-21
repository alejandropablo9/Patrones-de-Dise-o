package Estrategia;

/**
 *
 * @author Alejandro
 */
public class PagoContado implements CalculoPagos{

    @Override
    public double calcularPagos(double total) {
        return total-(total*0.02);
    }    
}
