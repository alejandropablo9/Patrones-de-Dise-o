package unidad2.Decorador.Ventana;

public class Test{    

    public static void main(String[] args){
   
        Ventana a = new VentanaBoton(new VentanaConcreta());
        a.dibujar();
        Ventana c = new VentanaBorde(new VentanaBoton(new VentanaConcreta()));                  
        c.dibujar();
        
        //Ventana v = new VentanaBoton(new VentanaBorde(new VentanaConcreta()));                  
        //v.dibujar();
    }
    
}
