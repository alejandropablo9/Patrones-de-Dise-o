package componentesdatos;

import java.awt.BorderLayout;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public final class EtiquetasCampo extends JPanel implements Serializable{

    private JLabel[] titulos;
    private String[] etiquetas;
    private final String[] posiciones = {"LEFT", "RIGHT", "UP", "DOWN"};
    private ComponenteTexto input;
    
    public EtiquetasCampo(){
        super();
        init();
    }
    
    private void init(){        
        titulos = new JLabel[4];
        for(int i = 0; i < titulos.length; i++){
            titulos[i] = new JLabel();
        }                
        input = new ComponenteTexto();
        this.setLayout(new BorderLayout());   
        this.add(input, BorderLayout.CENTER);        
        this.setSize(200, 400);    
    }
    
    public void setLongMax(int longMax){
        input.setLongMax(longMax);
    }
    
    public void setLongMin(int longMin){
        input.setLongMin(longMin);
    }
    
    public int getLongMax(){
        return input.getLongMax();
    }
    
    public int getLongMin(){
        return input.getLongMin();
    }

    public JLabel[] getTitulos() {
        return titulos;
    }

    public void setTitulos(JLabel[] titulos) {
        this.titulos = titulos;
    }

    public String[] getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String[] etiquetas) {
        if(etiquetas.length == this.titulos.length){
            this.etiquetas = etiquetas;
            nombrarEtiquetas(etiquetas);
            posicionarEtiquetas();
        }else{
            JOptionPane.showMessageDialog(null, "el arreglo debe ser de tamaño: " + titulos.length);
        }
    }

    public ComponenteTexto getInput() {
        return input;
    }                 
    
    private void nombrarEtiquetas(String[] nombreTitulos){        
        for(int i = 0; i < this.titulos.length; i++){
            this.titulos[i].setText(nombreTitulos[i]);
            this.titulos[i].setHorizontalAlignment(JTextField.CENTER);
            this.titulos[i].setBounds(
                this.titulos[i].getBounds().x,
                this.titulos[i].getBounds().y,
                this.titulos[i].getBounds().width + 100,
                this.titulos[i].getBounds().height
            );
        }
    }
    
    private void posicionarEtiquetas(){
        add(titulos[0], BorderLayout.WEST);
        add(titulos[1], BorderLayout.EAST);        
        add(titulos[2], BorderLayout.NORTH);
        add(titulos[3], BorderLayout.SOUTH);
    }

    public String[] getPosiciones() {
        return posiciones;
    }
    
    
}
