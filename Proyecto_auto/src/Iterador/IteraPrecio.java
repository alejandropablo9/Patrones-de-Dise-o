/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterador;

import Decorador.AudiSedan;

/**
 *
 * @author Ericko
 */
public class IteraPrecio implements Iterador {

    private Lista_Audis lista;
    private int contador;
    private float precio;
    // M para mayor que precio , m para menor que precio
    private char condicion;

    public IteraPrecio(Lista_Audis lista, float precio, char condicion) {
        this.lista = lista;
        this.precio = precio;
        this.condicion = condicion;
        contador = 0;
    }



    @Override
    public boolean hasNext() {
        return contador < lista.size();
    }

    @Override
    public AudiSedan next() {
        AudiSedan audi = lista.get(contador++);
        AudiSedan vacio = new AudiSedan('V', "", 0);
        if (condicion == 'M') {
            if (audi.getPrecio() >= precio) {
                return audi;
            } else {
                return vacio;
            }
        }
        if (condicion == 'm') {
            if (audi.getPrecio() <= precio) {
                return audi;
            } else {
                return vacio;
            }
        } else {
            return vacio;
        }

    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
