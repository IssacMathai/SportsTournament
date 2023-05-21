
/**
 * The Sellable interface represents the items and athletes as they can be sold
 */
public interface Sellable {
	
	/**
	 * returns the price of the sellable.
	 *
	 * @return the money
	 */
	public Money price();
	
	/**
	 * Gets the option of the sellable.
	 *
	 * @return the option
	 */
	public String getOption();
	
	/**
	 * Indicates that the sellable has been bought
	 */
	public void bought();
}
