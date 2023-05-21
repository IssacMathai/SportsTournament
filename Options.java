import java.util.Arrays;
import java.util.ArrayList;

/**
 * Represents a list of options.
 */
public class Options {
	
	/** The options. */
	private String[] options;
	
	/** The better indexing. */
	private int betterIndexing = 0; // does it start at 0 or 1?
	
	/** The type. */
	private int type = 0; // for button display
	
	/** The text. */
	private String text; // for button display
	
	/** The high. */
	private int high = -1; // for button display
	
	/**
	 * Sets the text
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
		this.type = 1;
	}
	
	/**
	 * Gets the text for display
	 *
	 * @return the text
	 */
	public String getText() {
		return this.text;
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public int getType() {
		return this.type;
	}
	
	/**
	 * Sets the high value.
	 *
	 * @param high the new high
	 */
	public void setHigh(int high) {
		this.high = high;
	}
	
	/**
	 * Gets the high value.
	 *
	 * @return the high
	 */
	public int getHigh() {
		return this.high;
	}
	
	/**
	 * Sets the better indexing.
	 *
	 * @param betterIndexing the new better indexing
	 */
	public void setBetterIndexing(int betterIndexing) {
		this.betterIndexing = betterIndexing;
	}
	
	/**
	 * Instantiates a new options.
	 */
	public Options() {
		
	}
	
	/**
	 * Instantiates a new options.
	 *
	 * @param options the options
	 */
	public Options(String[] options) {
		this.options = options;
	}
	
	/**
	 * Instantiates a new options.
	 *
	 * @param options the options
	 */
	public Options(ArrayList<Sellable> options) {
		this.options = new String[options.size()];
		for (int i = 0; i < options.size(); i++) {
			this.options[i] = options.get(i).getOption();
		}
	}
	
	/**
	 * Returns the index of the first option
	 *
	 * @return the int
	 */
	public int first() {
		return this.betterIndexing;
	}
	
	/**
	 * Last.
	 *
	 * @return the int
	 */
	public int last() {
		return this.options.length - 1 + this.betterIndexing;
	}
	
	/**
	 * Returns the index of the last option
	 *
	 * @return the string[]
	 */
	public String[] options() {
		return this.options;
	}
	
	/**
	 * Returns the option at the specified index
	 *
	 * @param index the index
	 * @return the string
	 */
	public String option(int index) {
		// user shouldn't have direct access to this! (User-input should be run through a validator first)
		return options[index - this.betterIndexing];
	}
	
	/**
	 * Creates a new Options object by joining the specified option
	 *
	 * @param option the option
	 * @return the options
	 */
	public Options join(String option) {
		String[] newOptions = Arrays.copyOf(this.options, this.options.length + 1);
		newOptions[newOptions.length - 1] = option;
		return new Options(newOptions);
	}
	
	/**
	 * Adds the specified option to the existing options
	 *
	 * @param option the option
	 */
	public void add(String option) {
		this.options = Arrays.copyOf(this.options, this.options.length + 1);
		this.options[this.last()] = option;
	}
	
	/**
	 * Returns a string representation of the Options object
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		String string = "";
		for (int i = 0; i < this.options.length; i++) {
			string += (this.first() + i) + " " + this.options[i];
			if (i < this.options.length - 1) {
				string +=  "\n";
			}
		}
		return string;
	}
}
