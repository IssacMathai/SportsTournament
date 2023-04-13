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
	private Money money = new Money();
	
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
		this.money.set(money);
	}
	
	/**
     * Gets money
	 * @return money
     */
	public int getMoney() {
		return this.money.get();
	}
	
	/**
     * Prompts the user to input a number between 2 parameters inclusive
     */
	public int inputNumber(int lower, int upper, String message) {
		System.out.println(message);
		boolean invalid = true;
		int number = -69; // javac wants number to be initialized
		while (invalid) {
			try {
				String response = getUserInput("Enter a number from " + lower + " to " + upper + "...");
				number = Integer.parseInt(response);
				if (number < lower || number > upper) {
					// number is out of bounds
					this.feedback("Number must be between " + lower + " and " + upper);
				} else {
					// Valid Answer
					invalid = false;
				}
			} catch (NumberFormatException e) {
				// User did not enter a valid number
				this.feedback("That is not an acceptable number");
			}
		}
		return number;
	}
	
	/**
     * Prompts the user to input the number of weeks
	 * Must be between 5 and 15
     */
	public int inputNumWeeks() {
		return this.inputNumber(5, 15, "How many weeks should the season last for?");
	}
	
	/**
	 * Attempt to purchase an item
	 */
	public boolean attemptItemPurchase(int itemIndex, ItemsMarket market, Inventory inv) {
		int itemPrice = market.getItemPrice(itemIndex);
		if (this.getMoney() >= itemPrice) {
			System.out.println(market.buyItem(itemIndex, inv));
			this.setMoney(this.getMoney() - itemPrice);
			System.out.println("Purchase Successful!"); // Optional
			return true;
		} else {
			this.feedback("Not enough money - you have: $" + this.getMoney() + " (you need: $" + itemPrice + ")"); // Provide feedback
			return false;
		}
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
		
		
		
		// Market
		Inventory shop = new Inventory();
		
		shop.addItem( new Item("Water", "good for stamina", 0, 0, 5, 100, 90) );
		shop.addItem( new Item("Shoes", "good for offence", 5, 0, 0, 100, 90) );
		shop.addItem( new Item("Machine Gun", "shoot opponent", 10, 0, 0, 110, 90) );
		shop.addItem( new Item("Massive Dildo", "whack opponent", 69, 0, 0, 105, 95) );
		shop.addItem( new Item("Coke", "tasty", 99, 99, 99, 100, 50) );
		shop.addItem( new Item("Inifite Money", "buy then sell", 0, 0, 0, 0, 1000) );
		
		ItemsMarket market = new ItemsMarket( shop );
		
		System.out.println("\nMarket Stuffs\n");
		
		// Print Money
		System.out.println("You have $" + game.getMoney());
		
		
		// User chooses an item to buy
		int itemIndex = game.inputNumber(1, market.length(), "Which item to you want to buy?") - 1;
		// Game attempts to purchase item
		game.attemptItemPurchase(itemIndex, market, inv);
		
		// Print Money
		System.out.println("You have $" + game.getMoney());
		
		// try to buy items that don't exist in Market
		System.out.println(market.buyItem(-1, inv));
		System.out.println(market.buyItem(100, inv));
		
		System.out.println("\nInventory After:");
		System.out.println(inv);
		System.out.println("\nMarket After:");
		System.out.println(market);
		
		
		
		
    }
}











