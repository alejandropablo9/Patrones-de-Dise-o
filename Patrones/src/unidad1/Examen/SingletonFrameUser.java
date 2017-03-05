package unidad1.Examen;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro
 */
public class SingletonFrameUser extends JFrame {
    private static SingletonFrameUser instancia;        
    private static int numIns=0;    
    private JButton boton1;
    
    private SingletonFrameUser(Color color){                       
        this.setSize(400, 400);    
        this.getContentPane().setBackground(color); 
        
        this.setLocationRelativeTo(null);
        this.setLayout(null);  
        
        
        boton1 = new JButton();
        boton1.setText("Salir");
        boton1.setBounds(30, 22, 220, 40);
        numIns++;
        
        
        boton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               dispose();
               numIns--;
            }
        });
        
        this.add(boton1);
        this.setTitle("user ");
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);        
    }
    
    public static SingletonFrameUser getInstancia(SingletonFrameAdmin sfa){        
        if(sfa.admin() && numIns < sfa.getMaxIns()){               
            instancia = new SingletonFrameUser(Color.BLUE);            
            System.out.println("\n se creo una instancia usuario");
        }       
        return instancia;
    }
    
    public int numIns(){
        return numIns;
    }                    
}
