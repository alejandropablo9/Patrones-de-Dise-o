package unidad2.Decorador.Polinomio;

import java.util.ArrayList;
import javax.swing.JFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Alejandro
 */
public class PolinomioGraficado extends PolinomioDecorador{
    
    private Grafica puntos;
    
    public PolinomioGraficado(Polinomio p) {
        super(p);
    }
    
    @Override
    public void formarPolinomio(int n) {
        p.formarPolinomio(n);                
    }

    @Override
    public void mostrarPolinomio() {
        p.mostrarPolinomio();
        ArrayList<Integer> xs = new ArrayList<Integer>();
        for(int i = 0; i <= 10; i++){
            xs.add(evaluar(i));
        }
        puntos = new Grafica(xs);
        puntos.pack();        
        puntos.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        puntos.setVisible(true);
    }
    
    @Override
    public int evaluar(int x) {
        return p.evaluar(x);
    }

    @Override
    public String getNombre() {
        return p.getNombre() + " Polinomio Graficador";
    }

    @Override
    public ArrayList<Integer> getCoeficiente() {
        return p.getCoeficiente();
    }

    
    private class Grafica extends javax.swing.JFrame {
        JFreeChart grafica;
        DefaultCategoryDataset Datos = new DefaultCategoryDataset();
        //private ArrayList<Genotipo> generaciones;

        public Grafica(ArrayList<Integer> valores){
            for(int i = 0; i < valores.size(); i ++){            
                Datos.addValue(valores.get(i), "Puntos", "" + (i));            
            }       	
            grafica = ChartFactory.createLineChart("" + getNombre(),
            "x", "y", Datos,
            PlotOrientation.VERTICAL, true, true, false);

            ChartPanel panel = new ChartPanel(grafica);
            this.getContentPane().add(panel);        
        }
    }
}
