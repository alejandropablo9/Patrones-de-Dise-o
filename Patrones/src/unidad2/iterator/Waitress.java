
package unidad2.iterator;

import java.util.Iterator;

/**
 *
 * @author VickaRamirez
 */
public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;
    
    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu= dinerMenu;
    }
    
    public void printMenu(){
        Iterador pancakeIterator = pancakeHouseMenu.createIterator();
        Iterador dinerIterator= dinerMenu.createIterator();
        System.out.println("Menu\n-------\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }
    
    private void printMenu(Iterador iterator){
        while (iterator.hasNext()){
        MenuItem menuItem= (MenuItem)iterator.next();
        System.out.println(menuItem.getName() + ", ");
        System.out.println(menuItem.getPrice() + "-- ");
        System.out.println(menuItem.getDescription());
        }
    }
    
    //other methods here   
}
