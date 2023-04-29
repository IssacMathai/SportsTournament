public class Options {
	private String[] options;
	private int betterIndexing = 1; // does it start at 0 or 1?
	public void setBetterIndexing(int betterIndexing) {
		this.betterIndexing = betterIndexing;
	}
	public Options() {
		
	}
	public Options(String[] options) {
		this.options = options;
	}
	public int first() {
		return this.betterIndexing;
	}
	public int last() {
		return options.length - 1 + this.betterIndexing;
	}
	public String[] options() {
		return options;
	}
	public String option(int index) {
		// user shouldn't have direct access to this! (User-input should be run through a validator first)
		return options[index - this.betterIndexing];
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