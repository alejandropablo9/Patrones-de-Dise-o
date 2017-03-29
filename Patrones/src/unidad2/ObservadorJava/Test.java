package unidad2.ObservadorJava;

import java.util.Observer;

/**
 *
 * @author Alejandro
 */
public class Test {
    
    public static void main(String[] xs){
        ConjuntoEnteros sujeto = new ConjuntoEnteros();
        
        Observer obT = new Totaliza(sujeto);
        Observer obG = new Graficar(sujeto);
        Observer ob = new Imprimir(sujeto);
        
        sujeto.addEntero(10);
        sujeto.addEntero(11);
        sujeto.addEntero(15);
        sujeto.addEntero(12);
        sujeto.addEntero(5);
        sujeto.addEntero(8);
        sujeto.addEntero(7);
        
        sujeto.removerEntero(3);        
        
    }
    
}
