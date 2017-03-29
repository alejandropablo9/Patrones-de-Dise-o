
package unidad2.Observador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alejandro
 */
public class ConjuntoEnteros implements Observable{
    
    private ArrayList<Integer> datos;
    private ArrayList obs;
    
    public ConjuntoEnteros(){
        datos = new ArrayList<Integer>();     
        obs =  new ArrayList();
    }
    
    public void addEntero(Integer i){
        datos.add(i);
        notificar();
    }

    @Override
    public void registarObservador(Observador o) {
        obs.add(o);        
    }

    @Override
    public void removerObservador(int i) {
        if(obs.size() > 0)
            obs.remove(i);
    }

    @Override
    public void notificar() {
        Iterator it = obs.iterator();
        while(it.hasNext()){
            Observador ob;
            ob = (Observador) it.next();
            ob.actualizar(this);
        }
    }
    
    public ArrayList getDatos(){
        return datos;
    }
    
}
