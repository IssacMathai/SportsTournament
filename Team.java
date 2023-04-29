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
		this.money = new Money(0);
		this.teamSize = 0;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
	}
	public Team(int teamSize) {
		this.name = "";
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
	}
	public Team(String name, int teamSize) {
		this.name = name;
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setMoney(Money money) {
		this.money = money;
	}
	public Money getMoney() {
		return this.money;
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
		String string = "";
		string += "Team " + this.name + "\n";
		string += "$" + this.money + "\n";
		for (Athlete athlete : this.athletes) {
			string += athlete + "\n";
		}
		if (this.teamCount() == 0) {
			string += "The team has no members.";
		}
		return string;
	}
}




















































