package unidad2.Decorador.Ventana_;

/**
 *
 * @author Alejandro
 */
public class VentanaBorde extends VentanaDecoradora{
    
    public VentanaBorde(Ventana v){
        super(v);
    }
    
    @Override
    public void dibujar(){
        v.dibujar();
        System.out.println("con BORDE");
    }
    
    @Override
    public String getNombre(){
        return "Con Borde";
    }
}
