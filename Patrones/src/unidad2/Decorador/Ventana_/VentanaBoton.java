package unidad2.Decorador.Ventana_;

/**
 *
 * @author Alejandro
 */
public class VentanaBoton extends VentanaDecoradora{
    
    public VentanaBoton(Ventana v){
        super(v);
    }
    
    @Override
    public void dibujar(){
        v.dibujar();
        System.out.println("con BOTON");
    }
    
    @Override
    public String getNombre(){
        return "Con Boton";
    }
}
