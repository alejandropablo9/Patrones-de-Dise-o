/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentecompuesto;

import javax.swing.JLabel;

/**
 *
 * @author eznayder
 */
public class Titulo extends JLabel{
private String posicion="izquierda";
public Titulo(){
  super();
  this.setText("Titulo");
}

public void setPosicion(String p){
    posicion = p;
}

public String getPosicion(){
   return posicion;
}


 public void setTitulo(String v){
      this.setText(v);
 }
 
 public String getTitulo(){
      return this.getText();
 }


}


