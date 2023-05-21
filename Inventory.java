import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Inventory.
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
	 * Gets the.
	 *
	 * @return the array list
	 */
	public ArrayList<Item> get() {
		return this.items;
	}
	
	/**
	 * Gets the sellables.
	 *
	 * @return the sellables
	 */
	public ArrayList<Sellable> getSellables() {
		ArrayList<Sellable> asdf = new ArrayList<Sellable>();
		for (Item item : this.items) {
			asdf.add( (Sellable) item );
		}
		return asdf;
	}
	
	/**
	 * Gets the.
	 *
	 * @param index the index
	 * @return the item
	 */
	public Item get(int index) {
		return this.items.get(index);
	}
	
	/**
	 * Adds the.
	 *
	 * @param item the item
	 */
	public void add(Item item) {
		this.items.add(item);
	}
	
	/**
	 * Exists.
	 *
	 * @param index the index
	 * @return true, if successful
	 */
	public boolean exists(int index) {
		return 0 <= index && index < this.items.size();
	}
	
	/**
	 * Removes the.
	 *
	 * @param index the index
	 */
	public void remove(int index) {
		this.items.remove(index);
	}
	
	/**
	 * Use.
	 *
	 * @param index the index
	 * @return the item
	 */
	public Item use(int index) {
		Item item = this.get(index);
		this.remove(index);
		return item;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String string = "Inventory\n";
		for (int i = 0; i < this.items.size(); i++) {
			string += this.items.get(i) + "\n";
		}
		if (this.items.size() == 0) {
			string += "<a style='color:#999;'>Inventory currenty has no items.</a>";
		}
		return string;
	}
}
