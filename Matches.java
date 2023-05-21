import java.util.ArrayList;

/**
 * This class, Matches, represents a collection of matches
 */
public class Matches {
	
	/** The list of matches. */
	private ArrayList<Match> matches;
	
	/**
	 * Instantiates a new matches.
	 */
	public Matches() {
		this.matches = new ArrayList<Match>();
	}
	
	/**
	 * Clears all matches.
	 */
	public void clear() {
		this.matches = new ArrayList<Match>();
	}
	
	/**
	 * Adds a match.
	 *
	 * @param match the match
	 */
	public void add(Match match) {
		this.matches.add(match);
	}
	
	/**
	 * Gets the match at the index.
	 *
	 * @param index the index
	 * @return the match
	 */
	public Match getMatch(int index) {
		return this.matches.get(index);
	}
	
	/**
	 * Gets the list of all matches.
	 *
	 * @return the matches
	 */
	public ArrayList<Match> getMatches() {
		return this.matches;
	}
	
	/**
	 * Gets an array of string representations of all matches
	 *
	 * @return the matches list
	 */
	public String[] getMatchesList() {
		String[] matches = new String[this.matches.size()];
		for (int i = 0; i < this.matches.size(); i++) {
			matches[i] = "" + this.matches.get(i) + "============================\n";
		}
		return matches;
	}
	
	/**
	 * Gets an array of string representations of match names
	 *
	 * @return the match names
	 */
	public String[] getMatchNames() {
		String[] matches = new String[this.matches.size()];
		for (int i = 0; i < this.matches.size(); i++) {
			matches[i] = "" + this.matches.get(i).header();
		}
		return matches;
	}
	
	/**
	 * Plays match at the index, then removes it and updates match stats.
	 *
	 * @param index the index
	 * @return the match
	 */
	public Match playMatch(int index) {
		Match match = this.getMatch(index);
		this.matches.remove(index);
		match.play(); // updates all stats on both teams including money
		return ( match );
	}
	
	/**
	 * Checks if the match at the index can be played
	 *
	 * @param index the index
	 * @return true if it can be played
	 */
	public boolean canPlay(int index) {
		Match match = this.getMatch(index);
		return match.canPlay();
	}
}
