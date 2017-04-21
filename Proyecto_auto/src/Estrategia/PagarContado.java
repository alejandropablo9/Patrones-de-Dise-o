package Estrategia;

/**
 *
 * @author Alejandro
 */
public class PagarContado extends Pagar{

    public PagarContado(double t) {
        super(t);
        pagos = new PagoContado();
    }
    
}
