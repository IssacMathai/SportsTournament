public class Stats {
	private int[] stats;
	private String[] names = {"Accuracy", "Evasion", "Speed", "Strength", "Tough-skin"};
	private String[] cols = {"#a40", "#0a4", "#40a", "#a40", "#0a4", "#40a"};
	public Stats(int[] stats) {
		this.stats = stats;
	}
	public String toString() {
		String string = "";
		for (int i = 0; i < this.stats.length - 1; i++) {
			string += "<a style='color:" + this.cols[i] + ";'>" + this.names[i] + " " + this.stats[i] + ", </a>";
		}
		if (this.stats.length > 0) {
			string += "<a style='color:" + this.cols[this.stats.length - 1] + ";'>" + this.names[this.stats.length - 1] + " " + this.stats[this.stats.length - 1] + ", </a>";
		}
		return string;
	}
	public int[] get() {
		return this.stats;
	}
	public void apply(Stats effectsStats) {
		int[] effects = effectsStats.get();
		for (int i = 0; i < this.stats.length; i++) {
			this.stats[i] += effects[i];
		}
	}
}