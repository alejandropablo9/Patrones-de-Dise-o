/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package patroniterador;

import java.util.ArrayList;
import java.util.Iterator;
/**
 *
 * @author Ericko
 */
public class PancakeHouseMenuIterator implements Iterator{
  int position = 0;
  ArrayList l;
  public PancakeHouseMenuIterator(ArrayList l){
    this.l = l;
  }
 @Override
    public boolean hasNext() {
        return position< l.size() ;
    }
   @Override
    public Object next() {
    return l.get(position++);
    }
  
  public void remove(){

  }
}
