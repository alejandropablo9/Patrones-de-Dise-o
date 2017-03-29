package unidad2.ObservadorJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Alejandro
 */
public class Totaliza implements  Observer{
    
    private final java.util.Observable s;
    private ArrayList  datos;
    
    public Totaliza(java.util.Observable osv) {
        this.s = osv;
        this.s.addObserver(this);
    }
    @Override
    public void update(Observable o, Object arg) {
        ConjuntoEnteros ce = (ConjuntoEnteros) o;
        datos = ce.getDatos(); 
        System.out.println("total: " + total()); 
    }
        
    private int total(){
        int total = 0;
        Iterator it = datos.iterator();        
        while(it.hasNext()){
            total += ((Integer) it.next());
        }
        return total;
    }

    
    
}
