// TODO: Auto-generated Javadoc
/**
 * The Class Money.
 */
public class Money {
	
	/** The money. */
	private int money;
	
	/**
	 * Instantiates a new money.
	 *
	 * @param money the money
	 */
	public Money(int money) {
		this.money = money;
	}
	
	/**
	 * Instantiates a new money.
	 */
	public Money() {
		this.money = 0;
	}
	
	/**
	 * Sets the.
	 *
	 * @param money the money
	 */
	public void set(int money) {
		this.money = money;
	}
	
	/**
	 * Gets the.
	 *
	 * @return the int
	 */
	public int get() {
		return this.money;
	}
	
	/**
	 * Change.
	 *
	 * @param money the money
	 */
	public void change(int money) {
		 this.money += money;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		return "" + this.money;
	}
}
