/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Componentecompuesto;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author alejandro
 */
public class ComponenteCompuesto extends JPanel {
    
private CampoTexto texto = new CampoTexto();;
private ArrayList <Titulo> etiquetas;
private int num_etiquetas = 0;

public ComponenteCompuesto(){


setLayout(null);
setSize(200,100);

Titulo eti=new Titulo();
mover(eti,eti.getPosicion());
num_etiquetas++;
add(eti);

etiquetas= new ArrayList();    
etiquetas.add(eti);
        
texto.setBounds(this.getWidth()/3,this.getHeight()/3,texto.getLongMAX()*5,20);
add(texto);


}

public void mover(JLabel eti, String p){
    int y = this.getHeight()/3;
    texto.setBounds(this.getWidth()/3,this.getHeight()/3,texto.getLongMAX()*5,20);
    if(p.equals("izquierda")){
        int x = 10;
        eti.setBounds(x, y, eti.getText().length()*10, 20);
    }
    if(p.equals("derecha")){ 
        int x = (this.getWidth()/3)*2;
        eti.setBounds(x, y, eti.getText().length()*10, 20);
    }
    if(p.equals("arriba")){
        int x = this.getWidth()/3;
        y=10;
        eti.setBounds(x, y, eti.getText().length()*10, 20);
      }
    if(p.equals("abajo")){
        int x = this.getWidth()/3;
        y = y*2;
        eti.setBounds(x, y, eti.getText().length()*10, 20);
    }
}


public void setNumeroEtiquetas(int n){
    System.out.println(n);
    System.out.println(num_etiquetas);
    if(n < 5 && n > num_etiquetas){
        int num = num_etiquetas;
        for(int i=num; i<n; i++){
           Titulo eti=new Titulo();
           num_etiquetas++;
           mover(eti, eti.getPosicion());
           add(eti);
           etiquetas.add(eti);
        }
    }
        
    if(n > 4){
       JOptionPane.showMessageDialog(this,"Solo puede agregar 4 etiquetas");
    }
    
    if(n < num_etiquetas){
        for(int i=n; i<etiquetas.size(); i++){
           this.remove(etiquetas.get(n));
           etiquetas.remove(n);
           num_etiquetas--;
        }
     }
        
}

public int getNumeroEtiquetas(){
 return num_etiquetas;
}


public void setPosiciones(String posiciones[]){
    if(posiciones.length < etiquetas.size()){
          JOptionPane.showMessageDialog(this,"Debe ingresar un arreglo con igual numero de posiciones que etiquetas");
       }
    else{
        for(int i=0; i<etiquetas.size(); i++){
           etiquetas.get(i).setPosicion(posiciones[i]);
           mover(etiquetas.get(i),etiquetas.get(i).getPosicion());
        }
      }         
 }


public String[] getPosiciones(){
     String p[]=new String[etiquetas.size()];
      
     for(int i=0; i<etiquetas.size(); i++){
          p[i] = etiquetas.get(i).getPosicion();
     }
     
      return p;
 }




 public void setTitulos(String titulos[]){
    if(titulos.length < etiquetas.size()){
          JOptionPane.showMessageDialog(this,"Debe ingresar un arreglo con igual numero de titulos que etiquetas");
       }
    else{
        for(int i=0; i<etiquetas.size(); i++){
           etiquetas.get(i).setTitulo(titulos[i]);
        }
    }
          
 }
 
 public String[] getTitulos(){
     String tit[]=new String[etiquetas.size()];
      
     for(int i=0; i<etiquetas.size(); i++){
          tit[i] = etiquetas.get(i).getTitulo();
     }
     
      return tit;
 }
    
 public void setLongMin(int v){
        if(v < texto.getLongMAX()){
           texto.setLongMin(v);
        }
      
    }
    
    public void setLongMAX(int v){
        if(v > 0 && v > texto.getLongMin()){
           texto.setLongMAX(v);
           texto.setColumns(v);
        }
    }
    
     public int getLongMin(){
        return texto.getLongMin();
    }
    
    public int getLongMAX(){
        return texto.getLongMAX();
    }
    
    
  
   

}
