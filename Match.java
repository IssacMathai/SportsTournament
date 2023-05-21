
/**
 * The Match class runs a match between two teams.
 */
public class Match {
	
	/** The first team */
	private Team a;
	
	/** The second team. */
	private Team b;
	
	/** The number of athletes per team in the match */
	private int size;
	
	/** The results. */
	private int[] results;
	
	/** The result. */
	private int result;
	
	/**
	 * Returns integer result.
	 *
	 * @return the int
	 */
	public int result() {
		return this.result;
	}
	
	/**
	 * Instantiates a new match.
	 */
	public Match() {
	
	}
	
	/**
	 * Instantiates a new match.
	 *
	 * @param a the a
	 * @param b the b
	 * @param size the size
	 */
	public Match(Team a, Team b, int size) {
		this.a = a;
		this.b = b;
		this.size = size;
		this.results = new int[size];
	}
	
	/**
	 * Checks if the match can be played by both teams.
	 *
	 * @return true, if successful
	 */
	public boolean canPlay() {
		if (this.a.teamCount() >= this.size) {
			if (this.b.teamCount() >= this.size) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Plays the match by comparing athletes' stats and determining the winner
	 * Updates the match results and overall result.
	 */
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
			// CHANGE ATHLETE STAMINA HERE AS WELL!
			if (points1 == points2) {
				this.results[i] = 0; // its a draw!
				athlete1.setStamina(athlete1.getStamina() - 20);
				athlete2.setStamina(athlete1.getStamina() - 20);
			} else if (points1 > points2) {
				this.results[i] = 1; // athlete 1 wins
				totalWins1++;
				athlete1.setStamina(athlete1.getStamina() - 10);
				athlete2.setStamina(athlete1.getStamina() - 50);
			} else if (points1 < points2) {
				this.results[i] = 2; // athlete 2 wins
				totalWins2++;
				athlete1.setStamina(athlete1.getStamina() - 50);
				athlete2.setStamina(athlete1.getStamina() - 10);
			}
			
			// check if athlete is injured, if so then lose
			if (athlete1.isInjured() && athlete2.isInjured()) {
				this.results[i] = 0; // its a draw!
			} else if (athlete1.isInjured()) {
				this.results[i] = 2; // athlete 2 wins
			} else if (athlete2.isInjured()) {
				this.results[i] = 1; // athlete 1 wins
			}
		}
		
		// Which Team won the match?
		if (totalWins1 == totalWins2) { // DRAW
			this.result = 0;
		} else if (totalWins1 > totalWins2) { // P1 WINS
			this.result = 1;
		} else if (totalWins1 < totalWins2) { // P2 WINS
			this.result = 2;
		}
		
		// check if all athletes have lost their stamina and override result
		boolean aLost = this.a.allInjured();
		boolean bLost = this.b.allInjured();
		if (aLost && bLost) {
			this.result = 0;
		} else if (aLost) {
			this.result = 2;
		} else if (bLost) {
			this.result = 1;
		}
	}
	
	/**
	 * Gets a string representation of the match results
	 *
	 * @return the results
	 */
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
	
	/**
	 * Gets the string representation of the match result
	 *
	 * @return the result
	 */
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
	
	/**
	 * Creates a string representation of the match header
	 *
	 * @return the string
	 */
	public String header() {
		String string = "Match " + this.a.getName() + " (vs) " + this.b.getName();
		return string;
	}
	
	/**
	 * Generates a string representation of the match details
	 *
	 * @return the string
	 */
	public String toString() {
		String string = this.header() + "\n";
		for (int i = 0; i < this.size; i++) {
			string += " * " + this.a.matchString(i) + " (vs) " + this.b.matchString(i) + "\n";
		}
		return string;
	}
}
