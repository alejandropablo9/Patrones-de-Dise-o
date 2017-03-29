package unidad2.Decorador.Ventana;

import java.awt.Color;
import java.awt.Component;
import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class VentanaBorde extends VentanaDecoradora{
        
    public VentanaBorde(Ventana v) {
        super(v);       
    }
    
     @Override
    public void addComponent(Component c){
        v.addComponent(c);
    }
    
    @Override
    public void dibujar() {
        v.dibujar();
        JPanel borde = new JPanel();
        borde.setVisible(true);
        borde.setBorder(BorderFactory.createLineBorder(Color.CYAN, 20));        
        addComponent(borde);                
    }
         
    @Override
    public String getNombre() {
        return v.getNombre()+", con BORDE";
    }    
}