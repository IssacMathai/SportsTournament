import java.util.ArrayList;

// TODO: Auto-generated Javadoc
/**
 * The Class Matches.
 */
public class Matches {
	
	/** The matches. */
	private ArrayList<Match> matches;
	
	/**
	 * Instantiates a new matches.
	 */
	public Matches() {
		this.matches = new ArrayList<Match>();
	}
	
	/**
	 * Clear.
	 */
	public void clear() {
		this.matches = new ArrayList<Match>();
	}
	
	/**
	 * Adds the.
	 *
	 * @param match the match
	 */
	public void add(Match match) {
		this.matches.add(match);
	}
	
	/**
	 * Gets the match.
	 *
	 * @param index the index
	 * @return the match
	 */
	public Match getMatch(int index) {
		return this.matches.get(index);
	}
	
	/**
	 * Gets the matches.
	 *
	 * @return the matches
	 */
	public ArrayList<Match> getMatches() {
		return this.matches;
	}
	
	/**
	 * Gets the matches list.
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
	 * Gets the match names.
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
	 * Play match.
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
	 * Can play.
	 *
	 * @param index the index
	 * @return true, if successful
	 */
	public boolean canPlay(int index) {
		Match match = this.getMatch(index);
		return match.canPlay();
	}
}
