
package unidad2.Decorador.Polinomio;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Alejandro
 */
public class PolinomioConcreto implements Polinomio{
    
    protected ArrayList<Integer> coeficientes;   
    
    public PolinomioConcreto(){
        this.coeficientes = new ArrayList<Integer>();
    }
    
    @Override
    public void formarPolinomio(int n) {
        if (n >= 2){
            Random r = new Random();
            for(int i=0; i<n; i++){
                int c =  (int) (r.nextDouble() * 5 + 1);
                coeficientes.add(c);
            }  
        }
    }
    
    @Override
    public void mostrarPolinomio() {
        String str = "";
        
        for(int i = 0; i < coeficientes.size(); i++){
            String sig = (coeficientes.get(i) > 0)? "+": "";
            sig = (i == coeficientes.size() - 1)? "" : sig;
            str += coeficientes.get(i) + "x^" + i + " " + sig + " ";
        }        
        System.out.println(str);
    }
    
    @Override
    public int evaluar(int x) {
        int y = 0;
        y += coeficientes.get(0);
        for(int i = 1; i < coeficientes.size(); i++){
            y += coeficientes.get(i) * ((int) Math.pow(x, i));
        }
        System.out.println("valor de x: "+ x + " y:" +y);
        return y;
    }

    @Override
    public String getNombre() {
        return "polinomio SIMPLE";
    }
    
    @Override
    public ArrayList<Integer> getCoeficiente() {
        return coeficientes;        
    }
}
