package unidad2.Decorador.Polinomio;

/**
 *
 * @author Alejandro
 */
public abstract class PolinomioDecorador implements Polinomio{
    
   protected Polinomio p;
   
   public PolinomioDecorador(Polinomio p){
       this.p = p;
   }
      
}
