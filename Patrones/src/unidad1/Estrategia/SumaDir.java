package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class SumaDir implements Sumar{
    
    @Override
    public void suma(DatoMatCom d1, DatoMatCom d2) {
        d1.dato1 = d1.dato1 + d2.dato1;
        d1.dato2 = d1.dato2 + d2.dato2;
    }
}
