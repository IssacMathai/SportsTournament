
/**
 * This class stores and can change athlete stats.
 */
public class Stats {
	
	/** The stats array. */
	private int[] stats;
	
	/** The names of stats. */
	private String[] names = {"Accuracy", "Evasion", "Speed", "Strength", "Tough-skin"};
	
	/** The colors of each stat. */
	private String[] cols = {"#a40", "#0a4", "#40a", "#a40", "#0a4", "#40a"};
	
	/**
	 * Instantiates a new stats object with the given stats
	 *
	 * @param stats the stats
	 */
	public Stats(int[] stats) {
		this.stats = stats;
	}
	
	/**
	 * Returns a string representation of the stats
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
	 * Gets the array of stats
	 *
	 * @return int[] array of stats
	 */
	public int[] get() {
		return this.stats;
	}
	
	/**
	 * Applies the effects of another Stats object to the current stats object
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
