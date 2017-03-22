package unidad2.iterator;

import java.util.ArrayList;
/**
 *
 * @author alejandro
 */
public class PancakeHouseMenuIterator implements Iterador{
    
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

    /*
    public void remove(){

    }*/

    @Override
    public void iterador(int vi, int vf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void rango(int vi, int vf) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
