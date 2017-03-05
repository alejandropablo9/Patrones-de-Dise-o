package unidad1.Examen;

import javax.swing.JFrame;
/**
 *
 * @author alejandro
 */
public class SingletonFrameAdmin extends JFrame {
    private static SingletonFrameAdmin instancia;        
    private static int numIns=0;
    private static boolean admin = false;
    private static int maxIns;
    
    private SingletonFrameAdmin(boolean admin, int maxIns){        
        this.admin = admin;   
        this.maxIns = maxIns;
        this.setSize(400, 400);
        this.setTitle("Administrador");        
        //this.getContentPane().setBackground(color);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);        
    }
    
    public static SingletonFrameAdmin getInstancia(int maxIns){
        if(instancia == null && admin == false){               
            instancia = new SingletonFrameAdmin(true, maxIns);            
            System.out.println("\n se creo una instancia Administrador");
        }       
        return instancia;
    }
    
    public int numIns(){
        return numIns;
    }    

    public static int getMaxIns() {
        return maxIns;
    }        
            
    public boolean admin(){
        return admin;
    }
}
