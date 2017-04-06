
package unidad2.Decorador.Examen;

/**
 *
 * @author Alejandro
 */
public class CadenaConcreta implements Cadena{

    protected String caracteres;
    
    @Override
    public void establecerDatos(String caracteres) {
        this.caracteres = caracteres;
    }

    @Override
    public void escribir() {
        
    }

    @Override
    public void convertirMayusculas() {
        this.caracteres = this.caracteres.toUpperCase();
    }

    @Override
    public void convertiMinisculas() {
        this.caracteres = caracteres.toLowerCase();
    }
    
    @Override
    public String getCadena() {
       return caracteres;
    }
    
}
