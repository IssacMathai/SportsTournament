import java.util.Arrays;
import java.util.ArrayList;

public class Options {
	private String[] options;
	private int betterIndexing = 0; // does it start at 0 or 1?
	private int type = 0; // for button display
	private String text; // for button display
	private int high = -1; // for button display
	public void setText(String text) {
		this.text = text;
		this.type = 1;
	}
	public String getText() {
		return this.text;
	}
	public int getType() {
		return this.type;
	}
	public void setHigh(int high) {
		this.high = high;
	}
	public int getHigh() {
		return this.high;
	}
	public void setBetterIndexing(int betterIndexing) {
		this.betterIndexing = betterIndexing;
	}
	public Options() {
		
	}
	public Options(String[] options) {
		this.options = options;
	}
	public Options(ArrayList<Sellable> options) {
		this.options = new String[options.size()];
		for (int i = 0; i < options.size(); i++) {
			this.options[i] = options.get(i).getOption();
		}
	}
	public int first() {
		return this.betterIndexing;
	}
	public int last() {
		return this.options.length - 1 + this.betterIndexing;
	}
	public String[] options() {
		return this.options;
	}
	public String option(int index) {
		// user shouldn't have direct access to this! (User-input should be run through a validator first)
		return options[index - this.betterIndexing];
	}
	public Options join(String option) {
		String[] newOptions = Arrays.copyOf(this.options, this.options.length + 1);
		newOptions[newOptions.length - 1] = option;
		return new Options(newOptions);
	}
	public void add(String option) {
		this.options = Arrays.copyOf(this.options, this.options.length + 1);
		this.options[this.last()] = option;
	}
	
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