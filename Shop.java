import java.util.ArrayList;

/**
 * The class for the Shop where you can purchase and sell items and athletes.
 */
public class Shop {
	
	/** The sellables. */
	private ArrayList<Sellable> sellables;
	
	/**
	 * Instantiates a new shop.
	 */
	public Shop() {
		this.sellables = new ArrayList<Sellable>();
	}
	
	/**
	 * Clears the shop.
	 */
	public void clear() {
		this.sellables = new ArrayList<Sellable>();
	}
	
	/**
	 * Amount of sellables.
	 *
	 * @return the int
	 */
	public int sellableCount() {
		return this.sellables.size();
	}
	
	/**
	 * Adds the sellable.
	 *
	 * @param sellable the sellable
	 * @return true, if successful
	 */
	// return true on success
	public boolean addSellable(Sellable sellable) {
		this.sellables.add(sellable);
		return true;
	}
    
    /**
     * Gets the sellables from the shop
     *
     * @return the sellables
     */
    public ArrayList<Sellable> getSellables() {
		return this.sellables;
	}
	
	/**
	 * Gets the sellable at the specified index
	 *
	 * @param index the index
	 * @return the sellable
	 */
	public Sellable getSellable(int index) {
		return this.sellables.get(index);
	}
	
	/**
	 * Removes the specified sellable from the shop
	 *
	 * @param sellable the sellable
	 */
	public void removeSellable(Sellable sellable) {
		this.sellables.remove(sellable);
	}
	
	/**
	 * Removes the sellable at the index from the shop
	 *
	 * @param index the index
	 */
	public void removeSellable(int index) {
		this.sellables.remove(index);
	}
	
	/**
	 * Checks if a player can buy the sellable item at the specified index
	 *
	 * @param index the index of the sellable item
	 * @param player the player
	 * @return true, if the player can buy the item
	 * @throws Exception if the player doesn't have enough money or the team is full
	 */
	public boolean canBuy(int index, Team player) throws Exception { // doesn't edit players money
		Sellable sellable = this.getSellable( index );
		if (player.getMoney().get() < sellable.price().get()) {
			throw new Exception("you need $" + this.price( index ) + " for " + sellable + ", you have $" + player.getMoney() + ".");
		}
		if (sellable instanceof Athlete && player.teamCount() >= player.getTeamSize()) {
			throw new Exception("your team has a maximum of " + player.getTeamSize() + " members!");
		}
		return true;
	}
	
	/**
	 * Purchases the sellable item at the specified index.
	 *
	 * @param index the index of the sellable item
	 * @param player the player
	 * @return the sellanle that has been bought
	 */
	public Sellable buy(int index, Team player) { // EDITS players money
		player.getMoney().change( -this.sellables.get(index).price().get());
		Sellable sell = this.sellables.remove(index);
		sell.bought();
		return sell;
	}
	
	/**
	 * Returns the price of the sellable item at the specified index
	 *
	 * @param index the index
	 * @return the money
	 */
	public Money price(int index) {
		return this.sellables.get(index).price();
	}
	
	/**
	 * Returns a string representation of the shop
	 *
	 * @return the string
	 */
	// Other Stuff
	@Override
	public String toString() {
		String string = "";
		string += "Shop\n";
		for (Sellable sellable : this.sellables) {
			string += sellable.getOption() + "\n";
		}
		if (this.sellableCount() == 0) {
			string += "The shop is empty.";
		}
		return string;
	}
}




















































