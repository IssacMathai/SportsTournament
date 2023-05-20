import java.util.ArrayList;

public class Matches {
	private ArrayList<Match> matches;
	public Matches() {
		this.matches = new ArrayList<Match>();
	}
	public void clear() {
		this.matches = new ArrayList<Match>();
	}
	public void add(Match match) {
		this.matches.add(match);
	}
	public Match getMatch(int index) {
		return this.matches.get(index);
	}
	public ArrayList<Match> getMatches() {
		return this.matches;
	}
	public String[] getMatchesList() {
		String[] matches = new String[this.matches.size()];
		for (int i = 0; i < this.matches.size(); i++) {
			matches[i] = "" + this.matches.get(i) + "============================\n";
		}
		return matches;
	}
	public String[] getMatchNames() {
		String[] matches = new String[this.matches.size()];
		for (int i = 0; i < this.matches.size(); i++) {
			matches[i] = "" + this.matches.get(i).header();
		}
		return matches;
	}
	public Match playMatch(int index) {
		Match match = this.getMatch(index);
		this.matches.remove(index);
		match.play(); // updates all stats on both teams including money
		return ( match );
	}
	public boolean canPlay(int index) {
		Match match = this.getMatch(index);
		return match.canPlay();
	}
}