package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class ProductoExp implements Multiplicar{

    @Override
    public void multiplicar(DatoMatCom dt1, DatoMatCom dt2) {
        if(dt1.dato1 == dt2.dato1){
            dt1.dato2 += dt2.dato2;
        }
    }
    
}
