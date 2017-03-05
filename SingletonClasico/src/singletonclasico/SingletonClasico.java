package singletonclasico;
/**
 *
 * @author Alejandro
 */
public class SingletonClasico {

    private static volatile SingletonClasico instancia;
    private static int numIns = 0;
    
    protected SingletonClasico(){
        numIns++;
    }
    
    public static SingletonClasico getInstancia(){        
        if(instancia == null){
            synchronized (SingletonClasico.class) {
                if(instancia == null){
                    instancia = new SingletonClasico();            
                }
            }
        }
        System.out.println("\n se creo una instancia ");
        return instancia;
    }
    
    public int numIns(){
        return numIns;
    }
}
