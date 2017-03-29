package unidad2.Decorador.Polinomio;

import java.util.ArrayList;
/**
 *
 * @author Alejandro
 */
public interface Polinomio {
    
    public void formarPolinomio(int n);
    public void mostrarPolinomio();
    public int evaluar(int x);
    public String getNombre();
    public ArrayList<Integer> getCoeficiente();  

}
