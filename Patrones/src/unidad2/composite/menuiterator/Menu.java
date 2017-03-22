package unidad2.composite.menuiterator;

import java.util.Iterator;
import java.util.ArrayList;

public class Menu extends MenuComponent {
	Iterator<MenuComponent> iterator = null;
	ArrayList<MenuComponent> menuComponents = new ArrayList<MenuComponent>();
	String name;
	String description;
        int nMenuItems;
        double total = 0;
        
        
	public Menu(String name, String description) {
		this.name = name;
		this.description = description;
                this.nMenuItems = 0;
	}
 
	public void add(MenuComponent menuComponent) {
		menuComponents.add(menuComponent);
                if(menuComponent instanceof MenuItem){                    
                    nMenuItems += 1;
                    total += menuComponent.getPrice();
                }
	}
 
	public void remove(MenuComponent menuComponent) {
		menuComponents.remove(menuComponent);
	}
 
	public MenuComponent getChild(int i) {
		return menuComponents.get(i);
	}
 
	public String getName() {
		return name;
	}
 
	public String getDescription() {
		return description;
	}

        public int getnMenuItems() {
            return nMenuItems;
        }
        
        private double getTotal() {
            return total;
        }
         
	public Iterator<MenuComponent> createIterator() {
		if (iterator == null) {
			iterator = new CompositeIterator(menuComponents.iterator());
		}
		return iterator;
	}
 
	public void print() {
		System.out.print("\n" + getName());
		System.out.println(", " + getDescription());
		System.out.println("---------------------");  
		Iterator<MenuComponent> iterator = menuComponents.iterator();
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
                        menuComponent.printTotal();                             
			menuComponent.print();                              
		}                                 
	}             
    
            
    public void printTotal() {        
        System.out.println("---------------------");
        System.out.println(getName() + " total: $" + getTotal());
        System.out.println("---------------------");
    }                        
}
