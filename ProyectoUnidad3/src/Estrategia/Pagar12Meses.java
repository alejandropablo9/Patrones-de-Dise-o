package Estrategia;

/**
 *
 * @author Alejandro
 */
public class Pagar12Meses extends Pagar{
    
    public Pagar12Meses(double t) {
        super(t);
        pagos = new Pago12Meses();
    }        
}
