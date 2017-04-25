package componentesdatos;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class ComponenteTexto extends JTextField implements Serializable, 
        KeyListener, FocusListener {
    
    private int longMax;
    private int longMin = 1;   
    //private boolean activado = false;
    
    public ComponenteTexto(){
        super();
        init();
    }
    
    private void init(){
        longMax = 4;
        longMin= 1;
        setColumns(longMax);
        addKeyListener(this);
        addFocusListener(this);
    }
    
    public void setLongMax(int longMax) {        
        if(longMax >= longMin)
            this.longMax = longMax;
        else
            this.longMax = longMin;
    }

    public void setLongMin(int longMin) {
        //si la longMin es mayor que longMax invierte los valores
        if(longMin >= this.longMax){
            this.longMin = this.longMax;
            this.longMax = longMin;            
        }
        else 
            this.longMin = longMin;
    }

    public int getLongMax() {
        return longMax;
    }

    public int getLongMin() {
        return longMin;
    }        
    
    @Override
    public void keyTyped(KeyEvent e) {
        if((!Character.isAlphabetic( e.getKeyChar() ) 
                && e.getKeyChar() != ' ') 
                || (this.getText().length() >= this.getLongMax()))
            e.consume();                  
    }

    @Override
    public void keyPressed(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }

    @Override
    public void focusGained(FocusEvent e) {
    }

    @Override
    public void focusLost(FocusEvent e) {        
        if(this.getText().length() < this.getLongMin()){
            //this.requestFocus();
            JOptionPane.showMessageDialog(null, "Caracteres minimos requeridos " + this.getLongMin());
        }
    }
      
    
}
