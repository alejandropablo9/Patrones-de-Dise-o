
package unidad2.Decorador.Examen;

/**
 *
 * @author Alejandro
 */
public class CadenaEncriptada extends CadenaDecorador{

    public CadenaEncriptada(Cadena c) {
        super(c);
    }
    
    public String cifrar(){ 
        String caracteres = c.getCadena();
        char array[] = caracteres.toCharArray(); 
         
        for(int i=0; i < array.length; i++){ 
            array[i]=(char)(array[i]+(char)5); 
        }                 
        return String.valueOf(array);
    }
    
    public String descifrar(){
        String caracteres = c.getCadena();
        char arrayD[] = caracteres.toCharArray(); 
        for(int i=0; i < arrayD.length;i++){ 
            arrayD[i] = (char)(arrayD[i]-(char)5); 
        } 
        System.out.println("arayyD");
        return String.valueOf(arrayD); 
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
