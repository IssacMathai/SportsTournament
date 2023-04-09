import java.util.ArrayList;

/**
 * Inventory class, stores a bunch of Items
 * Starting at Index 1
 */
public class Inventory {
	
	/**
	 * An ArrayList containging all the items in the inventory
	 */
	private ArrayList<Item> items = new ArrayList<Item>();
	
	/**
	 * Inventory Constructor
	 */
	public Inventory() {
		
	}
	
	/**
	 * Returns a list of the items in the inventory
	 */
	public ArrayList<Item> getItems() {
		return this.items;
	}
	
	/**
	 * Returns a specific Item in the inventory
	 */
	public Item getItem(int index) throws IndexOutOfBoundsException {
		return this.items.get(index - 1);
	}
	
	/**
	 * Returns whether a specific Item is in the inventory
	 */
	public boolean itemExists(int index) {
		return 1 <= index && index <= this.items.size();
	}
	
	/**
	 * Removes a specific Item in the inventory
	 * returns true is successful
	 */
	public boolean removeItem(int index) {
		if (this.itemExists(index)) {
			this.items.remove(index - 1);
			return true;
		}
		return false;
	}
	
	/**
	 * Removes a specific Item in the inventory
	 * returns the item
	 */
	public Item useItem(int index) throws IndexOutOfBoundsException {
		Item item = this.getItem(index);
		this.removeItem(index);
		return item;
	}
	
	/**
	 * View Items in the inventory
	 */
	@Override
	public String toString() {
		String string = "";
		ArrayList<Item> items = this.getItems();
		for (Item item : items) {
			string += " > " + item + "\n";
		}
		return string;
	}
	
	/**
	 * Returns true if no issues occured
	 */
	public boolean addItem(Item item) {
		this.items.add(item);
		return true;
	}
	
	/**
	 * main method
	 */
	public static void main(String[] args) {
		Inventory inv = new Inventory();
		
		inv.addItem(new Item("Water", "good for denfece", 0, 0, 5, 100, 90));
		inv.addItem(new Item("Shoes", "good for offence", 5, 0, 0, 100, 90));
		inv.addItem(new Item("Gun", "shoot opponent", 10, 0, 0, 100, 90));
		inv.addItem(new Item("Heavy Shield", "block opponent", 1, 8, -6, 100, 90));
		inv.addItem(new Item("Coke", "tasty", 99, 99, 99, 100, 90));
		
		System.out.println(inv);
		
		System.out.println(inv.itemExists(-1));
		System.out.println(inv.itemExists(0));
		System.out.println(inv.itemExists(1));
		System.out.println(inv.itemExists(2));
		System.out.println(inv.itemExists(3));
		System.out.println(inv.itemExists(4));
		System.out.println(inv.itemExists(5));
		System.out.println(inv.itemExists(6));
		
		System.out.println(inv.getItem(3).getDefence());
	}
}



























