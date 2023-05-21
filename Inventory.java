import java.util.ArrayList;

/**
 * The inventory of the team that may contain items.
 */
public class Inventory {
	
	/** The items. */
	private ArrayList<Item> items;
	
	/**
	 * Instantiates a new inventory.
	 */
	public Inventory() {
		this.items = new ArrayList<Item>();
	}
	
	/**
	 * Returns the list of items in the inventory
	 *
	 * @return list of items
	 */
	public ArrayList<Item> get() {
		return this.items;
	}
	
	/**
	 * Returns the list of sellable items in the inventory
	 *
	 * @return list of sellable items
	 */
	public ArrayList<Sellable> getSellables() {
		ArrayList<Sellable> asdf = new ArrayList<Sellable>();
		for (Item item : this.items) {
			asdf.add( (Sellable) item );
		}
		return asdf;
	}
	
	/**
	 * Returns the item at the specified index in the inventory
	 *
	 * @param index the index of the item
	 * @return the item at the index
	 */
	public Item get(int index) {
		return this.items.get(index);
	}
	
	/**
	 * Adds item to inventory
	 *
	 * @param item the item
	 */
	public void add(Item item) {
		this.items.add(item);
	}
	
	/**
	 * Check if index exists
	 *
	 * @param index the index
	 * @return true, if successful
	 */
	public boolean exists(int index) {
		return 0 <= index && index < this.items.size();
	}
	
	/**
	 * Removes the item at the specified index from the inventory
	 *
	 * @param index the index of item to remove
	 */
	public void remove(int index) {
		this.items.remove(index);
	}
	
	/**
	 * Uses item at index and removes it from inventory
	 *
	 * @param index the index
	 * @return the item used
	 */
	public Item use(int index) {
		Item item = this.get(index);
		this.remove(index);
		return item;
	}
	
	/**
	 * Returns a string representation of the inventory.
	 *
	 * @return the string
	 */
	public String toString() {
		String string = "Inventory\n";
		for (int i = 0; i < this.items.size(); i++) {
			string += this.items.get(i) + "\n";
		}
		if (this.items.size() == 0) {
			string += "<a style='color:#999;'>Inventory currently has no items.</a>";
		}
		return string;
	}
}
