package unidad1.Singleton;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author alejandro
 */
public class MyFrame extends JFrame {
    
    private JButton boton1;
    private JButton boton2;
    SingletonFrame sj;
    
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
               AccionBtn1(e);      
            }
        });
        
        boton2.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               AccionBtn2(e);      
            }
        });
        
        this.add(boton1);
        this.add(boton2);
    }
    
    public void AccionBtn1(ActionEvent e){
        sj=SingletonFrame.getInstancia();
        sj.setVisible(true);
    }
    
    public void AccionBtn2(ActionEvent e){
        if(sj.admin()){
            SingletonFrame sj=SingletonFrame.getInstancia();
            sj.setVisible(true);
        }
    }
        
    public static void main(String ar[]) throws Exception{  
        MyFrame m=new MyFrame();
        m.setSize(300, 200);
        m.setVisible(true);    
    }        
}
