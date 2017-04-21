package Estrategia;

/**
 *
 * @author Alejandro
 */
public abstract class Pagar {
     
    protected double resultado;
    protected CalculoPagos pagos;
    protected double total;
    
    public Pagar(double t){
        total = t;
    }
    
    public double calcularPagos(){
        return pagos.calcularPagos(total);
    }
}
