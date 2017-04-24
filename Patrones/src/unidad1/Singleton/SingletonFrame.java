package unidad1.Singleton;

import javax.swing.JFrame;
import java.awt.*;
/**
 *
 * @author alejandro
 */
public class SingletonFrame extends JFrame {
    private static SingletonFrame instancia;        
    private static int numIns=0;
    private static boolean admin = false;
    
    private SingletonFrame(){        
        this.admin = admin;                
        this.setSize(400, 400);
        this.setTitle("Instancia: "+Math.random());
        numIns++;
        //this.getContentPane().setBackground(color);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);        
    }
    
    public static SingletonFrame getInstancia(){
        if(instancia == null && admin == false){               
            instancia = new SingletonFrame();            
            System.out.println("\n se creo una instancia Administrador");
        }       
        return instancia;
    }
    
    public int numIns(){
        return numIns;
    }    
    
    public boolean admin(){
        return admin;
    }
}
