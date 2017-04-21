/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Observador;

import java.util.Date;
import Main.Main;

/**
 *
 * @author Alejandro
 */
public class Observable implements Observador, MonitorElemento {

    private double costo_total, costo_unitario;
    private String nombre;
    private Sujeto suj;

    public Observable(Sujeto sujeto) {
        this.suj = sujeto;
        sujeto.registraObservador(this);
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
