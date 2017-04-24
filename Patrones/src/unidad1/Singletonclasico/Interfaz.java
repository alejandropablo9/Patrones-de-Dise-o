/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad1.Singletonclasico;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author Alejandro
 */
public class Interfaz extends JFrame {

    private JButton boton1, boton2;

    public Interfaz( ) {

        super("Singleton");
        setSize(300,300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        Container lienzo = getContentPane();
        lienzo.setLayout(null);

        manejador_boton1 mb = new manejador_boton1();
        manejador_boton2 mb2=new manejador_boton2();


        boton1=new JButton("AGREGAR SINGLETON");
        boton1.setBounds(45, 70, 200, 50);
        boton1.setFont(new java.awt.Font("Bodoni MT Black",0, 12));
        boton1.setForeground(Color.red);
        boton1.addActionListener((ActionListener) mb);
        lienzo.add(boton1);

        boton2=new JButton("AGREGAR OTRO SINGLETON ");
        boton2.setBounds(45, 180, 200, 50);
        boton2.setFont(new java.awt.Font("Bodoni MT Black",0, 12));
        boton2.setForeground(Color.red);
        boton2.addActionListener(mb2);
        lienzo.add(boton2);
    }

    private class manejador_boton1 implements ActionListener{
      @Override
      public void actionPerformed(ActionEvent e) {

        SingletonFrame inst = SingletonFrame.getInstancia();

        System.out.print("se presiono");
      }
    }


    private class manejador_boton2 implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }

    public static void main(String args[]) {
        Interfaz gray = new Interfaz( );
        gray.setVisible(true);
    }
}