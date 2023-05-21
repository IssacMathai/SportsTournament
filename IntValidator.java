// TODO: Auto-generated Javadoc
/**
 * The Class IntValidator.
 */
public class IntValidator implements Validator {
	
	/** The lower bound. */
	private int lowerBound;
	
	/** The upper bound. */
	private int upperBound;
	
	/**
	 * Instantiates a new int validator.
	 *
	 * @param lowerBound the lower bound
	 * @param upperBound the upper bound
	 */
	public IntValidator(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Validate.
	 *
	 * @param string the string
	 * @return true, if successful
	 * @throws Exception the exception
	 */
	public boolean validate(String string) throws Exception {
		try {
			int number = Integer.parseInt(string);
			if (number < this.lowerBound || number > this.upperBound) {
				// Weeks is out of bounds
				throw new Exception("Number must be between " + this.lowerBound + " and " + this.upperBound);
			} else {
				// Valid Answer
				return true;
			}
		} catch (NumberFormatException e) {
			// User did not enter a valid number
			throw new Exception("That is not an acceptable number");
		}
		// return false;
	}
}
