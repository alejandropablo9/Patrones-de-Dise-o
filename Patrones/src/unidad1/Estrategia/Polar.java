package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class Polar extends DatoMatCom{
    
    public Polar(double dato1, double dato2) {
        super(dato1, dato2);
        opSumar = new SumaSiDato2();
        opMult = new ProductoPolar();
    }

    @Override
    public void mostrar() {
        System.out.println(dato1+", "+dato2+"°");
    }
}
