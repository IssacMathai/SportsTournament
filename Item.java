/**
 * class Item
 */
public class Item {
    /**
     * Name of the Item
     */
	private String name;
	
    /**
     * Description of the Item
     */
	private String description;
	
    /**
     * Offence Boost stat of the Item
     */
	private int offenceBoost;
	
    /**
     * Defence Boost stat of the Item
     */
    private int defenceBoost;
	
    /**
     * Stamina Boost stamina stat of the Item
     */
    private int staminaBoost;
	
    /**
     * Price of the item
     */
    private int price;
	
    /**
     * Retail price of the item
     */
    private int retailPrice;
	
	/**
     * Gets Item Description
	 * @returns name
     */
	public String getName() {
		return this.name;
	}
	
	/**
     * Gets Description
	 * @returns description
     */
	public String getDesc() {
		return this.description;
	}
	
	/**
     * Gets Offence Boost stat
	 * @returns offenceBoost
     */
	public int getOffence() {
		return this.offenceBoost;
	}
	
	/**
     * Gets Defence Boost stat
	 * @returns defenceBoost
     */
	public int getDefence() {
		return this.defenceBoost;
	}
	
	/**
     * Gets Stamina Boost stamina stat
	 * @returns staminaBoost
     */
	public int getStamina() {
		return this.staminaBoost;
	}
	
	/**
     * Gets Defence Boost stat
	 * @returns defenceBoost
     */
	public int getPrice() {
		return this.price;
	}
	
	/**
     * Gets Stamina Boost stamina stat
	 * @returns staminaBoost
     */
	public int getRetailPrice() {
		return this.retailPrice;
	}
	
	/**
     * Displays the sign of the stat
     */
	public String displayStat(int stat) {
		if (stat >= 0) {
			return "+" + stat;
		} else {
			return "" + stat;
		}
	}
	
	/**
     * toString() method
     */
	@Override
	public String toString() {
		return this.getName() + " - " + this.getDesc()
		+ " (stats: Defence " + this.displayStat(this.getOffence())
		+ ", Offence " + this.displayStat(this.getDefence())
		+ ", Stamina " + this.displayStat(this.getStamina())
		+ ") - Cost new: $" + this.price + ", retail $" + this.retailPrice;
	}
	
	/**
     * Constructor
     */
	public Item(String name, String description, int offence, int defence, int stamina, int price, int retailPrice) {
		this.name = name;
		this.description = description;
		this.offenceBoost = offence;
		this.defenceBoost = defence;
		this.staminaBoost = stamina;
		
		this.price = price;
		this.retailPrice = retailPrice;
	}
	
}



























