/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unidad1.Singleton;

/**
 *
 * @author jeovani ramon
 */
public class Proceso {
  private SingletonClasico osc;

public void run(){
osc = SingletonClasico.getInstancia();
}
}
