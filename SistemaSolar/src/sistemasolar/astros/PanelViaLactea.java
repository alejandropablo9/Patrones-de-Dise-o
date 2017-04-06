package sistemasolar.astros;

import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro
 */
public class PanelViaLactea extends Panel{
    
    public static void main( String[] args ){
        JFrame frame = new JFrame();
        frame.setLayout( new FlowLayout() );
        frame.add( new PanelViaLactea() );
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);       
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
    }
        
    @Override
    protected void load(){
        BufferedReader br = null;
        //-------------------[ SUBTITULO ]--------------------------------------
        String contenido_file = "subtitulo";
        
        
        label_subtitulo.setText(contenido_file);
        //-----------------[ INFORMACION ]--------------------------------------
        contenido_file = "informacion";
        
        
        textpane_informacion.setText(contenido_file);
        
        //------------[ LABELS ]---------------------------------------------------
        //label_nombre.setIcon( new ImageIcon("src/planetas/tierra.png"));
        //label_diagrama.setIcon( new ImageIcon("src/planetas/tierra_focus.png"));
        //------------[ FIN LABELS ]-----------------------------------------------
                 

        panel_lienzo.repaint();
    }
}