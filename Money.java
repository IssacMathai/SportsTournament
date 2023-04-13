/**
 * Cool Money Class
 */
public class Money {
	/**
	 * The money number
	 */
	private int money;
	
	/**
	 * The money constructor
	 */
	public Money() {
		this.money = 0;
	}
	
	/**
	 * Another money constructor
	 */
	public Money(int amount) {
		this.money = amount;
	}
	
	/**
	 * Set the money number
	 */
	public void set(int amount) {
		this.money = amount;
	}
	
	/**
	 * add some money
	 */
	public void add(int amount) {
		this.money += amount;
	}
	
	/**
	 * Get the money number
	 */
	public int get() {
		return this.money;
	}
}