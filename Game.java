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
	public static void main(String[] args) {
		Game game = new Game();
		
		// setup the team (get the user invested in the game)
		// VVV create a NameValidators] class which contains the String validator for team name
		Validator nameValidator = new NameValidator(3, 15);
		Team player = new Team( game.ui("Choose a team name", nameValidator) , 5);
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
		Shop shop = new Shop();
		shop.addSellable(new Athlete("John", 30, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John1", 31, new Stats(new int[] {7, 2, 6})));
		shop.addSellable(new Athlete("John2", 32, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John3", 33, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John4", 34, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John5", 35, new Stats(new int[] {7, 7, 1})));
		
		player.setMoney(400);
		int choice;
		
		while (true) {
			Options shopOptions = new Options( shop.getSellables() ).join( "Leave shop" ); // see later what types of parameter .join() takes
			shopOptions.setBetterIndexing(0);
			game.output("You have $" + player.getMoney() + " to spend");
			game.output("Which Athlete do you want to buy (Enter " + shopOptions.last() + " to leave)");
			choice = game.options( shopOptions );
			if (choice == shopOptions.last()) { // exit the shop
				break;
			}
			if (shop.canBuy( choice, player.getMoney() )) {
				Sellable bought = shop.buy( choice, player.getMoney() );
				// add bought to team
				player.addAthlete( (Athlete) bought );
				game.output("Purchase Successful!" + bought);
			} else {
				String reason = "you need $" + shop.price( choice ) + " for " + shop.getSellable( choice ) + ", you have $" + player.getMoney() + "."; // Item item also has a .price() method
				game.output("Purchase Unsuccessful... " + reason);
			}
			
		}
		
		
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
					
					Shop shop = new Shop();
					
					if (game.first()) { // Item shop
						
					} else if (game.first(1)) { // Athlete shop
						shop.addSellable(new Athlete("Ben", 30, new Stats(new int[] {7, 2, 5})));
						shop.addSellable(new Athlete("Ben1", 31, new Stats(new int[] {7, 2, 6})));
						shop.addSellable(new Athlete("Ben2", 32, new Stats(new int[] {7, 2, 5})));
						shop.addSellable(new Athlete("Ben3", 33, new Stats(new int[] {7, 2, 5})));
						shop.addSellable(new Athlete("Ben4", 34, new Stats(new int[] {7, 2, 5})));
						shop.addSellable(new Athlete("Ben5", 35, new Stats(new int[] {7, 7, 1})));
					}
					
					while (true) {
						Options shopOptions = new Options( shop.getSellables() ).join( "Leave shop" ); // see later what types of parameter .join() takes
						shopOptions.setBetterIndexing(0);
						game.output("You have $" + player.getMoney() + " to spend");
						game.output("Which Athlete do you want to buy (Enter " + shopOptions.last() + " to leave)");
						choice = game.options( shopOptions );
						if (choice == shopOptions.last()) { // exit the shop
							break;
						}
						if (shop.canBuy( choice, player.getMoney() )) {
							Sellable bought = shop.buy( choice, player.getMoney() );
							// add bought to team
							player.addAthlete( (Athlete) bought );
							game.output("Purchase Successful!" + bought);
						} else {
							String reason = "you need $" + shop.price( choice ) + " for " + shop.getSellable( choice ) + ", you have $" + player.getMoney() + "."; // Item item also has a .price() method
							game.output("Purchase Unsuccessful... " + reason);
						}
						
					}
					
					continue;
				}
				if (game.last()) { // (4) move to the next week
					// take a bye
					// update classes
					// random events
					// train athlete
					inWeek = false;
					continue;
				}
			}
		}
		
		// display end screen
		game.output("Stats");
		
	}
}




















