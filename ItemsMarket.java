import java.util.ArrayList;
/**
 * This class implements a Market.
 */
public class ItemsMarket extends Market {
	/**
	 * Takes a parameter of type Inventory of items and converts to an ArrayList of objects then
	 * Call the parent constructor
	 */
	public ItemsMarket(Inventory items) {
		super(new ArrayList<Object>(items.getItems()));
	}
	
	/**
	 * Return an array of all the items in the market
	 */
	public ArrayList<Item> getItems() {
		ArrayList<Object> objects = this.getObjects();
		ArrayList<Item> items = new ArrayList<Item>();
		// Cast list to type Item
		for (Object object : objects) {
			items.add( (Item) object );
		}		
		return items;
	}
	
	/**
	 * Gets an item price from an index
	 */
	public int getItemPrice(int index) {
		ArrayList<Item> items = this.getItems();
		return items.get(index).getPrice();
	}
	
	/**
	 * Take an item out of the Market and put it in the inventory
	 * return true if purcahse was successful,
	 * false if else
	 */
	public boolean buyItem(int index, Inventory inv) {
		ArrayList<Item> items = this.getItems();
		// check if item exists
		if (this.objectExists(index)) {
			inv.addItem(items.get(index));
			this.removeObject(index);
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		Inventory shop = new Inventory();
		
		shop.addItem( new Item("Water", "good for denfece", 0, 0, 5, 100, 90) );
		shop.addItem( new Item("Shoes", "good for offence", 5, 0, 0, 100, 90) );
		shop.addItem( new Item("Gun", "shoot opponent", 10, 0, 0, 110, 90) );
		shop.addItem( new Item("Heavy Shield", "block opponent", 1, 8, -6, 100, 90) );
		shop.addItem( new Item("Coke", "tasty", 99, 99, 99, 100, 50) );
		shop.addItem( new Item("Inifite Money", "buy then sell", 0, 0, 0, 0, 1000) );
		
		
		ItemsMarket market = new ItemsMarket( shop );
		
		System.out.println(market);
		
		System.out.println(market.getItemPrice(2));
	}
}














