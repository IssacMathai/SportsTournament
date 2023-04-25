public class Game {
	public static void main(String[] args) {
		Game game = new Game();
		
		// setup the team (get the user invested in the game)
		// VVV create a Validators class which contains all these validators
		Validator nameValidator = (String inp) -> {
			// .. write the team name validator here ...
			return true;
		};
		Team player = new Team( game.ui("Choose a team name", nameValidator) );
		// ^^ does the same thing as:
		// Team player = new Team();
		// player.teamName( game.ui("Choose a team name", validaterFunction) );
		
		// choose and set the number of weeks in the season.
		// ... write a weeksValidator function, based of an intValidator ...
		int weeks = game.ui("How many weeks will the season be?", weeksValidator);
		
		// purchase the starting athletes in the team
		// ... use a shop class
		
		// pick a difficulty
		Options difficultySettings = new Options(new String[] {"Easy", "Medium", "Hard"} );
		game.output("Pick a difficulty level");
		int difficulty = game.options(difficultySettings);
		
		// print rules
		game.output( game.rules() );
		
		// for week in weeks
			// (0) print game stats (including player.stats (which returns money)) (money, current week, and weeks remaining)
			game.output( game.stats() + player.stats() );
			
			
			Options actions = new Options(new String[] {"Manage your team at the clubs", "Play Matches", "Go to the shop", "Take a Bye (move to the next week)"} );
			int action = game.options();
			
			// (1) go to the club
			club.setOptions( ... );
			
			int choice1 = game.options( club.getOptions() );
			game.output( club.useOption( choice1 ) );
			
			club.useItem(item, athlete);
			// item objects has a function which takes athlete as a parameter then applies effects to athlete.
			
			// (2) go to the statium
			
			while (true) {
				Options staduimOptions = new Options( matches )
				game.output("Matches left you can play");
				int choice2 = game.options( staduimOptions ).join( "Go back..." );
				if (choice2 == staduimOptions.last()) {
					// leave the staduim page...
					break;
				}
				if (matches.status(choice2) == PLAYED) {
					// looks like you've already played this team... choose again!
					continue;
				}
				if (choice2) {
					match = matches.getMatch(choice);
					match.play(); // updates all stats on both teams including money
					game.output( match.results() );
				}
			}
			
			// (3) visit the shop/market
			while (true) {
				Options shopOptions = new Options( shop.getItems() ).join( "Leave shop" ); // see later what types of parameter .join() takes
				game.output("Which Item do you want to buy (Enter " + shopOptions.last() + " to leave)");
				int choice3 = game.options( shopOptions );
				if (shop.canBuy( choice3 )) {
					Item bought = shop.buy( choice3 );
					// add bought to inventory
					player.addItem( bought );
					game.output("Purchase Successful!");
				} else {
					String reason = "you need $" + shop.price( choice3 ) + " for item " + shop.item( choice3 ) + ", you have $" + player.getMoney() + "."; // Item item also has a .getPrice() method
					game.output("Purchase Unsuccessful... " + reason);
				}
			}
			
			// (4) move to the next week
			if (choice2 == stadiumOptions.last()) {
				// take a bye
				// update classes
				// random events
				// train athlete
			}
		
		// display end screen
		game.output("Stats");
	}
}