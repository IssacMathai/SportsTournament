import java.util.Scanner;

public class Game {
	public String rules() {
		return "[Insert Game Rules Here]";
	}
	public void feedback(String string) {
		this.output("[!] " + string);
	}
	public void output(Object string) {
		System.out.println(string);
	}
	// Return String
	public String ui(String message, Validator v) {
		Scanner scan = new Scanner(System.in);
		this.output(message);
		String input = scan.nextLine();
		boolean valid = false;
		while (!valid) {
			try {
				valid = v.validate(input);
			} catch (Exception e) {
				// provides feedback and tries again
				this.feedback(e.getMessage());
				input = scan.nextLine();
			}
		}
		return input;
	}
	// Return Int
	public int ui(String message, Validator v, ReturnType type) {
		Scanner scan = new Scanner(System.in);
		this.output(message);
		String input = scan.nextLine();
		boolean valid = false;
		while (!valid) {
			try {
				valid = v.validate(input);
			} catch (Exception e) {
				// provides feedback and tries again
				this.feedback(e.getMessage());
				input = scan.nextLine();
			}
		}
		// Safe to ParseInt
		int number = Integer.parseInt(input);
		return number;
	}
	private int lastChoice;
	private Options lastOptions;
	public int options(Options options) {
		Validator optionsValidator = new IntValidator(options.first(), options.last());
		int choice = this.ui("" + options, optionsValidator, ReturnType.INT);
		this.output("> " + options.option(choice));
		
		this.lastChoice = choice;
		this.lastOptions = options;
		
		return choice;
	}
	public boolean first() {
		return this.lastChoice == this.lastOptions.first();
	}
	public boolean first(int index) {
		return this.lastChoice == this.lastOptions.first() + index;
	}
	public boolean last() {
		return this.lastChoice == this.lastOptions.last();
	}
	public void resetShop(Shop itemShop, Shop athleteShop) {
		itemShop.clear();
		athleteShop.clear();
		
		itemShop.addSellable(new Item("Water Bottle", "you can drink it", new Stats(new int[] {7, 2, 5}), 100, 80));
		itemShop.addSellable(new Item("Vinegar Bottle", "you can drink it", new Stats(new int[] {10, 2, 5}), 120, 110));
		itemShop.addSellable(new Item("Shoes", "makes you faster", new Stats(new int[] {10, 10, 10}), 80, 40));
		
		athleteShop.addSellable(new Athlete("John", 30, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John1", 31, new Stats(new int[] {7, 2, 6})));
		athleteShop.addSellable(new Athlete("John2", 32, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John3", 33, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John4", 34, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John5", 35, new Stats(new int[] {7, 7, 1})));
	}
	public void simulateShop(Shop shop, Team player) {
		while (true) {
			Options shopOptions = new Options( shop.getSellables() ).join( "Leave shop" ); // see later what types of parameter .join() takes
			shopOptions.setBetterIndexing(0);
			this.output("You have $" + player.getMoney() + " to spend");
			this.output("Which Athlete do you want to buy (Enter " + shopOptions.last() + " to leave)");
			int choice = this.options( shopOptions );
			if (choice == shopOptions.last()) { // exit the shop
				break;
			}
			try {
				if (shop.canBuy( choice, player )) {
					Sellable bought = shop.buy( choice, player );
					// add bought to team
					player.addSellable( bought );
					this.output("Purchase Successful!" + bought);
				}
			} catch (Exception e) {
				String reason = e.getMessage();
				this.output("Purchase Unsuccessful... " + reason);
			}
		}
	}
	public static void main(String[] args) {
		Game game = new Game();
		
		// setup the team (get the user invested in the game)
		// VVV create a NameValidators] class which contains the String validator for team name
		Validator nameValidator = new NameValidator(3, 15);
		Team player = new Team( game.ui("Choose a team name", nameValidator) , 4);
		// ^^ does the same thing as:
		// Team player = new Team();
		// player.setName( game.ui("Choose a team name", nameValidator) );
		
		game.output( player );
		
		Validator weeksValidator = new IntValidator(5, 15);
		// choose and set the number of weeks in the season.
		// ... uses a weeksValidator function
		int weeks = game.ui("How many weeks will the season be?", weeksValidator, ReturnType.INT);
		
		// purchase the starting athletes in the team
		// ... use a shop class
		Shop shop = new Shop(); // Continue to use shop throughout the program
		shop.addSellable(new Athlete("John", 30, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John1", 31, new Stats(new int[] {7, 2, 6})));
		shop.addSellable(new Athlete("John2", 32, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John3", 33, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John4", 34, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John5", 35, new Stats(new int[] {7, 7, 1})));
		
		player.setMoney(500);
		int choice;
		
		Shop itemShop = new Shop();
		Shop athleteShop = new Shop();
		game.resetShop(itemShop, athleteShop);
		
		game.simulateShop( shop, player );
		
		
		// pick a difficulty
		Options difficultySettings = new Options(new String[] {"Easy", "Medium", "Hard"} );
		game.output("Pick a difficulty level");
		int difficulty = game.options(difficultySettings);
		
		// print rules
		game.output( game.rules() );
		
		// for week in weeks
		for (int week = 1; week <= weeks; week++) {
			// (0) print game stats (including player.stats (which returns money)) (money, current week, and weeks remaining)
			game.output("Week " + week);
			
			boolean inWeek = true; // is set to false when a bye is taken
			while (inWeek) {
				Options actions = new Options(new String[] {"Manage your team at the clubs", "Play Matches", "Go to the shop", "Take a Bye" + " (move to the next week)"} ); //move to the next week (as long as it aint the last week)
				int action = game.options(actions);
				
				
				if (game.first()) { // (1) go to the club
				/*
					club.setOptions( ... );
					
					choice = game.options( club.getOptions() );
					game.output( club.useOption( choice ) );
					
					club.useItem(item, athlete); */
					// item objects has a function which takes athlete as a parameter then applies effects to athlete.
					continue;
				}
				if (game.first(1)) { // (2) go to the statium
				/*
					while (true) {
						Options staduimOptions = new Options( matches );
						game.output("Matches left you can play");
						choice = game.options( staduimOptions.join( "Go back..."  ));
						if (choice == staduimOptions.last()) {
							// leave the staduim page...
							break;
						}
						if (matches.status(choice) == PLAYED) {
							// looks like you've already played this team... choose again!
							continue;
						}
						if (choice) {
							match = matches.getMatch(choice);
							match.play(); // updates all stats on both teams including money
							game.output( match.results() );
						}
					} */
					continue;
				}
				if (game.first(2)) { // (3) visit the shop/market
					Options shopChoiceOptions = new Options(new String[] {"Item Shop", "Athlete Shop", "Leave Shop"} );
					game.output("Select an option (Enter " + shopChoiceOptions.last() + " to leave)");
					choice = game.options(shopChoiceOptions);
					
					if (game.last()) { // Leave shop
						continue;					
					}
					
					//Shop shop = new Shop();
					
					if (game.first()) { // Item shop
						shop = itemShop;
					} else if (game.first(1)) { // Athlete shop
						shop = athleteShop;
					}
					
					game.simulateShop( shop, player );
					
					continue;
				}
				if (game.last()) { // (4) move to the next week
					// take a bye
					// update classes
					// random events
					// train athlete
					game.resetShop(itemShop, athleteShop);
					inWeek = false;
					continue;
				}
			}
		}
		
		// display end screen
		game.output("Stats");
		
	}
}




















