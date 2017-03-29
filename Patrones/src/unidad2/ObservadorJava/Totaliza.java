package unidad2.Observador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alejandro
 */
public class Totaliza implements Observador{
    
    private Observable s;
    private ArrayList  datos;
    
    public Totaliza(Observable osv) {
        s = osv;
        s.registarObservador(this);
    }
    
    @Override
    public void actualizar(Observable s) {
        datos = ((ConjuntoEnteros)s).getDatos();  
        System.out.println("total: " + total());        
    }
    
    public int total(){
        int total = 0;
        Iterator it = datos.iterator();        
        while(it.hasNext()){
            total += ((Integer) it.next());
        }
        return total;
    }
    
}
