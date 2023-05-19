public class Match {
	private Team a;
	private Team b;
	private int size;
	private int[] results;
	private int result;
	public Match() {
	
	}
	public Match(Team a, Team b, int size) {
		this.a = a;
		this.b = b;
		this.size = size;
		this.results = new int[size];
	}
	public void play() {
		// loop through all athletes
		int totalWins1 = 0;
		int totalWins2 = 0;
		for (int i = 0; i < this.size; i++) {
			Athlete athlete1 = this.a.getAthlete(i);
			Athlete athlete2 = this.b.getAthlete(i);
			
			int[] stats1 = athlete1.getStats().get();			
			int[] stats2 = athlete2.getStats().get();
			
			int points1 = 0;
			int points2 = 0;
			
			// compare each athlete's stats
			for (int j = 0; j < stats1.length; j++) {
				if (stats1[j] == stats2[j]) {
					// Draws
					continue;
				} else if (stats1[j] > stats2[j]) {
					// Athlete1 get a point
					points1++;
					continue;
				} else if (stats1[j] < stats2[j]) {
					// Athlete2 gets a point
					points2++;
					continue;
				}
			}
			
			// which athlete won? 0 for draw
			if (points1 == points2) {
				this.results[i] = 0; // its a draw!
			} else if (points1 > points2) {
				this.results[i] = 1; // athlete 1 wins
				totalWins1++;
			} else if (points1 < points2) {
				this.results[i] = 2; // athlete 2 wins
				totalWins2++;
			}
			
			// CHANGE ATHLETE STAMINA HERE AS WELL!
		}
		
		// Which Team won the match?
		if (totalWins1 == totalWins2) {
			this.result = 0;
		} else if (totalWins1 > totalWins2) {
			this.result = 1;
		} else if (totalWins1 < totalWins2) {
			this.result = 2;
		}
	}
	public String getResults() {
		String string = "RESULTS\n";
		String p1 = "";
		String p2 = "";
		if (this.result == 1) {
			p1 = "[WINNER] ";
			p2 = " [LOSER]";
		} else if (this.result == 2) {
			p1 = "[LOSER] ";
			p2 = " [WINNER]";
		} else {
			p1 = "[DRAW] ";
			p2 = " [DRAW]";
		}
		string += p1 + this.a.getName() + " (vs) " + this.b.getName() + p2 + "\n";
		for (int i = 0; i < this.size; i++) {
			if (this.results[i] == 1) {
				p1 = "[W] ";
				p2 = "    ";
			} else if (this.results[i] == 2) {
				p1 = "    ";
				p2 = " [W]";
			} else {
				p1 = "[D] ";
				p2 = " [D]";
			}
			string += " * " + p1 + this.a.matchString(i) + " (vs) " + this.b.matchString(i) + p2 + "\n";
		}
		return string;
	}
	public String getResult() {
		String string = "";
		String p1 = "";
		String p2 = "";
		if (this.result == 1) {
			p1 = "<a style='color:#02a;'>[WINNER]</a> ";
			p2 = "";
		} else if (this.result == 2) {
			p1 = "";
			p2 = " <a style='color:#02a;'>[WINNER]</a>";
		} else {
			p1 = "<a style='color:#888;'>[DRAW]</a> ";
			p2 = "";
		}
		string += p1 + this.a.getName() + " (vs) " + this.b.getName() + p2;
		return string;
	}
	public String header() {
		String string = "Match " + this.a.getName() + " (vs) " + this.b.getName();
		return string;
	}
	public String toString() {
		String string = this.header() + "\n";
		for (int i = 0; i < this.size; i++) {
			string += " * " + this.a.matchString(i) + " (vs) " + this.b.matchString(i) + "\n";
		}
		return string;
	}
}