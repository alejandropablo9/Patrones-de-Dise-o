package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public abstract class DatoMatCom {
    protected Sumar opSumar;
    protected Multiplicar opMult;
    protected double dato1;
    protected double dato2;
    
    public DatoMatCom(double dato1, double dato2){
        this.dato1 = dato1;
        this.dato2 = dato2;  
    }
        
    public void mostrar(){        
        System.out.println("Dato1: "+dato1+", Dato2: "+dato2);
    }
    
    public void sumar(DatoMatCom d){
        opSumar.suma(this, d);
    }
    
    public void producto(DatoMatCom d){
        opMult.multiplicar(this, d);
    }
}
