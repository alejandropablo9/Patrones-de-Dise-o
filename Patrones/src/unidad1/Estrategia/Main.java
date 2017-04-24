
package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Main {
    public static void main(String[] args) {
       testPunto();
       testComplejo();
       testFraccion();
       testPolar();
       testEcuacion();
       testExponente();
       testTiempo();
    }

    private static void testPunto(){
       DatoMatCom p1 = new Punto(-1,1);
       DatoMatCom p2 = new Punto(2, 2);
               
       System.out.println("Punto 1:");
       p1.mostrar();
       
       System.out.println("Punto 2:");
       p2.mostrar();
       
       System.out.println("Suma: ");
       p1.sumar(p2);
       p1.mostrar();
       
       System.out.println("Producto: ");
       p1.producto(p2);
       p1.mostrar();
    }
    
    private static void testComplejo(){
       DatoMatCom c1 = new Complejo(1,-1);
       DatoMatCom c2 = new Complejo(2,-2);
               
       System.out.println("Complejo 1:");
       c1.mostrar();
       
       System.out.println("Compejo 2:");
       c2.mostrar();
       
       System.out.println("Suma: ");
       c1.sumar(c2);
       c1.mostrar();
       
       System.out.println("Producto: ");
       c1.producto(c2);
       c1.mostrar();
    }
    
    private static void testFraccion(){
       DatoMatCom f1 = new Fraccion(1,4);
       DatoMatCom f2 = new Fraccion(3,4);
               
       System.out.println("Fraccion 1:");
       f1.mostrar();
       
       System.out.println("Fraccion 2:");
       f2.mostrar();
       
       System.out.println("Suma: ");
       f1.sumar(f2);
       f1.mostrar();
       
       System.out.println("Producto: ");
       f1.producto(f2);
       f1.mostrar();
    }
    
    private static void testPolar(){
       DatoMatCom f1 = new Polar(1,15);
       DatoMatCom f2 = new Polar(3,15);
               
       System.out.println("Polar 1:");
       f1.mostrar();
       
       System.out.println("Polar 2:");
       f2.mostrar();
       
       System.out.println("Suma: ");
       f1.sumar(f2);
       f1.mostrar();
       
       System.out.println("Producto: ");
       f1.producto(f2);
       f1.mostrar();
    }
    
    private static void testEcuacion(){
       DatoMatCom f1 = new Ecuacion(1,15);
       DatoMatCom f2 = new Ecuacion(3,15);
               
       System.out.println("Ecuacion 1:");
       f1.mostrar();
       
       System.out.println("Ecuacion 2:");
       f2.mostrar();
       
       System.out.println("Suma: ");
       f1.sumar(f2);
       f1.mostrar();     
    }
    
    private static void testExponente(){
       DatoMatCom f1 = new Exponente(3,2);
       DatoMatCom f2 = new Exponente(3,3);
               
       System.out.println("Exponente 1:");
       f1.mostrar();
       
       System.out.println("Exponente 2:");
       f2.mostrar();
       
       System.out.println("Suma: ");
       f1.sumar(f2);
       f1.mostrar();  
             
       System.out.println("Producto: ");
       f1.producto(f2);
       f1.mostrar();
    }
    
    private static void testTiempo(){
       DatoMatCom f1 = new Tiempo(2,25);
       DatoMatCom f2 = new Tiempo(2,40);
               
       System.out.println("Tiempo 1:");
       f1.mostrar();
       
       System.out.println("Tiempo 2:");
       f2.mostrar();
       
       System.out.println("Suma: ");
       f1.sumar(f2);
       f1.mostrar();  
    }
}

