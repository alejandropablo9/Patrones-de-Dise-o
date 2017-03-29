package unidad2.Decorador.Ventana;

public abstract class VentanaDecoradora implements Ventana {
    
    protected Ventana v;
    
    public VentanaDecoradora(Ventana v){
        this.v = v;       
    }
    
}