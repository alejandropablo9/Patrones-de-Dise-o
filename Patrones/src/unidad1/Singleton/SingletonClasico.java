/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad1.Singleton;

/**
 *
 * @author jeovani ramon
 */
public class SingletonClasico {
    private static SingletonClasico instancia;
    private static int numIns=0;
    
    protected SingletonClasico(){
    numIns++;
    }
    public static SingletonClasico getInstancia(){
    if(instancia == null){
        instancia = new SingletonClasico();
    }
    System.out.println("\n se creo una instancia ");
    return instancia;
    }
    public int numIns(){
    return numIns;
    }
    
    public static void main(String arg[]){
    SingletonClasico obj=new SingletonClasico(); //es poprque java considera la visibilidad protegido en el paquete
    SingletonClasico obj2=SingletonClasico.getInstancia();
    
    System.out.println(obj.numIns());
    
    
    }
    
    
}
