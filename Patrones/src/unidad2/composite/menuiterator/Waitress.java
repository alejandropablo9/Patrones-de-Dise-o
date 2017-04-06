package unidad2.composite.menuiterator;

import java.util.Iterator;
  
public class Waitress {
	private MenuComponent allMenus;
        private double total;
        
	public Waitress(MenuComponent allMenus) {
		this.allMenus = allMenus;
                total = 0;
	}
 
	public void printMenu() {
		allMenus.print();
	}
  
	public void printVegetarianMenu() {
		Iterator<MenuComponent> iterator = allMenus.createIterator();

		System.out.println("\nVEGETARIAN MENU\n----");
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			try {
				if (menuComponent.isVegetarian()) {
					menuComponent.print();                                            
				}
			} catch (UnsupportedOperationException e) {}
		}
	}   
        
        public void printTotal(){
            Iterator<MenuComponent> iterator = allMenus.createIterator();
                double total = 0.0;		
		while (iterator.hasNext()) {
			MenuComponent menuComponent = iterator.next();
			try {
				total += menuComponent.getPrice();
			} catch (UnsupportedOperationException e) {}                        
		}
                System.out.println("Total: " + total);
        }
}
