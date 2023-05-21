import java.util.Arrays;
import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Options.
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
	 * Sets the text.
	 *
	 * @param text the new text
	 */
	public void setText(String text) {
		this.text = text;
		this.type = 1;
	}
	
	/**
	 * Gets the text.
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
	 * Sets the high.
	 *
	 * @param high the new high
	 */
	public void setHigh(int high) {
		this.high = high;
	}
	
	/**
	 * Gets the high.
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
	 * First.
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
	 * Options.
	 *
	 * @return the string[]
	 */
	public String[] options() {
		return this.options;
	}
	
	/**
	 * Option.
	 *
	 * @param index the index
	 * @return the string
	 */
	public String option(int index) {
		// user shouldn't have direct access to this! (User-input should be run through a validator first)
		return options[index - this.betterIndexing];
	}
	
	/**
	 * Join.
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
	 * Adds the.
	 *
	 * @param option the option
	 */
	public void add(String option) {
		this.options = Arrays.copyOf(this.options, this.options.length + 1);
		this.options[this.last()] = option;
	}
	
	/**
	 * To string.
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
