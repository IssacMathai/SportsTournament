
import java.util.ArrayList;

/**
 * This class implements a Team. A team contains an ArrayList of athletes.
 */
public class Team {
    /**
     * Team stored in an ArrayList
     */
    private ArrayList<Athlete> teamMembers = new ArrayList<>();

    /**
     * Name of the team
     */
    private String name;

    /**
     * Size of the team
     */
    private int size;

    public Team(String name) {
        this.name = name;
		this.size = 5; // default size
    }
	
    public Team(int size) {
        this.name = "Team"; // default team name
		this.size = size;
    }

    /**
     * Adds an athlete to the team provided the following conditions are met:\n
     * The team must not already contain the athlete\n
     * The size of the team must be no greater than 3
     * @param athlete   pass in an athlete to add
     */
    public void addAthlete(Athlete athlete) {
        if (!teamMembers.contains(athlete) && teamMembers.size() < this.size) {
            teamMembers.add(athlete);
        }
    }

    /**
     * Adds an athlete to the team provided the following conditions is met:
     * The team must not already contain the athlete
     * The purpose of this temp add method is for swapping athletes between Team and Reserves.
     * @param athlete   pass in an athlete to add
     */
    public void tempAddAthlete(Athlete athlete) {
        if (!teamMembers.contains(athlete)) {
            teamMembers.add(athlete);
        }
    }

    /**
     * Removes an athlete from the team
     * @param athlete      pass in an athlete to remove
     */
    public void removeAthlete(Athlete athlete) {
        teamMembers.remove(athlete);
    }

    /**
     * Returns the name of the team
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets a new name for the team
     * @param name      pass in a new name for the team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the number of Athletes in the team
     * @return size
     */
    public int getTeamCount() {
        return teamMembers.size();
    }

    /**
     * Returns the athlete at the index
     * @param index     passes in the index of an athlete in the Team
     * @return Athlete returns the athlete at the index
     */
    public Athlete getAthlete(int index) {
        return teamMembers.get(index);
    }

    /**
     * Returns the team ArrayList
     * @return teamMembers
     */
    public ArrayList<Athlete> getTeamMembers() {
        return teamMembers;
    }

    /**
     * Returns the details of the Athletes in the team in a string
     */
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

    public static void main(String[] args) {
        Team a = new Team("Diamond Dogs");
        Athlete joe = new Athlete("Joe", 20, 20, 20);
        Athlete james = new Athlete("James", 21, 20, 20);
        Athlete john = new Athlete("John", 22, 20, 20);
        Athlete jock = new Athlete("Jock", 22, 20, 20);
        Athlete jordan = new Athlete("Jordan", 22, 20, 20);
        a.addAthlete(joe);
        a.addAthlete(james);
        a.addAthlete(john);
        a.addAthlete(jock);
        a.addAthlete(jordan);
        System.out.println(a);
    }
}
