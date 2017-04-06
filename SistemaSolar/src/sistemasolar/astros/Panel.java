
package sistemasolar.astros;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author Alejandro
 */
public abstract class Panel extends JPanel{
    protected JLabel label_titulo, label_subtitulo, label_notificacion, label_nombre, label_diagrama;
    protected JTextPane textpane_informacion;
    protected JPanel panel_botones, panel_lienzo, panel_simbologia;
    protected JButton boton_mercurio, boton_venus, boton_tierra, boton_marte, boton_jupiter, boton_saturno,
                      boton_urano, boton_neptuno, boton_sol;
    
    public Panel(){
        super( new BorderLayout() );
        initComponents();
        load();
    }
    
    private void initComponents(){
        label_titulo = new JLabel("Sistema Solar");
        label_subtitulo = new JLabel();
        label_notificacion = new JLabel("NOTIFICACIONES");
        label_nombre = new JLabel();
        label_diagrama = new JLabel();
        textpane_informacion = new JTextPane();
        panel_botones = new JPanel();
        panel_lienzo = new JPanel();
        
        boton_mercurio= new FancyButton(
                "src/planetas/mercurio.png",
                "src/planetas/mercurio_focus.png",
                "src/planetas/mercurio_focus.png"
        );
        
        boton_venus= new FancyButton(
                "src/planetas/venus.png",
                "src/planetas/venus_focus.png",
                "src/planetas/venus_focus.png"
        );
        
        boton_tierra = new FancyButton(
                "src/planetas/tierra.png",
                "src/planetas/tierra_focus.png",
                "src/planetas/tierra_focus.png"
        );
        
        boton_marte = new FancyButton(
                "src/planetas/marte.png",
                "src/planetas/marte_focus.png",
                "src/planetas/marte_focus.png"
        );
        
        boton_jupiter = new FancyButton(
                "src/planetas/jupiter.png",
                "src/planetas/jupiter_focus.png",
                "src/planetas/jupiter_focus.png"
        );
        
        boton_saturno = new FancyButton(
                "src/planetas/saturno.png",
                "src/planetas/saturno_focus.png",
                "src/planetas/saturno_focus.png"
        );
        
        boton_urano = new FancyButton(
                "src/planetas/urano.png",
                "src/planetas/urano_focus.png",
                "src/planetas/urano_focus.png"
        );
        
        boton_neptuno = new FancyButton(
                "src/planetas/neptuno.png",
                "src/planetas/neptuno_focus.png",
                "src/planetas/neptuno_focus.png"
        );
                
        
        label_titulo.setPreferredSize( new Dimension(815, 35));
        label_titulo.setBorder( BorderFactory.createEtchedBorder() );
        
        label_subtitulo.setPreferredSize( new Dimension(200, 67));
        
        label_notificacion.setEnabled(false);
        label_notificacion.setBounds(20, 5, 500, 17);
        
        textpane_informacion.setEditable(false);
        textpane_informacion.setPreferredSize( new Dimension(200, 468) );
        
        panel_botones.setPreferredSize( new Dimension(725, 70) );
        panel_botones.setBorder( BorderFactory.createEtchedBorder() );
        
        //panel_botones.add( boton_sol );
        panel_botones.add( boton_mercurio );
        panel_botones.add( boton_venus );
        panel_botones.add( boton_tierra );
        panel_botones.add( boton_marte );
        panel_botones.add( boton_jupiter );
        panel_botones.add( boton_saturno );
        panel_botones.add( boton_urano );
        panel_botones.add( boton_neptuno );        
        
        panel_lienzo.setLayout(null);
        panel_lienzo.setPreferredSize( new Dimension(725, 500) );
        panel_lienzo.setBackground(Color.BLACK);
        panel_lienzo.add(  label_notificacion );        
        
        JPanel panel_dibujo = new JPanel( new BorderLayout() );
        panel_dibujo.setBackground(Color.BLACK);
        panel_dibujo.setPreferredSize( new Dimension(725, 500) );
        panel_dibujo.setBorder( BorderFactory.createEtchedBorder() );
        panel_dibujo.add(panel_lienzo, BorderLayout.CENTER);

        
        JPanel panel_cuerpo = new JPanel( new GridBagLayout() );
        GridBagConstraints gbconstrains = new GridBagConstraints();
        
        gbconstrains.insets = new Insets(5, 5, 5, 5);
        
        gbconstrains.gridx = 0;
        gbconstrains.gridy = 0;
        gbconstrains.gridwidth = 4;
        gbconstrains.gridheight = 1;
        gbconstrains.fill = GridBagConstraints.NONE;
        panel_cuerpo.add( label_subtitulo, gbconstrains );
        
        gbconstrains.gridx = 0;
        gbconstrains.gridy = 1;
        gbconstrains.gridwidth = 4;
        gbconstrains.gridheight = 5;
        panel_cuerpo.add( textpane_informacion, gbconstrains);
        
        gbconstrains.gridx = 4;
        gbconstrains.gridy = 0;
        gbconstrains.gridwidth = 5;
        gbconstrains.gridheight = 2;
        panel_cuerpo.add( panel_botones, gbconstrains);
        
        gbconstrains.gridx = 4;
        gbconstrains.gridy = 2;
        gbconstrains.gridwidth = 5;
        gbconstrains.gridheight = 4;
        panel_cuerpo.add( panel_dibujo, gbconstrains);
        
        super.add(label_titulo, BorderLayout.NORTH);
        super.add(panel_cuerpo, BorderLayout.CENTER);
        
        //---------------------------------------------------------------------
        
        boton_tierra.addActionListener((ActionEvent e) -> {
            Astro tierra = new AstroConcreto(
                    "Carbono", 
                    "src/planet/terre.png"
            );
            tierra.setLocation(60, 25);
            panel_lienzo.add(tierra);
            panel_lienzo.repaint();
        });
        
        boton_mercurio.addActionListener((ActionEvent e) -> {
            Astro tierra = new AstroConcreto(
                    "Carbono", 
                    "src/planet/mercure.png"
            );
            tierra.setLocation(60, 25);
            panel_lienzo.add(tierra);
            panel_lienzo.repaint();
        });
    }
    
    protected abstract void load();
    
}