/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterador;

import Decorador.AudiGenerico;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ericko
 */
public class Lista_Audis {

    private ArrayList<AudiGenerico> array_audis;

    public Lista_Audis() {
        array_audis = new ArrayList<>();
    }

    public void add(AudiGenerico audi) {
        array_audis.add(audi);
    }

    public void mostrar(Iterador it) {
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
    }

    public DefaultTableModel modelo_tabla(Iterador it) {
        DefaultTableModel modelo;
        String[] titulos = { "Nombre", "Costo"};
        String[] registros = new String[2];
        modelo = new DefaultTableModel(null, titulos);

        while (it.hasNext()) {
            AudiGenerico temp = it.next();
            if (temp.getTipo() != 'V') { // Checa que no sea un vacio

                //registros[0] = temp.getTipo() + "";
                registros[0] = temp.getModelo();
                registros[1] = temp.getPrecio() + "";
                modelo.addRow(registros);
            }
        }
        return modelo;
    }

    public DefaultComboBoxModel modelo_combo(IteraTipo it) {
        DefaultComboBoxModel modelo = new DefaultComboBoxModel();
        while (it.hasNext()) {
            AudiGenerico temp = it.next();
            if (temp.getTipo() != 'V') {
                modelo.addElement(temp.getModelo());
            }
        }
        return modelo;
    }

    public int size() {
        return array_audis.size();
    }

    public AudiGenerico get(int indice) {
        return array_audis.get(indice);
    }

    public double get_precio(String nombre, Iterador it) {
        double precio = 0;
        while (it.hasNext()) {
            AudiGenerico temp = it.next();
            if (temp.getModelo().equalsIgnoreCase(nombre)) {
                precio = temp.getPrecio();
            }
        }
        return precio;
    }

    public AudiGenerico get_elegido(String nombre, Iterador it) {
        // Imaginar que no existe
        AudiGenerico elegido = new AudiGenerico('V', "", 0);
        while (it.hasNext()) {
            AudiGenerico temp = it.next();
         
            if (temp.getModelo().equalsIgnoreCase(nombre)) {
                elegido = temp;
                 
            }
        }
        System.out.println("Regreso " + elegido.getModelo());
        return elegido;     
    }

}
