package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Complejo extends DatoMatCom{
    
    public Complejo(double dato1, double dato2) {
        super(dato1, dato2);
        opSumar = new SumaDir();
        opMult = new ProductoComplejo();
    }
              
    @Override
    public void mostrar(){
        String im = (dato2 >= 0)? "+":""; 
        System.out.println(dato1+ " "+im+""+dato2+"i");           
    }
}
