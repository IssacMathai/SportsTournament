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
    public int athleteCount() {
        return this.athletes.size();
    }
    public int reserveCount() {
        return this.reserves.size();
    }
    public int teamCount() {
        return this.athleteCount() + this.reserveCount();
    }
    
    public void addAthlete(Athlete athlete) {
        if (!teamMembers.contains(athlete) && teamMembers.size() < this.teamSize) {
            teamMembers.add(athlete);
        }
    }
}