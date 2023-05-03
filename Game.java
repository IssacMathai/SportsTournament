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
	public int options(Options options) {
		Validator optionsValidator = new IntValidator(options.first(), options.last());
		int choice = this.ui("" + options, optionsValidator, ReturnType.INT);
		this.output("> " + options.option(choice));
		return choice;
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
		Shop athleteShop = new Shop();
		athleteShop.addSellable(new Athlete("John", 30, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John1", 31, new Stats(new int[] {7, 2, 6})));
		athleteShop.addSellable(new Athlete("John2", 32, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John3", 33, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John4", 34, new Stats(new int[] {7, 2, 5})));
		athleteShop.addSellable(new Athlete("John5", 35, new Stats(new int[] {7, 7, 1})));
		
		player.setMoney(400);
		
		while (true) {
			Options shopOptions = new Options( athleteShop.getSellables() ).join( "Leave shop" ); // see later what types of parameter .join() takes
			shopOptions.setBetterIndexing(0);
			game.output("You have $" + player.getMoney() + " to spend");
			game.output("Which Athlete do you want to buy (Enter " + shopOptions.last() + " to leave)");
			int choice3 = game.options( shopOptions );
			if (choice3 == shopOptions.last()) { // exit the shop
				break;
			}
			if (athleteShop.canBuy( choice3, player.getMoney() )) {
				Sellable bought = athleteShop.buy( choice3, player.getMoney() );
				// add bought to team
				player.addAthlete( (Athlete) bought );
				game.output("Purchase Successful!" + bought);
			} else {
				String reason = "you need $" + athleteShop.price( choice3 ) + " for item " + athleteShop.getSellable( choice3 ) + ", you have $" + player.getMoney() + "."; // Item item also has a .price() method
				game.output("Purchase Unsuccessful... " + reason);
			}
			
		}
		
		
		// pick a difficulty
		Options difficultySettings = new Options(new String[] {"Easy", "Medium", "Hard"} );
		game.output("Pick a difficulty level");
		int difficulty = game.options(difficultySettings);
		
		// print rules
		game.output( game.rules() );
		
		// updated again...		
	}
}




















