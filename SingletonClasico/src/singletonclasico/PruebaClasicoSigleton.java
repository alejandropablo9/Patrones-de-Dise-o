package singletonclasico;

/**
 *
 * @author Alejandro
 */
public class PruebaClasicoSigleton {
    private static int ni = 0;
    
    public static void main(String args[]){
        //Java considera a la visilidad protegida como si fuera igual que el alcance de paquete 
        SingletonClasico instancia = new SingletonClasico(); 
        System.out.println("Número de instancias creadas: "+ instancia.numIns());
        
    }
}
