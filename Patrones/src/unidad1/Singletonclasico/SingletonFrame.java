/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad1.Singletonclasico;

import javax.swing.JFrame;

/**
 *
 * @author Alejandro
 */
public class SingletonFrame extends JFrame {
 
    private static SingletonFrame myInstance;
    
    public SingletonFrame(){  
        super("Instancia Singleton");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        setVisible(true);
    }

    public static SingletonFrame getInstancia(){
        if(myInstance == null )
            myInstance = new SingletonFrame();
        
        return myInstance;
    }
}