package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class SumaSiDato2 implements Sumar{

    @Override
    public void suma(DatoMatCom dt1, DatoMatCom dt2) {
        if(dt1.dato2 == dt2.dato2){
            dt1.dato1 += dt2.dato1;
        }
    }
    
}
