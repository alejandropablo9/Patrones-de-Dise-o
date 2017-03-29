package unidad2.Decorador.Polinomio;

/**
 *
 * @author Alejandro
 */
public class Test {
    public static void main(String[] args){
        Polinomio p = new PolinomioConcreto();         
        Polinomio pE = new PolinomioDerivado(p);
        Polinomio pg =new PolinomioGraficado(pE); 
        pg.formarPolinomio(4);
        pg.mostrarPolinomio();               
    }
}
