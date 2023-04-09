import java.util.Scanner;

/**
 * This class is the entry point for the entire program.
 */
public class Main {
	/**
     * Contains a string of all the valid characters that a team name can be made of
     */
	private static final String legalChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcedfghijklmnopqrstuvwxyz '";
	
	/**
     * Number of seasons between 5 and 15
     */
	private int numWeeks;
	
	/**
     * Player Money
     */
	private int money = 0;
	
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
     * Sets money
	 * @param money	sets money
     */
	public void setMoney(int money) {
		this.money = money;
	}
	
	/**
     * Gets money
	 * @return money
     */
	public int getMoney() {
		return this.money;
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
		System.out.println("==========================");
        Team team = new Team( game.inputTeamName() );
		
		// Choose number of seasons
		System.out.println("==========================");
		game.setNumWeeks( game.inputNumWeeks() );
		
		// Chose Athletes
		// TODO
		
		// Sort out difficulty
		// TODO
		
		game.setMoney( 100 );
		
		// Rest of program
		
		System.out.println("==========================");
		//System.out.println(team.getName());
		//System.out.println(game.getNumWeeks());
		
		
        team.addAthlete( new Athlete("Joe", 20, 20, 20) );
        team.addAthlete( new Athlete("James", 21, 20, 20) );
        team.addAthlete( new Athlete("John", 22, 20, 20) );
        team.addAthlete( new Athlete("Jock", 22, 20, 20) );
        team.addAthlete( new Athlete("Jordan", 22, 20, 20) );
		
		
		Inventory inv = new Inventory();
		
		inv.addItem( new Item("Water", "good for denfece", 0, 0, 5, 100, 90) );
		inv.addItem( new Item("Shoes", "good for offence", 5, 0, 0, 100, 90) );
		inv.addItem( new Item("Gun", "shoot opponent", 10, 0, 0, 100, 90) );
		inv.addItem( new Item("Heavy Shield", "block opponent", 1, 8, -6, 100, 90) );
		inv.addItem( new Item("Coke", "tasty", 99, 99, 99, 100, 50) );
		inv.addItem( new Item("Inifite Money", "buy then sell", 0, 0, 0, 0, 1000) );
		
		// BEFORE
		System.out.println("\nTeam:");
        System.out.println(team);
		
		System.out.println("\nInventory:");
		System.out.println(inv);
		
		// USE ITEM
		System.out.println("\nTesting using an item on John below (try to spot the change...)\n");
		team.getAthlete(2).setName("JOHN CENA");
		if (inv.itemExists(5)) {
			// Use Shoes on John
			team.getAthlete(2).useItem(inv.useItem(5));
		}
		
		// AFTER
		System.out.println("\nTeam:");
        System.out.println(team);
		
		System.out.println("\nInventory:");
		System.out.println(inv);
    }
}











