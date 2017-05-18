package questionario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.io.Serializable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author alejandro
 */
public class PreguntaOpMultiple extends JPanel implements Serializable{
    
    private JLabel pregunta;
    private Opciones opciones;
    private int respuesta;
    private JPanel opbuttons;
   
    public PreguntaOpMultiple(){
        super();
        init();
    }
    
    private void init(){
        this.opciones = new Opciones();        
        this.pregunta = new JLabel("pregunta");   
        this.pregunta.setHorizontalAlignment(JLabel.CENTER);
        this.opbuttons = new JPanel();
        this.opbuttons.setLayout(new FlowLayout());
        this.opbuttons.setOpaque(false);
        this.setLayout(new BorderLayout());
        this.add(pregunta, BorderLayout.NORTH);        
        this.setSize(200, 400);   
    }
    
    public void setOpciones(String[] opciones){
        if(opciones.length >= 2){
            this.opciones.setRespuestas(opciones);
            this.agregarRespuestas();
        }else{
            JOptionPane.showMessageDialog( null, "debe de haber 2 o más opciones" );
        }
    }
        
    public void setRespuesta(int respuesta){
        if(respuesta > 0 && respuesta < opciones.getOpciones().length + 1)
            this.respuesta = respuesta;
        else
            JOptionPane.showMessageDialog( null, "La numero de respuesta debe de ser entre 1 y " + opciones.getSize() );
    }
    
    public void setPregunta(String pregunta){
        this.pregunta.setText(pregunta);
    }
    
    public boolean esCorrecto(){
        marcarRespuesta();
        return respuesta == (opciones.respuestaSeleccionada() + 1);        
    }
    
    private void marcarRespuesta(){
        JRadioButton[] op = opciones.getOpciones();
        int selec = opciones.respuestaSeleccionada();
        if(selec != -1){
            op[selec].setForeground(Color.RED);                
            op[respuesta-1].setForeground(Color.GREEN);
        }
    }
    
    private void agregarRespuestas(){
        this.opbuttons.removeAll();
        JRadioButton[] op = opciones.getOpciones();
        for (JRadioButton r : op) {
            opbuttons.add(r);
        }
        this.add(opbuttons, BorderLayout.CENTER);
    }
}
