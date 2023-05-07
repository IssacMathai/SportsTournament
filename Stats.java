public class Stats {
	private int[] stats;
	private String[] names = {"Accuracy", "Evasion", "Speed", "Strength", "Tough-skin"};
	public Stats(int[] stats) {
		this.stats = stats;
	}
	public String toString() {
		String string = "";
		for (int i = 0; i < this.stats.length - 1; i++) {
			string += this.names[i] + " " + this.stats[i] + ", ";
		}
		if (this.stats.length > 0) {
			string += this.names[this.stats.length - 1] + " " + this.stats[this.stats.length - 1];
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