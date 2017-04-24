package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Tiempo extends DatoMatCom{
    
    public Tiempo(double dato1, double dato2) {
        super(dato1, dato2);
        opSumar = new SumarTiempo();
    }

    @Override
    public void mostrar() {
        System.out.println(dato1 + ":" +dato2);
    }            
}
