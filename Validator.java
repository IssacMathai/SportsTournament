/**
 * The validator validates a given string and determines if it is valid or not.
 */
public interface Validator {
	
	/**
	 * @param string The string to be validated.
	 * @return true If successful 
	 * @throws Exception If an error occurs during the validation process.
	 */
	public boolean validate(String string) throws Exception;
}
