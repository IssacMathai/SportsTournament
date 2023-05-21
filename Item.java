
/**
 * The Item class. Items can be bought, sold and used.
 */
public class Item implements Sellable {
	
	/** The name. */
	private String name;
	
	/** The description. */
	private String description;
	
	/** The effects. */
	private Stats effects;
	
	/** The price value. */
	private Money priceValue;
	
	/** The price retail. */
	private Money priceRetail;
	
	/**
	 * Gets the name of the item.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Marks the item as bought and sets the price to the retail price
	 */
	public void bought() {
		this.priceValue = this.priceRetail;
	}
	
	/**
	 * Gets description of tiem.
	 *
	 * @return the desc
	 */
	public String getDesc() {
		return this.description;
	}
	
	/**
	 * returns price of item
	 *
	 * @return the money
	 */
	public Money price() {
		return this.priceValue;
	}
	
	/**
	 * Instantiates a new item.
	 *
	 * @param name the name
	 * @param description the description
	 * @param effects the effects
	 * @param priceValue the price value
	 * @param priceRetail the price retail
	 */
	public Item(String name, String description, Stats effects, int priceValue, int priceRetail) {
		this.name = name;
		this.description = description;
		this.effects = effects;
		
		this.priceValue = new Money(priceValue);
		this.priceRetail = new Money(priceRetail);
	}
	
	/**
	 * Gets the effects of the item
	 *
	 * @return the effects
	 */
	public Stats getEffects() {
		return this.effects;
	}
	
	/**
	 * Returns the string for the stat
	 *
	 * @param stat the stat
	 * @return the formatted string for the string
	 */
	private String displayStat(int stat) {
		if (stat >= 0) {
			return "+" + stat;
		} else {
			return "" + stat;
		}
	}
	
	/**
	 * Returns a string representation of the item
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return this.getName() + " - " + this.getDesc()
		+ " " + this.getEffects();
	}
	
	/**
	 * Gets the option for the item which has its price and its string representation
	 *
	 * @return the option
	 */
	public String getOption() {
		return "$" + this.price() + " - " + this;
	}
}
