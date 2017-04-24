package Estrategia;

/**
 *
 * @author Alejandro
 */
public class Pagar36Meses extends Pagar{
    
     public Pagar36Meses(double t) {
        super(t);
        pagos = new Pago36Meses();
    }    
    
}
