package unidad2.ObservadorJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Alejandro
 */
public class Imprimir implements Observer{
        
    private ArrayList  datos;
    Observable s;
    
    public Imprimir(Observable osv){      
        s = osv;
        s.addObserver(this);
    }            

    @Override
    public void update(Observable o, Object arg) {
        ConjuntoEnteros ce = (ConjuntoEnteros) o;
        datos = ce.getDatos();
        imprimir();
    }
    
    private void imprimir(){
        Iterator it = datos.iterator();  
        System.out.println("-----------Datos----------");
        while(it.hasNext()){
            System.out.println("" + ((Integer) it.next()) );
        }
        System.out.println("--------------------------");
    }
    
}
