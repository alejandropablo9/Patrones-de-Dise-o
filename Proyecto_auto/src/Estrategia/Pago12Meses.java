package Estrategia;

/**
 *
 * @author Alejandro
 */
public class Pago12Meses implements CalculoPagos{

    @Override
    public double calcularPagos(double total) {
        double interes = 0.10;
        double total2 = total+(total*interes);
        return total2/12;          
    }    
}
