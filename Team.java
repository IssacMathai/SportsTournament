import java.util.ArrayList;

public class Team {
	private String name;
	private Money money;
	private int teamSize;
	private ArrayList<Athlete> athletes;
	private ArrayList<Athlete> reserves;
	public Team() {
		this.name = "";
		this.money = new Money(0);
		this.teamSize = 0;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
	}
	public Team(String name) {
		this.name = name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public Money price() {
		return new Money(50);
	}
	public int teamCount() {
		return this.athleteCount() + this.reserveCount();
	}
	// Athlete Stuff
	public int athleteCount() {
		return this.athletes.size();
	}
	public void addAthlete(Athlete athlete) { // might throw an exception ("Team full!")
		if (!this.athletes.contains(athlete) && this.athletes.size() < this.teamSize) {
			this.athletes.add(athlete);
		}
	}
    public ArrayList<Athlete> getAthletes() {
		return this.athletes;
	}
	public Athlete getAthlete(int index) {
		return this.athletes.get(index);
	}
	public void removeAthlete(Athlete athlete) {
		this.athletes.remove(athlete);
	}
	public void removeAthlete(int index) {
		this.athletes.remove(index);
	}
	// Reserve Stuff
	public int reserveCount() {
		return this.reserves.size();
	}
	public void addReserve(Athlete athlete) {
		if (!this.reserves.contains(athlete) && this.reserves.size() < this.teamSize) {
			this.reserves.add(athlete);
		}
	}
	public Athlete getReserve(int index) {
		return this.reserves.get(index);
	}
	public void removeReserve(Athlete athlete) {
		this.reserves.remove(athlete);
	}
	public void removeReserve(int index) {
		this.reserves.remove(index);
	}
	// Other Stuff
	@Override
	public String toString() {
		int number = 1;
		String names = "";
		for (Athlete member : teamMembers) {
			names += number + ": " + member;
			names += "\n";
			number += 1;
		}
		int count = names.length();
		if (count > 1) {
			return names.substring(0, count - 1);
		} else {
			return "The team has no members.";
		}
	}
}




















































