import java.util.Scanner;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;

public class Game {
	public final int teamSize = 10;
	public final int fieldSize = 5;
	public String rules() {
		return "[Insert Game Rules Here]";
	}
	
	public void feedback(String string) {
		this.output("[!] " + string);
	}
	public String lastOutput = "";
	public ArrayList<String> prevOutputs = new ArrayList<String>();
	public void output(Object string) {
		System.out.println(string);
		this.lastOutput = string.toString();
		// add to display
		String[] display = this.lastOutput.split("\n");
		for (int i = 0; i < display.length; i++) {
			this.prevOutputs.add("<html>" + display[i] + "</html>");
		}
		//this.prevOutputs.add(this.lastOutput);
	}
	public void output(Object string, int yeeet) {
		System.out.println(string);
		this.prevOutputs = new ArrayList<String>(); // clear the display
		this.lastOutput = string.toString();
		// add to display
		String[] display = this.lastOutput.split("\n");
		for (int i = 0; i < display.length; i++) {
			this.prevOutputs.add("" + display[i]);
		}
		//this.prevOutputs.add(this.lastOutput);
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
	public String lastInput;
	public int options(Options options) {
		Validator optionsValidator = new IntValidator(options.first(), options.last());
		
		// Command line stuff below
		//int choice = this.ui("" + options, optionsValidator, ReturnType.INT);
		
		int choice;
		if (options.getType() == 1) {
			choice = this.launchOptionsScreen(options, options.getText());
		} else {
			choice = this.launchOptionsScreen(options);
		}
		
		//this.output("> " + options.option(choice), 69);
		
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
	private static final String[] teamNames1 =   {"Diamond", "Rusty", "Maccas", "Sweaty", "Amber", "Old", "Burger", "Smelly", "Crystal", "Math", "Meth", "Cocaine", "Nerdy", "Handy", "Sharp", "Blunt", "Shiney", "Ancient", "Greasy", "Moist", "Precious", "Decayed", "Fries", "Sticky", "Gleemin", "Dry", "Big Mac", "Soggy", "Bloody", "Grubby"};
	private static final String[] teamNames2 =   {"Dogs", "Cows", "Addicts", "Bois", "Cats", "Horses", "Butts", "Dudes", "Meet", "Moo", "Beef", "Guys", "Canines", "Nerds", "Junkies", "Fellas", "Targets", "Axes", "Gamerz", "Bros", "Pets", "Bull", "Lovers", "Addicts", "Gents", "Cutters", "Herds", "Freaks", "Homies", "Daddys"};
	private static final String[] athleteNames = {"John", "Andy", "Ben", "George Harrison", "Mike", "Dwight", "Jack", "Joe", "Snape", "Taki", "Robert", "Steve", "Dave", "Paul", "Ringo", "Charlie", "James", "Tony", "Sam", "Frank", "Harry", "Tom", "William", "Peter", "Alex", "Oliver", "Daniel", "Eric", "Richard", "Brian"};
	private static final String[] itemNames =    {"Target", "Axe", "Gloves", "Board", "Bullseye", "Helmet", "Guard", "Mat", "Rack", "Log", "Stand", "Patch", "Sticker", "Case", "Sharpener", "Guide", "Marker", "Line", "Hammer", "Tape", "Chalk", "Strap", "Tee", "Shirt", "Bag", "Net", "Bar", "Wheel", "Timer", "Arm"};
	private static final String[] itemDescs =    {"Aims and measures accuracy.", "Thrown to hit the target.", "Provides hand protection.", "Surface for axe throwing.", "Center of the target.", "Ensures head safety.", "Protects against accidents.", "Provides grip and stability.", "Stores axes conveniently.", "The target for axe throwing.", "Holds the target board.", "Badge for achievement.", "Marks the bullseye.", "Carries axes securely.", "Maintains axe edge.", "Offers throwing tips.", "Indicates hit location.", "Marks throwing distance.", "Sets up the target.", "Measures throwing line.", "Marks score and lines.", "Secures equipment.", "Axe resting platform.", "Displays team affiliation.", "Carries equipment easily.", "Catches and stops axes.", "Protects against ricochets.", "Provides extra grip.", "Keeps score and stats.", "Enhances throwing technique.", "Records throwing data."};
	public void resetShop(Shop itemShop, Shop athleteShop) {
		itemShop.clear();
		athleteShop.clear();
		
		Generator gen = new Generator(athleteNames, itemNames, itemDescs);
		
		itemShop.addSellable(gen.item());
		itemShop.addSellable(gen.item());
		itemShop.addSellable(gen.item());
		
		athleteShop.addSellable(gen.athlete());
		athleteShop.addSellable(gen.athlete());
		athleteShop.addSellable(gen.athlete());
		athleteShop.addSellable(gen.athlete());
		athleteShop.addSellable(gen.athlete());
		athleteShop.addSellable(gen.athlete());
	}
	public void resetMatches(Matches matches, Team player) {
		Team opponent;
		
		matches.clear();
		
		opponent = new Team("Diamond Dogs", this.teamSize, this.fieldSize);
		opponent.addAthlete( new Athlete("Andy", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Andy1", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Andy2", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Andy3", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Andy4", 30, new Stats(new int[] {3, 2, 5})) );
		matches.add( new Match(player, opponent, this.fieldSize) );
		
		opponent = new Team("Rusty Cows", this.teamSize, this.fieldSize);
		opponent.addAthlete( new Athlete("Ben", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Ben1", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Ben2", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Ben10", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("George Harrison", 30, new Stats(new int[] {3, 2, 5})) );
		
		matches.add( new Match(player, opponent, this.fieldSize) );
		
		opponent = new Team("Dream team", this.teamSize, this.fieldSize);
		opponent.addAthlete( new Athlete("Mike", 30, new Stats(new int[] {2, 3, 5})) );
		opponent.addAthlete( new Athlete("Dwight", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Jack", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Joe", 30, new Stats(new int[] {3, 2, 5})) );
		opponent.addAthlete( new Athlete("Snape", 30, new Stats(new int[] {30, 50, 50})) );
		
		matches.add( new Match(player, opponent, this.fieldSize) );
	}
	public void simulateShop(Shop shop, Team player) {
		while (true) {
			Options shopOptions = new Options( shop.getSellables() ).join( "Leave shop" ); // see later what types of parameter .join() takes
			shopOptions.setBetterIndexing(0);
			shopOptions.setText("Buy"); // BUTTON TEXT
			
			this.output("<html>You have <i stlye='color:#ec1;'>$" + player.getMoney() + "</i> to spend</html>", 69);
			this.output("Which purchase do you want to make (Enter " + shopOptions.last() + " to leave)");
			int choice = this.options( shopOptions );
			if (choice == shopOptions.last()) { // exit the shop
				break;
			}
			try {
				if (shop.canBuy( choice, player )) {
					Sellable bought = shop.buy( choice, player );
					// add bought to team
					if (bought instanceof Athlete) { // options to rename athlete
						Validator nameValidator = (String string) -> {
							// .. write the athlete nickname validator here ...
							if (string.length() < 3) {
								throw new Exception("Nickname must be longer than 3");
								//return false;
							} else if (string.length() > 15) {
								throw new Exception("Nickname must be shorter than 15");
								//return false;
							} else { // Loop through letters in name, and check if there is an invalid letter
								for (int i = 0; i < string.length(); i++) {
									if (NameValidator.legalChars.indexOf( string.charAt(i) ) == -1) {
										throw new Exception("No silly characters '" + string.charAt(i) + "'");
										//return false;
									}
								}
							}
							return true;
						};
						Athlete athlete = (Athlete) bought;
						athlete.setName( this.launchInputScreen("Enter a Nickname", athlete.getName(), nameValidator) );
						bought = athlete;
					}
					player.addSellable( bought );
					this.output("Purchase Successful! " + bought);
				}
			} catch (Exception e) {
				String reason = e.getMessage();
				this.output("Purchase Unsuccessful... " + reason);
			}
		}
	}
	public void simulateSelling(Team player) { // Sells Items
		while (true) {
			Options shopOptions = new Options( player.getInventory().getSellables() ).join( "Leave shop" ); // see later what types of parameter .join() takes
			shopOptions.setBetterIndexing(0);
			shopOptions.setText("Sell"); // BUTTON TEXT
			
			this.output("You have $" + player.getMoney() + " to spend", 69);
			//this.output("What do you want to sell (Enter " + shopOptions.last() + " to leave)");
			int choice = this.options( shopOptions );
			if (choice == shopOptions.last()) { // exit the shop
				break;
			}
			
			Item item = player.getInventory().use(choice);
			player.getMoney().change( item.price().get() );
			
		}
	}
	public void simulateDrafting(Team player) { // Sells Athletes
		while (true) {
			Options shopOptions = new Options( player.getAthletesAsSellables() ).join( "Leave shop" ); // see later what types of parameter .join() takes
			shopOptions.setText("Sell"); // BUTTON TEXT
			shopOptions.setBetterIndexing(0);
			
			this.output("You have $" + player.getMoney() + " to spend", 69);
			//this.output("What do you want to sell (Enter " + shopOptions.last() + " to leave)");
			int choice = this.options( shopOptions );
			if (choice == shopOptions.last()) { // exit the shop
				break;
			}
			
			Athlete athlete = player.removeAthlete(choice);
			player.getMoney().change( athlete.price().get() );
			
		}
	}
	public void simulateClub(Team player) {
		while (true) {
			this.output("", 69);
			Options clubChoiceOptions = new Options(new String[] {"View Team", "View Inventory", "Leave Club"} );
			//this.output("Select an option (Enter " + clubChoiceOptions.last() + " to leave)");
			int choice = this.options(clubChoiceOptions);
			
			if (this.first()) { // view team
				this.output( player );
				// swap athletes
				Options clubOptions = new Options(new String[] {"Swap Athletes", "Go Back"} );
				//this.output("Select an option (Enter " + clubOptions.last() + " to leave)");
				choice = this.options(clubOptions);
				
				if ( this.first() ) { // swap athletes
					clubOptions = new Options( player.getAthletesAsSellables() ).join( "Cancel" );
					clubOptions.setText("Choose"); // BUTTON TEXT
					this.output("Select an athlete to swap (Enter " + clubOptions.last() + " to leave)", 69);
					int athleteChoice1 = this.options(clubOptions);
					
					if (! this.last() ) { // choose a second athlete
						clubOptions = new Options( player.getAthletesAsSellables() ).join( "Cancel" );
						clubOptions.setText("Choose"); // BUTTON TEXT
						clubOptions.setHigh(athleteChoice1);
						this.output("Select another athlete to swap (Enter " + clubOptions.last() + " to leave)", 69);
						int athleteChoice2 = this.options(clubOptions);
						
						if (! this.last() ) {
							player.swapAthletes(athleteChoice1, athleteChoice2);
							this.launchFeedbackScreen(player.getAthlete(athleteChoice1).getName() + " and " + player.getAthlete(athleteChoice2).getName() + " have been swapped.");
						}
					}
				}
				
			} else if (this.first(1)) { // view inventory
				this.output( player.getInventory() );
				// use items
				Options clubOptions = new Options( player.getInventory().getSellables() ).join( "Go Back" );
				clubOptions.setText("Use"); // BUTTON TEXT
				//this.output("Select an item to use (Enter " + clubOptions.last() + " to leave)");
				int itemChoice = this.options(clubOptions);
				
				if (! this.last() ) {
					clubOptions = new Options( player.getAthletesAsSellables() ).join( "Leave" );
					clubOptions.setText("Select"); // BUTTON TEXT
					this.output("Select an athlete to use it on (Enter " + clubOptions.last() + " to leave)");
					int athleteChoice = this.options(clubOptions);
					
					if (! this.last() ) {
						Item used = player.useItem(itemChoice, athleteChoice);
						this.launchFeedbackScreen("Used " + used.getName() + " on " + player.getAthlete(athleteChoice).getName());
					}
				}
			} else if (this.last()) { // leave
				break;
			}
		}
	}
	public void simulateStadium(Matches matches) {
		while (true) {
			String[] matchList = matches.getMatchesList();
			Options staduimOptions = new Options( matches.getMatchNames() ).join( "Go back..." );
			staduimOptions.setText("Play"); // BUTTON TEXT
			this.output("Matches left you can play", 69);
			for (int i = 0; i < matchList.length; i++) {
				this.output(matchList[i]);
			}
			int choice = this.options( staduimOptions);
			if (choice == staduimOptions.last()) {
				// leave the staduim page...
				break;
			}
			if (! this.last()) {
				Match match = matches.playMatch( choice ); // uses up the match
				this.launchFeedbackScreen( "<html>" + match.getResult() + "</html>" );
				//this.output( match.getResults() );
			}
		}
	}
	public void goToShop(Shop itemShop, Shop athleteShop, Team player) {
		Options shopChoiceOptions = new Options(new String[] {"Buy Items", "Buy Athletes", "Sell Items", "Sell Athletes", "Leave Shop"} );
		this.output("Select an option (Enter " + shopChoiceOptions.last() + " to leave)");
		int choice = this.options(shopChoiceOptions);
		
		/*
		if (this.last()) { // Leave shop
			continue;					
		}
		*/
		
		Shop shop = new Shop(); // must initialize so java stays happy
		
		if (this.first()) { // Item shop
			shop = itemShop;
			this.simulateShop( shop, player );
		} else if (this.first(1)) { // Athlete shop
			shop = athleteShop;
			this.simulateShop( shop, player );
		} else if (this.first(2)) { // Item shop
			this.simulateSelling( player );
		} else if (this.first(3)) { // Athlete shop
			this.simulateDrafting( player );
		}
	}
	
	public void closeSetupScreen(SetupScreen window) {
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	public void closeOptionsScreen(OptionsScreen window, int choice) {
		this.lastChoice = choice;
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	public void closeFeedbackScreen(FeedbackScreen window) {
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	public void closeInputScreen(InputScreen window, String string) {
		this.lastInput = string;
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	public void launchSetupScreen() {
		Game reference = this;
		CountDownLatch latch = new CountDownLatch(1);
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen(reference, latch);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			latch.await(); // Wait until the latch is counted down
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int launchOptionsScreen(Options options, String text) { // version for small buttons with the same text
		Game reference = this;
		CountDownLatch latch = new CountDownLatch(1);
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
        			OptionsScreen window = new OptionsScreen(reference, options, latch, text);
       				//optionsScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			latch.await(); // Wait until the latch is counted down
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this.lastChoice;
	}
	
	public int launchOptionsScreen(Options options) {
		Game reference = this;
		CountDownLatch latch = new CountDownLatch(1);
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
        			OptionsScreen window = new OptionsScreen(reference, options, latch);
       				//optionsScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			latch.await(); // Wait until the latch is counted down
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this.lastChoice;
	}
	
	public void launchFeedbackScreen(String text) {
		Game reference = this;
		CountDownLatch latch = new CountDownLatch(1);
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
        			FeedbackScreen window = new FeedbackScreen(reference, latch, text);
       				//optionsScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			latch.await(); // Wait until the latch is counted down
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public String launchInputScreen(String text, String def, Validator v) {
		Game reference = this;
		CountDownLatch latch = new CountDownLatch(1);
		
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				try {
        			InputScreen window = new InputScreen(reference, latch, text, def, v);
       				//optionsScreen.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		try {
			latch.await(); // Wait until the latch is counted down
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return this.lastInput;
	}
	
	public void simulateGame(Team player, int weeks, int difficulty, Shop itemShop, Shop athleteShop, Matches matches) {
		this.output("inside simulate game " + weeks);
		//this.options(new Options(new String[] {"hiya", "yooo"}));
		// for week in weeks
		for (int week = 1; week <= weeks; week++) {
			// (0) print game stats (including player.stats (which returns money)) (money, current week, and weeks remaining)
			
			boolean inWeek = true; // is set to false when a bye is taken
			while (inWeek) {
				this.output("Week " + week, 69);
				Options actions = new Options(new String[] {"Manage your team at the clubs", "Play Matches", "Go to the shop", "Take a Bye" + " (move to the next week)"} ); //move to the next week (as long as it aint the last week)
				int action = this.options(actions);
				
				
				if (this.first()) { // (1) go to the club
					
					this.simulateClub(player);
					
					continue;
				} else if (this.first(1)) { // (2) go to the statium
				
					this.simulateStadium(matches);
					
					continue;
				} else if (this.first(2)) { // (3) visit the shop/market
					
					this.goToShop(itemShop, athleteShop, player);
					
					continue;
				} else if (this.last()) { // (4) move to the next week
					// take a bye
					// update classes
					// random events
					// train athlete
					this.resetShop(itemShop, athleteShop);
					this.resetMatches(matches, player);
					inWeek = false;
					continue;
				}
			}
		}
	}
	
	
	// game variables
	public Team player;
	public Shop itemShop;
	public Shop athleteShop;
	public int weeks = 5;
	public int difficulty;
	public Matches matches;
	
	public void startGame() {
		// purchase the starting athletes in the team
		// ... use a shop class
		
		// pick a difficulty
		Options difficultySettings = new Options(new String[] {"Easy", "Medium", "Hard"} );
		this.output("Pick a difficulty level", 69);
		this.difficulty = this.options(difficultySettings);
		
		Shop shop = new Shop(); // Continue to use shop throughout the program
		Generator gen = new Generator(athleteNames, itemNames, itemDescs);
		
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		
		this.player.setMoney(5000);
		int choice;
		
		this.itemShop = new Shop();
		this.athleteShop = new Shop();
		this.resetShop(this.itemShop, this.athleteShop);
		
		this.matches = new Matches();
		this.resetMatches(this.matches, this.player);
		
		this.simulateShop( shop, this.player );
		
		// print rules
		//this.output( this.rules() );
		
		simulateGame(this.player, this.weeks, this.difficulty, this.itemShop, this.athleteShop, this.matches);
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		
		// setup the team (get the user invested in the game)
		// VVV create a NameValidators] class which contains the String validator for team name
		
		game.launchSetupScreen();
		
		game.startGame();
		
		/*
		
		game.player = new Team( game.ui("Choose a team name", nameValidator) , game.teamSize, game.fieldSize);
		// ^^ does the same thing as:
		// Team player = new Team();
		// player.setName( game.ui("Choose a team name", nameValidator) );
		
		//game.output( player );
		
		Validator weeksValidator = new IntValidator(5, 15);
		// choose and set the number of weeks in the season.
		// ... uses a weeksValidator function
		game.weeks = game.ui("How many weeks will the season be?", weeksValidator, ReturnType.INT);
		
		// purchase the starting athletes in the team
		// ... use a shop class
		Shop shop = new Shop(); // Continue to use shop throughout the program
		shop.addSellable(new Athlete("John", 30, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John1", 31, new Stats(new int[] {7, 2, 6})));
		shop.addSellable(new Athlete("John2", 32, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John3", 33, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John4", 34, new Stats(new int[] {7, 2, 5})));
		shop.addSellable(new Athlete("John5", 35, new Stats(new int[] {7, 7, 1})));
		
		game.player.setMoney(5000);
		int choice;
		
		game.itemShop = new Shop();
		game.athleteShop = new Shop();
		game.resetShop(game.itemShop, game.athleteShop);
		
		game.matches = new Matches();
		game.resetMatches(game.matches, game.player);
		
		game.simulateShop( shop, game.player );
		
		
		// pick a difficulty
		Options difficultySettings = new Options(new String[] {"Easy", "Medium", "Hard"} );
		game.output("Pick a difficulty level", 69);
		game.difficulty = game.options(difficultySettings);
		
		// print rules
		game.output( game.rules() );
		
		game.startGame();
		
		// display end screen
		game.output("Stats");
		
		*/
		
	}
}




















