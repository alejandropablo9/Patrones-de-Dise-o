package unidad2.Observador;

/**
 *
 * @author Alejandro
 */
public class Test {
    
    public static void main(String[] xs){
        ConjuntoEnteros sujeto = new ConjuntoEnteros();
        Observador ob = new Imprimir(sujeto);
        Observador obT = new Totaliza(sujeto);
        Observador obG = new Graficar(sujeto);
        
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
