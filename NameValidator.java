public class NameValidator implements Validator {
	private int lowerBound;
	private int upperBound;
	private static final String legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcedfghijklmnopqrstuvwxyz '";
	public NameValidator(int lowerBound, int upperBound) {
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
	}
	public boolean validate(String string) throws Exception {
		// .. write the team name validator here ...
		if (string.length() < this.lowerBound || string.length() > this.upperBound) { // Is name between 3 and 15 characters?
			throw new Exception("Please provide a team name between 3 and 15 characters");
			//return false;
		} else { // Loop through letters in name, and check if there is an invalid letter
			for (int i = 0; i < string.length(); i++) {
				if (this.legalChars.indexOf( string.charAt(i) ) == -1) {
					throw new Exception("Team names must consist of alphabetical letters only");
					//return false;
				}
			}
		}
		return true;
	}
}
