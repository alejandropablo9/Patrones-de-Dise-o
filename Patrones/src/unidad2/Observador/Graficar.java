package unidad2.Observador;

import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author Alejandro
 */
public class Graficar implements Observador{

    private Observable s;
    private ArrayList  datos;
    
    public Graficar(Observable osv) {
        s = osv;
        s.registarObservador(this);
    }
    
    @Override
    public void actualizar(Observable s) {
        datos = ((ConjuntoEnteros)s).getDatos();  
        //System.out.println("total: " + total());
        graficar();
    }
        
    public void graficar(){
        Iterator it = datos.iterator();
        System.out.println("Gráfica");
        while(it.hasNext()){
          int dato = (Integer)it.next();

          System.out.print(" " + dato + " : ");
          for(int i = 0; i < dato; i++){
            System.out.print("*");
          }
          System.out.println();
        }
        System.out.println("-------------------------");
    }
}
