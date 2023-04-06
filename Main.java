import java.util.Scanner;

/**
 * This class is the entry point for the entire program.
 */

public class Main {
	/**
     * Contains a string of all the valid characters that a team name can be made of
     */
	private static final String legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcedfghijklmnopqrstuvwxyz ";
	
	/**
     * Number of seasons between 5 and 15
     */
	private int numWeeks;
	
	/**
	 * Provides corrective feedback
	 */
	private void feedback(String message) {
		System.out.println("[!] " + message);
	}
	
	/**
     * Validates a name based on whether it is legal or not
	 * @param name	pass in a name to check
     */
	private boolean checkIllegal(String name) {
		if (name.length() < 3 || name.length() > 15) { // Is name between 3 and 15 characters?
			this.feedback("Please provide a team name between 3 and 15 characters");
			return true;
		} else { // Loop through letters in name, and check if there is an invalid letter
			for (int i = 0; i < name.length(); i++) {
				if (this.legalChars.indexOf( name.charAt(i) ) == -1) {
					this.feedback("Team names must consist of alphabetical letters only");
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Gets Users input
	 */
	public String getUserInput(String message) {
		Scanner scanner = new Scanner(System.in);
		System.out.println(message);
		return scanner.nextLine();
	}
	
	/**
	 * Prompts the user to enter a team name
	 */
	public String inputTeamName() {
		String teamName = getUserInput("Enter a team name below...");
		// Check team name is valid
		while (this.checkIllegal(teamName)) {
			teamName = getUserInput("Try Again...");
		}
		return teamName;
	}
	
	/**
     * Sets numWeeks
	 * @param numWeeks	sets numWeeks
     */
	public void setNumWeeks(int numWeeks) {
		this.numWeeks = numWeeks;
	}
	
	/**
     * Gets numWeeks
	 * @return numWeeks
     */
	public int getNumWeeks() {
		return this.numWeeks;
	}
	
	/**
     * Prompts the user to input the number of weeks
	 * Must be between 5 and 15
     */
	public int inputNumWeeks() {
		System.out.println("How many weeks should the season last for?");
		boolean invalid = true;
		int weeks = -69;
		while (invalid) {
			try {
				String response = getUserInput("Enter a number from 5 to 15...");
				weeks = Integer.parseInt(response);
				if (weeks < 5 || weeks > 15) {
					// Weeks is out of bounds
					this.feedback("Number of weeks must be between 5 and 15");
				} else {
					// Valid Answer
					invalid = false;
				}
			} catch (NumberFormatException e) {
				// User did not enter a valid number
				this.feedback("That is not an acceptable number");
			}
		}
		return weeks;
	}
	
	/**
     * Creates an Instance of the game
     */
	public static void main(String[] args) {
		// Initialize the Game
		Main game = new Main();
		
		// Create a team
		System.out.println("======================");
        Team team = new Team( game.inputTeamName() );
		
		// Choose number of seasons
		System.out.println("======================");
		game.setNumWeeks( game.inputNumWeeks() );
		
		// Rest of program
		System.out.println("======================");
		System.out.println(team.getName());
		System.out.println(game.getNumWeeks());
        Athlete joe = new Athlete("Joe", 20, 20, 20);
        Athlete james = new Athlete("James", 21, 20, 20);
        Athlete john = new Athlete("John", 22, 20, 20);
        Athlete jock = new Athlete("Jock", 22, 20, 20);
        Athlete jordan = new Athlete("Jordan", 22, 20, 20);
        team.addAthlete(joe);
        team.addAthlete(james);
        team.addAthlete(john);
        team.addAthlete(jock);
        team.addAthlete(jordan);
        System.out.println(team);
    }
}











