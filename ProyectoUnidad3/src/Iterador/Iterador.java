package Iterador;

import Decorador.AudiGenerico;

/**
 *
 * @author Ericko
 */
public interface Iterador {
    public boolean hasNext();
    public AudiGenerico next();
    public void remove();
}
