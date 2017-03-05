package unidad2.MetodoFabricacion;

/**
 *
 * @author Alejandro
 */
public class ManipularPoligono extends Manipulador{
    
    public ManipularPoligono(){
       super();                
    }
   
    @Override
    public void crearFigura(){
        figura = new Poligono(100, 200, 30, "Cuadrado");
    }

    @Override
    public void escalar(int valor) {
        figura.setDimension(valor);
        figura.dibujar();
    }
}
