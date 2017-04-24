package componentesdatos;

import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class VentanaPrueba extends JFrame{
    
    private JTextField compTexto;
    private JTextField compTexto2;
    public VentanaPrueba(){       
        init();        
    }
    
    private void init(){
        compTexto = new ComponenteTexto();
        compTexto2 = new ComponenteTexto();
        ((ComponenteTexto)compTexto2).setLongMax(10);
        ((ComponenteTexto)compTexto2).setLongMin(5);
        this.setLayout(new FlowLayout());
        //this.add(compTexto);
        this.add(compTexto2);
        this.setSize(400, 300);
        this.setTitle("Prueba"); 
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);  
    }
    
}
