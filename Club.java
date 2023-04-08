import java.util.Collections;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * This class implements the Club. The club contains both the Team and the Reserves.
 * The properties of the Team and the Reserves may be viewed in the Club.
 * Athletes may be swapped between the Team and the Reserves.
 */
public class Club {
    /**
     * Reserves are a Team and stored in the club
     */
    private Team reserves = new Team("Reserves");
    /**
     * The Team is stored in the Club
     */
    private Team team;

    public Club(Team team) {
        this.team = team;
        System.out.println("Welcome to the " + team.getName() + " Club.");

    }

    /**
     * Prompts the user to decide what they want to do in the Club.
     */
    public void userPrompt() {
        System.out.println("To view the following, please input the corresponding number.");
        System.out.println("1. Team Properties");
        System.out.println("2: Reserves Properties");
        System.out.println("3: Swap Athletes with Reserves");
        int input = getUserInput();
        if (input == 1) {
            System.out.println(team);
        } else if (input == 2) {
            System.out.println(reserves);

        } else if (input == 3) {
            swapAthletes();
            System.out.println("\nNew Team:");
            System.out.println(team);
            System.out.println("New Reserves:");
            System.out.println(reserves);

        }
    }

    /**
     * Swaps athletes between the Team and the Reserves.
     */
    public void swapAthletes() {
        System.out.println("Current Team:");
        System.out.println(team);
        System.out.println("Current Reserves:");
        System.out.println(reserves);

        System.out.println("Please enter the number of the Athlete you wish to swap out");
        int outgoingAthleteIndex = getUserInput() - 1;
        Athlete outgoingAthlete = team.getAthlete(outgoingAthleteIndex);

        System.out.println("Please enter the number of the Reserve you wish to swap in");
        int incomingAthleteIndex = getUserInput() - 1;
        Athlete incomingAthlete = reserves.getAthlete(incomingAthleteIndex);

        // Adds the incoming athlete to the team in the outgoing athlete's index and removes the outgoing athlete
        team.tempAddAthlete(incomingAthlete);
        Collections.swap(team.getTeamMembers(), outgoingAthleteIndex, team.getTeamCount()-1);
        team.removeAthlete(outgoingAthlete);

        // Adds the outgoing athlete to the reserves in the incoming athlete's index and removes the incoming athlete
        reserves.tempAddAthlete(outgoingAthlete);
        Collections.swap(reserves.getTeamMembers(), incomingAthleteIndex, reserves.getTeamCount()-1);
        reserves.removeAthlete(incomingAthlete);


    }

    /**
     * Adds an athlete to the reserves
     * @param athlete   passes in an Athlete to be added
     */
    public void addReserveAthlete(Athlete athlete) {
        reserves.addAthlete(athlete);

    }

    /**
     * Removes an athlete from the reserves
     * @param athlete passes in an athlete to be removed
     */
    public void removeReserveAthlete(Athlete athlete) {
        reserves.removeAthlete(athlete);
    }

    /**
     * Gets user input
     * @return user input integer
     */
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Team a = new Team("Diamond Dogs");
        Athlete joe = new Athlete("Joe", 20, 20, 20);
        Athlete james = new Athlete("James", 21, 20, 20);
        Athlete jack = new Athlete("Jack", 21, 20, 20);
        Athlete jerry = new Athlete("Jerry", 21, 20, 20);
        Athlete john = new Athlete("John", 21, 20, 20);
        a.addAthlete(joe);
        a.addAthlete(james);
        a.addAthlete(jack);
        a.addAthlete(jerry);
        a.addAthlete(john);

        Club c = new Club(a);
        Athlete jock = new Athlete("Jock", 22, 20, 20);
        Athlete jordan = new Athlete("Jordan", 22, 20, 20);
        c.addReserveAthlete(jock);
        c.addReserveAthlete(jordan);

        c.userPrompt();




    }
}