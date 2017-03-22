package unidad2.Decorador.Ventana;

import java.awt.Component;

public interface Ventana {
    
    public void dibujar();
    public String getNombre();
    public void addComponent(Component c);     
    
}