/**
 * 
 */
package algorithms.mishra.dev.rahul.quora.designpattern;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Rahul Dev Mishra
 * @assignment  
 * @date 12-Jul-2017 11:59:24 AM
 *
 */
public class IteratorPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Item item1 = new Item("Rice");
		Item item2 = new Item("Dal");
		Item item3 = new Item("Curd");
		Item item4 = new Item("Beans");
		
		Menu menu = new Menu();
		menu.add(item1);
		menu.add(item2);
		menu.add(item3);
		menu.add(item4);
		
		Iterator<Item> menuItr = menu.getIterator();
		while(menuItr.hasNext()) {
			System.out.print(menuItr.next().getName() + " ");
		}
		
		Iterator<Item> menuItr1 = menu.getIterator();
		while(menuItr1.hasNext()) {
			if("Curd".equals(menuItr1.next().getName())) {
				menuItr1.remove();
			}
		}
		System.out.println();
		Iterator<Item> menuItr2 = menu.getIterator();
		while(menuItr2.hasNext()) {
			System.out.print(menuItr2.next().getName() + " ");
		}
	}

}

class Item {
	private String name;
	public Item(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return name;
	}
}

class Menu {
	private List<Item> list;
	public Menu() {
		list = new ArrayList<>();
	}
	
	public void add(Item item) {
		list.add(item);
	}
	
	public MenuIterator getIterator() {
		return new MenuIterator();
	}
	
	private class MenuIterator implements Iterator<Item> {
		private int size = 0;
		
		@Override
		public boolean hasNext() {
			return size < list.size();
		}

		@Override
		public Item next() {
			return list.get(size++);
		}
		
		public void remove() {
			list.remove(--size);
		}
	}
}
