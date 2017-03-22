package unidad2.Decorador.Ventana_;

/**
 *
 * @author Alejandro
 */
public class Test {  
    
    public static void main(String[] xs){        
        Ventana vc = new VentanaConcreta();   
        Ventana vb = new VentanaBorde(vc);
        vb.dibujar();
        
        System.out.println("------------------------");        
        Ventana vbn = new VentanaBoton(new VentanaBorde(new VentanaConcreta()));
        vbn.dibujar();
        System.out.println("------------------------");
        Ventana vbr = new VentanaBorde(new VentanaBoton(new VentanaConcreta()));
        vbr.dibujar();
    }
    
}
