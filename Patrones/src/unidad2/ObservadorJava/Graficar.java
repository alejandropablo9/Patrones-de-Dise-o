package unidad2.ObservadorJava;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Alejandro
 */
public class Graficar  implements Observer{

    private final Observable s;
    private ArrayList  datos;
    
    public Graficar(Observable osv) {
        this.s = osv;
        this.s.addObserver(this);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        ConjuntoEnteros ce = (ConjuntoEnteros) o;
        datos = ce.getDatos(); 
        graficar();
    }
   
    private void graficar(){
        Iterator it = datos.iterator();
        System.out.println("Gráfica");
        while(it.hasNext()){
          int dato = (Integer)it.next();

          System.out.print(dato + " : \t");
          for(int i = 0; i < dato; i++){
            System.out.print("*");
          }
          System.out.println();
        }
        System.out.println("-------------------------");
    }
    
}
