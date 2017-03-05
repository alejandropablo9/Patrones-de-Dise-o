package unidad1.ImporteConsumodeAgua;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author alejandro
 */
public class MyFrame extends JFrame {
    
    private JButton boton1;
    private JButton boton2;
    
    public MyFrame() throws Exception{
        init();    
    }

    private void init() throws Exception{
        this.setDefaultCloseOperation( EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(null);        
        boton1 = new JButton();
        boton1.setText("Administrador");
        boton1.setBounds(30, 22, 220, 40);
        
        boton2 = new JButton();
        boton2.setText("Usuario");
        boton2.setBounds(30, 70, 220, 40);
        
        boton1.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {      
                    AccionBtn1(e);
                } catch (InterruptedException ex) {
                    Logger.getLogger(MyFrame.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });                       
        this.add(boton1);        
    }
    
    public void AccionBtn1(ActionEvent e) throws InterruptedException{
        Proceso p = new Proceso("Importe consumo de agua 1");
        Proceso p2 = new Proceso("Importe consumo de agua 2");
        Thread t1 = new Thread(p);
        Thread t2 = new Thread(p);
        Thread t3 = new Thread(p2);
        Thread t4 = new Thread(p2);
        
        t1.start();
        Thread.sleep(3000);
        t2.start();
        Thread.sleep(3000); 
        t3.start();
        Thread.sleep(3000);  
        t4.start();
        Thread.sleep(3000); 
    }
           
    public static void main(String ar[]) throws Exception{  
        MyFrame m=new MyFrame();
        m.setSize(300, 200);
        m.setVisible(true);    
    }        
}
