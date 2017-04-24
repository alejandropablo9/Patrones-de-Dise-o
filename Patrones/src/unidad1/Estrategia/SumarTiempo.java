/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad1.Estrategia;

/**
 *
 * @author Alejandro
 */
public class SumarTiempo implements Sumar{

    @Override
    public void suma(DatoMatCom dt1, DatoMatCom dt2) {
        dt1.dato1 = dt1.dato1 + dt2.dato1;
        dt1.dato2 = dt1.dato2 + dt2.dato2;
        if(dt1.dato2 >= 60){
            dt1.dato2 -= 60;
            dt1.dato1 += 1;
        }  
    }
    
}
