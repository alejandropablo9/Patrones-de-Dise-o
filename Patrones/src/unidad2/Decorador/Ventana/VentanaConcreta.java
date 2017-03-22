package unidad2.Decorador.Ventana;

import java.awt.Component;
import javax.swing.JFrame;

public class VentanaConcreta extends JFrame implements Ventana{ 
   
    @Override
    public void dibujar(){      
        this.setVisible(true);
        this.setSize(400, 300);
        this.setTitle("Ventana SIMPLE");  
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
    }
    
    @Override
    public void addComponent(Component c){    
        this.add(c);
    }
    
    @Override
    public String getNombre() {
        return "Ventana Simple";
    }
}