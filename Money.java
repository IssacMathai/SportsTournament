/**
 * The Class Money, handles the money of the player
 */
public class Money {
	
	/** The amount of money. */
	private int money;
	
	/**
	 * Instantiates a new money object with the specified amount
	 *
	 * @param money the money
	 */
	public Money(int money) {
		this.money = money;
	}
	
	/**
	 * Instantiates a new money object with no money
	 */
	public Money() {
		this.money = 0;
	}
	
	/**
	 * Sets the amount of money the player has
	 *
	 * @param money the money
	 */
	public void set(int money) {
		this.money = money;
	}
	
	/**
	 * Gets the amount of money the player has
	 *
	 * @return the int
	 */
	public int get() {
		return this.money;
	}
	
	/**
	 * Changes the amount of money the player has
	 *
	 * @param money the money
	 */
	public void change(int money) {
		 this.money += money;
	}
	
	/**
	 * A string representation of the amount of money
	 *
	 * @return the string
	 */
	public String toString() {
		return "" + this.money;
	}
}
