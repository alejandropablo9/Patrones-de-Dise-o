package unidad2.Decorador.Ventana_;

/**
 *
 * @author Alejandro
 */
public abstract class VentanaDecoradora implements Ventana{
    
    Ventana v; 
    
    public VentanaDecoradora(Ventana v){
        this.v = v;
    }
        
}
