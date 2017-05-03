package questionario;

import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
/**
 *
 * @author alejandro
 */
public class Opciones {
    
    private JRadioButton opciones[] ;
    private ButtonGroup grupo;
    
    public Opciones(){
        grupo = new ButtonGroup();
    }
    
    public Opciones(JRadioButton[] opciones) {
        this.opciones = opciones;
    }
    
    public Opciones(String[] opciones){
        this.opciones = new JRadioButton[opciones.length];
        for(int i = 0; i < this.opciones.length; i++){
            this.opciones[i] = new JRadioButton(opciones[i]);       
            grupo.add(this.opciones[i]);
        }
    }

    public void setRespuestas(String[] opciones){
        this.opciones = new JRadioButton[opciones.length];
        for(int i = 0; i < this.opciones.length; i++){
            this.opciones[i] = new JRadioButton(opciones[i]);
            grupo.add(this.opciones[i]);   
        }
    }
    
    public JRadioButton[] getOpciones() {
        return opciones;
    }

    public void setOpciones(JRadioButton[] opciones) {
        this.opciones = opciones;
    }
    
    public int respuestaSeleccionada(){
        for(int i = 0; i < this.opciones.length; i++){
            if(this.opciones[i].isSelected())
                return i;
        }
        return -1;
    }
    
    public int getSize(){
        return opciones.length;
    }
    
}
