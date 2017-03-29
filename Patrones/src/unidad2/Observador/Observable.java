package unidad2.Observador;

/**
 *
 * @author Alejandro
 */
public interface Observable {
    
    public void registarObservador(Observador o);
    public void removerObservador(int i);
    public void notificar();
    
}
