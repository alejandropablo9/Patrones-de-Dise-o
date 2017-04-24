package Estrategia;

/**
 *
 * @author Alejandro
 */
public class Pago36Meses implements CalculoPagos{

    @Override
    public double calcularPagos(double total) {
        double interes = 0.18;
        double total2 = total+(total*interes);
        return total2/36;         
    }
}
    
