package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Exponente extends DatoMatCom{
    
    public Exponente(double dato1, double dato2) {
        super(dato1, dato2);
        opSumar = new SumaExp();
        opMult = new ProductoExp();
    }

    @Override
    public void mostrar() {
        System.out.println(dato1+"^"+dato2);
    }
    
    
    
    
}
