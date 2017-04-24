package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class SumaExp implements Sumar{

    @Override
    public void suma(DatoMatCom dt1, DatoMatCom dt2) {
        
        if((dt1.dato1 != 0 || dt1.dato2 != 0) && 
                (dt2.dato1 != 0 || dt2.dato2 != 0)){
            double res1 = Math.pow(dt1.dato1, dt1.dato2);
            double res2 = Math.pow(dt2.dato1, dt2.dato2);
            dt1.dato1 = res1 + res2;
            dt1.dato2 = 1;
        }
        
    }
    
}
