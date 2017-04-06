package unidad2.Decorador.Examen;

/**
 *
 * @author Alejandro
 */
public class CadenaAlineada extends CadenaDecorador{

    public CadenaAlineada(Cadena c) {
        super(c);
    }
    
    public String alinearIzquierda(){
        
        return c.getCadena().trim();
    }
    
    public String alinearDerecha(){
        String cadena = c.getCadena();        
        return "\t \t \t" + cadena; 
    }
    
    public String centrar(){
        String cadena = c.getCadena();        
        return "\t \t" + cadena;
    }
    
    public String justificar(){        
        String caracteres = c.getCadena();
        String nuevaCa = "";
        char arrayD[] = caracteres.toCharArray(); 
        int i = 0;
        while(i < arrayD.length){        
            nuevaCa += " ";
            nuevaCa += arrayD[i];            
            i++;
        } 
        return nuevaCa;
    }

    @Override
    public void establecerDatos(String caracteres) {
        c.establecerDatos(caracteres);
    }

    @Override
    public void escribir() {
        c.escribir();
    }

    @Override
    public void convertirMayusculas() {
        c.convertirMayusculas();
    }

    @Override
    public void convertiMinisculas() {
        c.convertiMinisculas();
    }
    
    @Override
    public String getCadena() {
       return c.getCadena();
    }
    
}
