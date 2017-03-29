package unidad2.Decorador.Ventana;

import java.awt.Component;
import javax.swing.JButton;

public class VentanaBoton extends VentanaDecoradora{
    
    public VentanaBoton(Ventana v) {
        super(v);
    }

    @Override
    public void dibujar() {
        v.dibujar();
        JButton b = new JButton("BOTON");        
        b.setBounds(125, 120, 150, 30);           
        v.addComponent(b);
    }
    
    @Override
    public void addComponent(Component c){
           v.addComponent(c);           
    }
    
    @Override
    public String getNombre() {
        return v.getNombre()+", con BOTON";
    }
    
}