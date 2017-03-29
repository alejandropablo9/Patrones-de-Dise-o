package unidad2.Decorador.Polinomio;

import java.util.ArrayList;

/**
 *
 * @author Alejandro
 */
public class PolinomioDerivado extends PolinomioDecorador{    
    
    public PolinomioDerivado(Polinomio p) {
        super(p);        
    }
    
    @Override
    public void formarPolinomio(int n) {        
        p.formarPolinomio(n);  
        ArrayList<Integer> coeficientes; 
        coeficientes = getCoeficiente();
        coeficientes.remove(0);
        int cd;
        for(int i = 0; i < coeficientes.size(); i++){
            cd = coeficientes.get(i) * (i + 1);
            coeficientes.set(i, cd);
        }
    }

    @Override
    public int evaluar(int x) {             
        return p.evaluar(x);
    }

    @Override
    public void mostrarPolinomio() {
       p.mostrarPolinomio();
    }

    @Override
    public String getNombre() {
        return p.getNombre() + " polinomio Derivado";
    }

    @Override
    public ArrayList<Integer> getCoeficiente() {
        return p.getCoeficiente();        
    } 
}
