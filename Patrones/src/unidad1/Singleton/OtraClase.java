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
public class OtraClase {
    int num;
    public OtraClase(){
    num++;
    }
    public void imprimir(){
    System.out.println("clase muestra"+num);
    }
    
    public static void main(String ar[]) throws Exception{
    //SingletonClasico obj2=SingletonClasico.getInstancia();
    //System.out.println(obj2.numIns());
    MyFrame m=new MyFrame();
    m.setVisible(true);
    
    }
}
