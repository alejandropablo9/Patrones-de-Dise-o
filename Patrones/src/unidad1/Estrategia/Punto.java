package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Punto extends DatoMatCom{
    
    public Punto(double dato1, double dato2) {
        super(dato1, dato2);
        opSumar = new SumaDir();
        opMult = new ProductoDir();
    }
    
    @Override
    public void mostrar(){
        System.out.println("("+dato1+","+dato2+")");           
    }
}
