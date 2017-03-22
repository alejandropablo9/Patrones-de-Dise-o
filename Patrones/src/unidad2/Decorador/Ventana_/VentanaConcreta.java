package unidad2.Decorador.Ventana_;

/**
 *
 * @author Alejandro
 */
public class VentanaConcreta implements Ventana{
    
    
    
    @Override
    public void dibujar() {
        System.out.println("Simple");
    }

    @Override
    public String getNombre() {
        return "Ventana Simple";
    }
    
}
