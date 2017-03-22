package unidad2.iterator;

import java.util.Iterator;


/**
 *
 * @author alejandro
 */
public class DinerMenuIterator implements Iterador {
  
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
        return !(position >= items.length || items[position] == null);    
    }

    /*
    @Override
    public void remove(){

    }*/

    @Override
    public void iterador(int vi, int vf) {
        
    }

    @Override
    public void rango(int vi, int vf) {
        
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