package unidad1.ImporteConsumodeAgua;

/**
 *
 * @author Alejandro
 */
public class Proceso implements Runnable{
    private String tituloF = "ventana";
    
    public Proceso(String tituloF){
        this.tituloF = tituloF;
    }
    
    @Override
    public void run() {
        ImporteConsAgua imAgua = ImporteConsAgua.getInstancia(tituloF);
        imAgua.setVisible(true);
    }
    
}
