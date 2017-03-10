/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patroniterador;
import java.util.Iterator;


/**
 *
 * @author VickaRamirez
 */
public class DinerMenuIterator implements Iterator {
  MenuItem[] items;
  int position = 0;

  public DinerMenuIterator(MenuItem[] items){
    this.items = items;
  }

  @Override
  public Object next(){
    MenuItem menuItem = items[position];
    position = position + 1;
    return menuItem;
  }
  @Override
  public boolean hasNext(){
    if(position >= items.length || items[position] == null){
      return false;
    }else{
      return true;
    }
  }
  
  //@Override
  public void remove(){

  }
}

    
    
    
    
    /*
    public Object next(){
        MenuItem menuItem=items[position];
        position= position + 1;
        return menuItem;
    }
    
    public boolean hasNext(){
        return position < items.length && items[position]!=null;
       /* if(position >= items.length || items[position]== null){
            return false;
        }else{
            return true;
        }*/
    
    
   /* public void remove(){
        if(position <=0){
            throw new IllegalStateException("you cant'n remove an item");
        }
        if(item)
    }*/

    



//HACER UNA INTERFACE ITERADOR Y METODS NETX HASNEXT Y FIJAR POSICION O PRIMERO