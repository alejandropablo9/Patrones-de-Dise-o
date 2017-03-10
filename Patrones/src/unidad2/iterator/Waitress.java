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
public class Waitress {
    PancakeHouseMenu pancakeHouseMenu;
    DinerMenu dinerMenu;
    
    public Waitress(PancakeHouseMenu pancakeHouseMenu, DinerMenu dinerMenu){
        this.pancakeHouseMenu = pancakeHouseMenu;
        this.dinerMenu= dinerMenu;
    }
    
    public void printMenu(){
        Iterator pancakeIterator = pancakeHouseMenu.createIterator();
        Iterator dinerIterator= dinerMenu.createIterator();
        System.out.println("Menu\n-------\nBREAKFAST");
        printMenu(pancakeIterator);
        System.out.println("\nLUNCH");
        printMenu(dinerIterator);
    }
    
    private void printMenu(Iterator iterator){
        while (iterator.hasNext()){
        MenuItem menuItem= (MenuItem)iterator.next();
        System.out.println(menuItem.getName() + ", ");
        System.out.println(menuItem.getPrice() + "-- ");
        System.out.println(menuItem.getDescription());
        }
    }
    
    //other methods here   
}
