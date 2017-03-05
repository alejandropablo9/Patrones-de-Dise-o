package unidad2.MetodoFabricacion;

/**
 *
 * @author Alejandro
 */
public class ManipularTexto extends Manipulador{
    
    public ManipularTexto(){
       super();                
    }
    
    @Override
    public void crearFigura(){
        figura = new Texto(24, 100, 30, "Metodo de Fabricación");
    }
    
    @Override
    public void escalar(int valor){
        figura.setDimension(valor);
        figura.dibujar();
    }
}
