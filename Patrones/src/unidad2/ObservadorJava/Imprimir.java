package unidad2.Observador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alejandro
 */
public class Imprimir implements Observador {
    
    private Observable s;
    private ArrayList  datos;
    
    public Imprimir(Observable os){
        s = os;
        s.registarObservador(this);
    }
    
    @Override
    public void actualizar(Observable s) {
        datos = ((ConjuntoEnteros)s).getDatos();  
        imprimir();
    }
    
    private void imprimir(){
        Iterator it = datos.iterator();        
        while(it.hasNext()){
            System.out.println("" + ((Integer) it.next()) );
        }
    }
    
}
