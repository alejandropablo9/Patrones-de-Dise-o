package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Fraccion extends DatoMatCom{
    
    public Fraccion(double dato1, double dato2) {
        super(dato1, dato2);
        opSumar = new SumaSiDato2();
        opMult = new ProductoDir();
    }
    
    @Override
    public void mostrar(){
        System.out.println(""+dato1+"/"+dato2);
    }
        
}
