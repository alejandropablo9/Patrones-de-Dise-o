
package unidad2.ObservadorJava;
import java.util.ArrayList;
import java.util.Observable;

/**
 *
 * @author Alejandro
 */
public class ConjuntoEnteros extends Observable{
    
    private ArrayList<Integer> datos;
    private ArrayList obs;
    
    public ConjuntoEnteros(){
        datos = new ArrayList<Integer>();                    ;
    }
    
    public void addEntero(Integer i){
        datos.add(i);
        this.setChanged();
        this.notifyObservers();
    }
    
    public void removerEntero(int index){        
        if(index >= 0 && index < datos.size() && !datos.isEmpty())
            datos.remove(index);
        this.setChanged();
        this.notifyObservers();
    }
   
    
    public ArrayList getDatos(){
        return datos;
    }    
}
