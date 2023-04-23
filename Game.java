public class Game {
	public static void main(String[] args) {
		Game game = new Game();
		
		// setup the team
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
		
		// for week in weeks
			// (1) print game stats (including player.stats (which returns money)) (money, current week, and weeks remaining)
			game.output( game.stats() + player.stats() );
			// (2) go to the club
			club.setOptions( ... );
			
			int choice = game.options( club.getOptions() );
			game.output( club.useOption( choice ) );
			
			club.useItem(item, athlete);
			// item objects has a function which takes athlete as a parameter then applies effects to athlete.
			
			// (3) go to the statium
			// (4) visit the market
			game.output("Which Item do you want to buy");
			game.options( new Options(shop.getItems()) );
			shop.buy( game.input() );
			// (5) move to the next week
		
		// display end screen
		game.output("Stats");
	}
}