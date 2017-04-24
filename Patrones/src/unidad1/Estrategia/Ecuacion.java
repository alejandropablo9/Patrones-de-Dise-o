package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Ecuacion extends DatoMatCom{
    
    public Ecuacion(double dato1, double dato2) {
        super(dato1, dato2);
        opSumar = new SumaSiDato2();
    }
    
    @Override
    public void mostrar(){
        String s = (dato2 >= 0)? "+": ""; 
        System.out.println("" + dato1 + " " + s +" " + dato2 + "x");
    }
    
}
