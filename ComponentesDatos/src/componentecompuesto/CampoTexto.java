package Componentecompuesto;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author eznayder
 */
public class CampoTexto extends JTextField implements Serializable,KeyListener, FocusListener{
    private int vMinimo=1;
    private int vMaximo=Integer.MAX_VALUE;;
    private int valor=0;
    
    
    public CampoTexto(){
        super();
        this.setLongMAX(10);
        this.setLongMin(1);
        this.setText(null);
        this.setColumns(vMaximo);
        //this.addActionListener(this);
        this.addKeyListener(this);
        this.addFocusListener(this);
    }
    
    public void setLongMin(int v){
        if(v < vMaximo){
           vMinimo = v;
        }
      
    }
    
    public void setLongMAX(int v){
        vMaximo= v>0 && v>vMinimo? v: Integer.MAX_VALUE;
        this.setColumns(vMaximo);
    }
    
     public int getLongMin(){
        return vMinimo;
    }
    
    public int getLongMAX(){
        return vMaximo;
    }
    
       

    @Override
    public void keyTyped(KeyEvent e) {
        char c=e.getKeyChar();
        System.out.print(e.getKeyCode());
        if( (Character.isAlphabetic(e.getKeyChar()) || e.getKeyChar() == ' ' ) 
             && (this.getText().length() <= vMaximo) ){
             
           }
        else{
             e.consume();
        }
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
       if(this.getText().length() < vMinimo){
          JOptionPane.showMessageDialog(this,"Caracteres minimos : "+ vMinimo);
       }
       
    
    }
   
    
    
}
