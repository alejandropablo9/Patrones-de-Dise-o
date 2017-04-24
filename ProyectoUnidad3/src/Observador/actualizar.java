/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import Main.Main;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author Ericko
 */
public class actualizar  implements Observador{
    private double costo_total, costo_unitario;
    private String nombre;
    private Sujeto suj;
    public actualizar (Sujeto os){
        suj=os;
        //registrar el obsevador haciendo referencia asi mismo 
        suj.registraObservador(this);
        System.out.println("Desde actualizar en el paquete observador de este proyecto");
    }
    @Override
     public void actualiza(double costo_total, double costo_unitario, String nombre) {
        this.costo_total = costo_total;
        this.costo_unitario = costo_unitario;
        this.nombre = nombre;
        Telepantalla();
    }
    @Override
    public void Telepantalla() {
        String cadena = ("Observador :\n " + getFechaActual() + "\nAuto" + nombre 
                + "\nCosto total " + costo_total + "\nCosto Unitario " + costo_unitario);

        Main.areaInforme.append(cadena + "\n");
    }
     private String getFechaActual() {
        return new Date().toString();
    }
}
