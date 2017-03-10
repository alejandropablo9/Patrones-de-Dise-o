package unidad2.MetodoFabricacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public class Ventana extends JFrame{
    
    private Manipulador mt;
    private Manipulador mp;
    
    private JPanel pControles; 
    
    private JRadioButton rbTexto;
    private JRadioButton rbPoligono;
    private ButtonGroup grupoFigura;
            
    private JButton btnEscalar;
    private JButton btnArriba;
    private JButton btnAbajo;
    private JButton btnIzquierda;
    private JButton btnDerecha;
    private JButton btnDibujar;
    
    private JLabel letTrasladar;
    private JLabel letEscalar;
    private JLabel letNombre;
    private JLabel letDimension;
    private JLabel letFigura;
    
    private JTextField textEscalar;
    private JTextField textNombre;
    private JTextField textDimension;
    
    private final int vTraslado = 5;
    
    public Ventana(){      
        init();
    }        
    
    public void init(){      
        this.setLayout(null);        
        this.setSize(800, 600);  
        this.setDefaultCloseOperation(EXIT_ON_CLOSE); 
        this.setResizable(false);
        
        mt = new ManipularTexto();
        mp = new ManipularPoligono();
        
        mp.setBounds(400, 0, 450, 450);
        
        pControles = new JPanel();
        pControles.setBounds(0, 450, 800, 150);
        pControles.setBackground(Color.LIGHT_GRAY);       
        pControles.setLayout(null);
        
        rbTexto = new JRadioButton("Texto");
        rbPoligono = new JRadioButton("Poligono");  
        grupoFigura = new ButtonGroup();
        grupoFigura.add(rbTexto);
        grupoFigura.add(rbPoligono);
        rbTexto.setSelected(true);
        
        letNombre = new JLabel("Nombre:");
        letNombre.setBounds(20, 20, 50, 20);        
        textNombre = new JTextField(15);
        textNombre.setBounds(80, 20, 70, 20);
        
        letDimension = new JLabel("Dimension:");
        letDimension.setBounds(9, 40, 70, 20);        
        textDimension = new JTextField(15);
        textDimension.setBounds(80, 40, 70, 20);
        
        letFigura = new JLabel("Figura: ");
        letFigura.setBounds(170, 20, 70, 20);
        rbTexto.setBounds(170, 40, 60, 20);
        rbTexto.setBackground(Color.LIGHT_GRAY);
        rbPoligono.setBounds(230, 40, 80, 20);
        rbPoligono.setBackground(Color.LIGHT_GRAY);
        
        btnDibujar = new JButton("Dibujar");
        btnDibujar.setBounds(170, 80, 90, 20);
        btnDibujar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int d;
                String n;
                if(!textDimension.getText().equals(""))
                    d = Integer.parseInt(textDimension.getText());
                else 
                    d = 0;
                if(!textNombre.getText().equals(""))
                    n = textNombre.getText(); 
                else 
                    n = "";                               
                if(rbPoligono.isSelected()){
                    mp.removeAll();
                    mp.manipular(50, 50, d, 100, n);  
                    mp.crearFigura();
                    mp.presentacion();
                }else{        
                    mt.removeAll();
                    mt.manipular(50, 50, d, 100, n);
                    mt.crearFigura();
                    mt.presentacion();
                }
                
                repaint();                
            }
        });
        
        letEscalar = new JLabel("Escalar");
        letEscalar.setBounds(400, 20, 50, 20);
        letTrasladar = new JLabel("Trasladar");
        letTrasladar.setBounds(500, 20, 70, 20);
        
        textEscalar = new JTextField(5);
        textEscalar.setBounds(400, 40, 50, 20);
                
        btnEscalar = new JButton("ok");
        btnEscalar.setBounds(400, 70, 50, 20);
        btnEscalar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(textEscalar.getText());
                if(rbPoligono.isSelected())
                    mp.escalar(valor);
                else
                    mt.escalar(valor);
            }
        });
        
        btnArriba = new JButton("↑");
        btnArriba.setBounds(505, 40, 45, 20);               
        btnArriba.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbPoligono.isSelected()){
                    mp.trasladar(0, -vTraslado);
                }else{
                    mt.trasladar(0, -vTraslado);
                }
                //trasladar(figura.getX(), figura.getY() - vTraslado);
            }
        });
        
        btnIzquierda = new JButton("←");
        btnIzquierda.setBounds(480, 60, 50, 20);
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbPoligono.isSelected()){
                    mp.trasladar(-vTraslado, 0);
                }else{
                    mt.trasladar(-vTraslado, 0);
                }
                //trasladar(figura.getX() - vTraslado, figura.getY());
            }
        });
        
        btnDerecha = new JButton("→");
        btnDerecha.setBounds(530, 60, 50, 20);
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbPoligono.isSelected()){
                    mp.trasladar(vTraslado, 0);
                }else{
                    mt.trasladar(vTraslado, 0);
                }
                //trasladar(figura.getX() + vTraslado, figura.getY());
            }
        });
        
        btnAbajo = new JButton("↓");
        btnAbajo.setBounds(505, 80, 45, 20);        
        btnAbajo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rbPoligono.isSelected()){
                    mp.trasladar(0, vTraslado);
                }else{
                    mt.trasladar(0, vTraslado);
                }
                //trasladar(figura.getX(), figura.getY() + vTraslado);
            }
        });
                
        
        pControles.add(letTrasladar);
        pControles.add(textEscalar);
        pControles.add(btnEscalar);
        pControles.add(btnArriba);
        pControles.add(btnIzquierda);
        pControles.add(btnDerecha);
        pControles.add(btnAbajo);    
  
        pControles.add(letEscalar);
        
        pControles.add(letNombre);
        pControles.add(textNombre);
        pControles.add(letDimension);
        pControles.add(textDimension);
        pControles.add(letFigura);
        pControles.add(rbTexto);
        pControles.add(rbPoligono);
        pControles.add(btnDibujar);
        
        this.add(pControles);  
        this.add(mt);
        this.add(mp);
    }    
    
}
