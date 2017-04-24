package Decorador;

/**
 *
 * @author Alejandro
 */
public class AudiGenerico implements Audi {
    
    private String modelo;
    private double precio;
    
    public AudiGenerico(String modelo, double precio){
        this.modelo = modelo;
        this.precio = precio;              
    }
        
    @Override
    public double precio() {
        return precio;
    }

    @Override
    public String getModelo() {
        return modelo;
    }

    @Override
    public String getDescripcion() {
        return "Audi: " + modelo;
    }
    
   
}
