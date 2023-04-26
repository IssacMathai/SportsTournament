public class WeeksValidator implements Validator {
	private int lowerBound;
	private int upperBound;
	public WeeksValidator(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
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
