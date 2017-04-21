/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Iterador;

import Decorador.AudiGenerico;

/**
 *
 * @author Ericko
 */
public class IteraTipo implements Iterador {

    private Lista_Audis lista;
    private int contador;
    private char tipo;

    public IteraTipo(Lista_Audis lista, char tipo) {
        this.lista = lista;
        this.tipo = tipo;
        contador = 0;
    }

    @Override
    public boolean hasNext() {
        return contador < lista.size();
    }

    @Override
    public AudiGenerico next() {
        AudiGenerico audi = lista.get(contador++);
        
        AudiGenerico vacio = new AudiGenerico('V', "", 0);
        if (tipo == 'C') {
            if (audi.AudiGenerico()== tipo) {
                return audi;
            } else {
                return vacio;
            }
        }
        if (tipo == 'F') {
            if (audi.AudiGenerico()== tipo) {
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
