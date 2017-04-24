package Estrategia;

/**
 *
 * @author Alejandro
 */
public class Pagar24Meses extends Pagar {
    
     public Pagar24Meses(double t) {
        super(t);
        pagos = new Pago24Meses();
    }
     
}