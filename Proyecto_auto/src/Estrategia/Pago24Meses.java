package Estrategia;

/**
 *
 * @author Alejandro
 */
public class Pago24Meses implements CalculoPagos{

    @Override
    public double calcularPagos(double total) {
        double interes = 0.15;
        double total2 = total+(total*interes);
        return total2/24;              
    }
    
}
