// TODO: Auto-generated Javadoc
/**
 * The Class Stats.
 */
public class Stats {
	
	/** The stats. */
	private int[] stats;
	
	/** The names. */
	private String[] names = {"Accuracy", "Evasion", "Speed", "Strength", "Tough-skin"};
	
	/** The cols. */
	private String[] cols = {"#a40", "#0a4", "#40a", "#a40", "#0a4", "#40a"};
	
	/**
	 * Instantiates a new stats.
	 *
	 * @param stats the stats
	 */
	public Stats(int[] stats) {
		this.stats = stats;
	}
	
	/**
	 * To string.
	 *
	 * @return the string
	 */
	public String toString() {
		String string = "";
		for (int i = 0; i < this.stats.length - 1; i++) {
			string += "<a style='color:" + this.cols[i] + ";'>" + this.names[i] + " " + this.stats[i] + "</a>, ";
		}
		if (this.stats.length > 0) {
			string += "<a style='color:" + this.cols[this.stats.length - 1] + ";'>" + this.names[this.stats.length - 1] + " " + this.stats[this.stats.length - 1] + "</a>";
		}
		return string;
	}
	
	/**
	 * Gets the.
	 *
	 * @return the int[]
	 */
	public int[] get() {
		return this.stats;
	}
	
	/**
	 * Apply.
	 *
	 * @param effectsStats the effects stats
	 */
	public void apply(Stats effectsStats) {
		int[] effects = effectsStats.get();
		for (int i = 0; i < this.stats.length; i++) {
			this.stats[i] += effects[i];
		}
	}
}
