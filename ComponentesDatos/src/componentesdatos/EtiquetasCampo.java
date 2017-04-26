package componentesdatos;

import java.awt.BorderLayout;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Alejandro
 */
public final class EtiquetasCampo extends JPanel implements Serializable{

    private JLabel[] titulos;
    private ComponenteTexto campo;
    
    public EtiquetasCampo(){
        init();
    }
    
    public void init(){
        titulos = new JLabel[1];
        titulos[0] = new JLabel("titulo");
        campo = new ComponenteTexto();
        this.setLayout(new BorderLayout());   
        this.add(campo, BorderLayout.CENTER);
        this.add(titulos[0], BorderLayout.WEST);
    }
    
    public void setlongMax(int longMax){
        campo.setLongMax(longMax);
    }

    public JLabel[] getTitulos() {
        return titulos;
    }        

    public void setTitulos(JLabel[] titulos) {
        this.titulos = titulos;
        for(int i = 0; i < titulos.length; i++){
            switch(i){
                case 0: this.add(this.titulos[i], BorderLayout.WEST);
                break;
                case 1: this.add(this.titulos[i], BorderLayout.NORTH);
                break;
                case 2: this.add(this.titulos[i], BorderLayout.EAST);
                break;
                case 3: this.add(this.titulos[i], BorderLayout.SOUTH);
                break;                
            }
        }
    }
    
    public void nTitulos(int n){
        titulos = new JLabel[n];
        for(int i = 0; i < titulos.length; i++){
            titulos[i] = new JLabel();
        }
    }
    
    public void setTitulo(int nLabel, String titulo){
        try{
            titulos[nLabel].setText(titulo);
        }catch(ArrayIndexOutOfBoundsException e){
            e.printStackTrace();
        }        
    }
    
    public void setPosicion(int nLabel, String posicion){
    
    }
    
}
