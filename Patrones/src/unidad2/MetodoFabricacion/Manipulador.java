package unidad2.MetodoFabricacion;

import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Alejandro
 */
public abstract class Manipulador extends JFrame{
    
    protected Figura figura;
    
    protected JButton btnEscalar;
    protected JButton btnArriba;
    protected JButton btnAbajo;
    protected JButton btnIzquierda;
    protected JButton btnDerecha;
    
    protected JPanel controles;
    protected JPanel pFigura;
    protected JLabel letTrasladar;
    protected JLabel letEscalar;
    protected JTextField textEscalar;
    
    private final int vTraslado;
    
    public Manipulador(){ 
        init(); 
        this.vTraslado = 5;
    }
    
    private void init(){
        
        /*Panel para los controles*/        
        controles = new JPanel();               
        controles.setBounds(0, 0, 100, 800);
        controles.setBackground(Color.LIGHT_GRAY);
        controles.setLayout(null);  
        
        pFigura = new JPanel();
        pFigura.setBounds(100, 0, 700, 800);
        pFigura.setBackground(Color.WHITE);
        pFigura.setLayout(null); 
        
        letEscalar = new JLabel("Escalar");
        letEscalar.setBounds(20, 20, 50, 10);
        letTrasladar = new JLabel("Trasladar");
        letTrasladar.setBounds(20, 120, 70, 10);
        
        textEscalar = new JTextField(5);
        textEscalar.setBounds(20, 40, 50, 20);
                
        btnEscalar = new JButton("ok");
        btnEscalar.setBounds(20, 70, 50, 20);
        btnEscalar.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int valor = Integer.parseInt(textEscalar.getText());
                escalar(valor);
            }
        });
        
        btnArriba = new JButton("↑");
        btnArriba.setBounds(25, 140, 45, 20);               
        btnArriba.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trasladar(figura.getX(), figura.getY() - vTraslado);
            }
        });
        
        btnIzquierda = new JButton("←");
        btnIzquierda.setBounds(0, 160, 50, 20);
        btnIzquierda.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trasladar(figura.getX() - vTraslado, figura.getY());
            }
        });
        
        btnDerecha = new JButton("→");
        btnDerecha.setBounds(50, 160, 50, 20);
        btnDerecha.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trasladar(figura.getX() + vTraslado, figura.getY());
            }
        });
        
        btnAbajo = new JButton("↓");
        btnAbajo.setBounds(25, 180, 45, 20);        
        btnAbajo.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                trasladar(figura.getX(), figura.getY() + vTraslado);
            }
        });
        controles.add(letEscalar);
        controles.add(letTrasladar);
        controles.add(textEscalar);
        controles.add(btnEscalar);
        controles.add(btnArriba);
        controles.add(btnIzquierda);
        controles.add(btnDerecha);
        controles.add(btnAbajo);               
        
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);        
        this.setLayout(null);        
        this.setSize(800, 600);  
                
        this.add(controles);  
        crearFigura();
        pFigura.add(figura);
        pFigura.repaint();
        this.add(pFigura);       
    }
    
    public abstract void crearFigura();
    
    public void trasladar(int x, int y){
        figura.setX(x);
        figura.setY(y);
        figura.dibujar();
    }
    
    public abstract void escalar(int valor);        
}
