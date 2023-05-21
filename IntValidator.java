/**
 * An implementation of the Validator interface that validates integer input
 */
public class IntValidator implements Validator {
	
	/** The lower bound. */
	private int lowerBound;
	
	/** The upper bound. */
	private int upperBound;
	
	/**
	 * Instantiates a new int validator within the bounds
	 *
	 * @param lowerBound the lower bound
	 * @param upperBound the upper bound
	 */
	public IntValidator(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	
	/**
	 * Validates the input string by parsing it as an integer and checking if it falls within the specified bounds
	 *
	 * @param string the input string to validate
	 * @return true, if valid
	 * @throws Exception if the input is not a valid integer or if it is outside the specified bounds
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
