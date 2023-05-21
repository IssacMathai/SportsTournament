import java.util.Scanner;
import java.util.ArrayList;
import java.awt.EventQueue;
import java.awt.event.*;
import java.util.concurrent.CountDownLatch;
import javax.swing.SwingUtilities;
import java.util.Random;
/**
 * The main game environment class.
 *
 */
public class Game {
	
	/** The team size. */
	public final int teamSize = 10;
	
	/** The field size. */
	public final int fieldSize = 5;
	
	/**
	 * The rules of the game.
	 *
	 * @return the string
	 */
	public String rules() {
		String nl = "<br>";
		return "<html><a style='color:#555;'><h3 style='text-align:center;'>Rules</h3>"+nl+

"The goal of Axe Masters is to lead your team to victory this Axe Throwing season. After building your team, you may visit the Club, or visit the Market to purchase Athletes or Items."+nl+

"The Club allows management of team members, reserves and inventory."+nl+

"The Stadium allows your team to play up to 3 matches a week, provided your team is full and contains at least 1 non-injured player. Each of the three matches available may only be played once."+nl+

"During a Match, athletes in opposing teams face off in pairs based on their positions and compare stats. The three stats, accuracy, evasion and speed are compared in order to determine the winner. If the athlete loses a face off, they will lose more stamina than if they had won. Once an Athlete’s stamina reaches 0, they are injured. If an Athlete in a face off is already injured, they instantly lose the face off."+nl+

"The team with the higher score wins, rewarding money and points."+nl+

"The Market allows you to draft new Athletes or purchase Items that, when used, provide stat boosts to team members."+nl+

"When you are ready, you may ‘take a bye’ to move to the next week and select an Athlete to train. All matches in the Stadium, along with the Athletes and Items in the Market will be updated. In addition, the stamina of all Athletes are fully replenished and random events concerning the team may occur.</a></html>";
	}
	
	/**
	 * Sends a feedback message
	 *
	 * @param string the feedback message
	 */
	public void feedback(String string) {
		this.output("[!] " + string);
	}
	
	/** The last output. */
	public String lastOutput = "";
	
	/** The prev outputs. */
	public ArrayList<String> prevOutputs = new ArrayList<String>();
	
	/**
	 * Outputs a string and updates the display.
	 *
	 * @param string the string to be outputted
	 */
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
	
	/**
	 * Outputs a string and updates the display
	 *
	 * @param string the output string
	 * @param yeeet an integer value
	 */
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
	
	/**
	 * Displays a message and receives user input
	 *
	 * @param message the message to be displayed
	 * @param v the validator object used for input validation
	 * @return user input as a string
	 */
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
	
	/**
	 * Displays a message and receives user input as an integer
	 *
	 * @param message display message
	 * @param v the validator object used for input validation
	 * @param type  the return type for the input value
	 * @return the user input as an integer
	 */
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
	
	/** The last choice. */
	private int lastChoice;
	
	/** The last options. */
	private Options lastOptions;
	
	/** The last input. */
	public String lastInput;
	
	/**
	 * Displays a set of options and returns the selected option as an integer
	 *
	 * @param options the displayed options
	 * @return choice the selected option as an integer
	 */
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
	
	/**
	 * Checks if the last selected option is the first option
	 *
	 * @return true if true
	 */
	public boolean first() {
		return this.lastChoice == this.lastOptions.first();
	}
	
	/**
	 * Checks if the last selected option is the first option plus the specified index
	 *
	 * @param index the index to be added to the first option
	 * @return true, if true
	 */
	public boolean first(int index) {
		return this.lastChoice == this.lastOptions.first() + index;
	}
	
	/**
	 * Checks if the last selected option is the last option.
	 *
	 * @return true, if true
	 */
	public boolean last() {
		return this.lastChoice == this.lastOptions.last();
	}
	
	/** The Constant teamNames1. */
	private static final String[] teamNames1 =   {"Diamond", "Rusty", "Maccas", "Sweaty", "Amber", "Old", "Burger", "Smelly", "Crystal", "Math", "Meth", "Cocaine", "Nerdy", "Handy", "Sharp", "Blunt", "Shiney", "Ancient", "Greasy", "Moist", "Precious", "Decayed", "Fries", "Sticky", "Gleemin", "Dry", "Big Mac", "Soggy", "Bloody", "Grubby"};
	
	/** The Constant teamNames2. */
	private static final String[] teamNames2 =   {"Dogs", "Cows", "Addicts", "Bois", "Cats", "Horses", "Butts", "Dudes", "Meet", "Moo", "Beef", "Guys", "Canines", "Nerds", "Junkies", "Fellas", "Targets", "Axes", "Gamerz", "Bros", "Pets", "Bull", "Lovers", "Addicts", "Gents", "Cutters", "Herds", "Freaks", "Homies", "Daddys"};
	
	/** The Constant athleteNames. */
	private static final String[] athleteNames = {"John", "Andy", "Ben", "George Harrison", "Mike", "Dwight", "Jack", "Joe", "Snape", "Taki", "Robert", "Steve", "Dave", "Paul", "Ringo", "Charlie", "James", "Tony", "Sam", "Frank", "Harry", "Tom", "William", "Peter", "Alex", "Oliver", "Daniel", "Eric", "Richard", "Brian"};
	
	/** The Constant itemNames. */
	private static final String[] itemNames =    {"Target", "Axe", "Gloves", "Board", "Bullseye", "Helmet", "Guard", "Mat", "Rack", "Log", "Stand", "Patch", "Sticker", "Case", "Sharpener", "Guide", "Marker", "Line", "Hammer", "Tape", "Chalk", "Strap", "Tee", "Shirt", "Bag", "Net", "Bar", "Wheel", "Timer", "Arm"};
	
	/** The Constant itemDescs. */
	private static final String[] itemDescs =    {"Aims and measures accuracy.", "Thrown to hit the target.", "Provides hand protection.", "Surface for axe throwing.", "Center of the target.", "Ensures head safety.", "Protects against accidents.", "Provides grip and stability.", "Stores axes conveniently.", "The target for axe throwing.", "Holds the target board.", "Badge for achievement.", "Marks the bullseye.", "Carries axes securely.", "Maintains axe edge.", "Offers throwing tips.", "Indicates hit location.", "Marks throwing distance.", "Sets up the target.", "Measures throwing line.", "Marks score and lines.", "Secures equipment.", "Axe resting platform.", "Displays team affiliation.", "Carries equipment easily.", "Catches and stops axes.", "Protects against ricochets.", "Provides extra grip.", "Keeps score and stats.", "Enhances throwing technique.", "Records throwing data."};
	
	/**
	 * Resets the item shop and athlete shop.
	 *
	 * @param itemShop the item shop
	 * @param athleteShop the athlete shop
	 */
	public void resetShop(Shop itemShop, Shop athleteShop) {
		itemShop.clear();
		athleteShop.clear();
		
		Generator gen = new Generator(this.athleteNames, this.itemNames, this.itemDescs);
		
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
	
	/**
	 * Resets the matches for the specified player and week.
	 *
	 * @param matches the matches
	 * @param player the player's team
	 * @param week the week
	 */
	public void resetMatches(Matches matches, Team player, int week) {
		Team opponent;
		
		matches.clear();
		
		Generator gen = new Generator(this.athleteNames, this.teamNames1, this.teamNames2, this.teamSize, this.fieldSize);
		
		opponent = gen.team( this.fieldSize, this.difficulty, week );
		matches.add( new Match(player, opponent, this.fieldSize) );
		
		opponent = gen.team( this.fieldSize, this.difficulty, week );
		matches.add( new Match(player, opponent, this.fieldSize) );
		
		opponent = gen.team( this.fieldSize, this.difficulty, week );
		matches.add( new Match(player, opponent, this.fieldSize) );
	}
	
	/**
	 * Simulates the shopping process for the specified shop and player.
	 *
	 * @param shop the shop
	 * @param player the player
	 */
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
					this.launchFeedbackScreen("Purchase Successful! <br>" + bought);
				}
			} catch (Exception e) {
				String reason = e.getMessage();
				this.output("Purchase Unsuccessful... <br>" + reason);
				this.launchFeedbackScreen("Purchase Unsuccessful... " + reason);
			}
		}
	}
	
	/**
	 * Simulates the selling process for the specified player's inventory.
	 *
	 * @param player the player's team
	 */
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
	
	/**
	 * Simulates the drafting process for the specified player's team.
	 *
	 * @param player the player
	 */
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
	
	/**
	 * Simulates the club activities for the specified player.
	 *
	 * @param player the player's team
	 */
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
	
	/**
	 * Simulates the stadium activities for the specified matches.
	 *
	 * @param matches the matches
	 */
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
				if ( matches.canPlay( choice ) ) {
					Match match = matches.playMatch( choice ); // uses up the match
					if (match.result() == 1) { // reward player
						int amount = (2 - this.difficulty) * 100;
						String[] diffText = new String[] {"easy", "medium", "hard"};
						this.player.getMoney().change(amount);
						this.points += this.difficulty + 1;
						this.launchFeedbackScreen( "" + match.getResult() + "<br><a style='color:#999;'><i>Reward $" + amount + " for " + diffText[this.difficulty] + " mode.<br>+" + (this.difficulty+1) + " points</i></a>" );
					} else {
						this.launchFeedbackScreen( "" + match.getResult() + "" );
					}
					//this.output( match.getResults() );
				} else {
					this.launchFeedbackScreen( "You need " + this.fieldSize + " athletes to play this match" );
				}
			}
		}
	}
	
	/**
	 * Go to shop.
	 *
	 * @param itemShop the item shop
	 * @param athleteShop the athlete shop
	 * @param player the player
	 */
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
	
	/**
	 * Close setup screen.
	 *
	 * @param window the window
	 */
	public void closeSetupScreen(SetupScreen window) {
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	/**
	 * Close options screen.
	 *
	 * @param window the window
	 * @param choice the choice
	 */
	public void closeOptionsScreen(OptionsScreen window, int choice) {
		this.lastChoice = choice;
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	/**
	 * Close feedback screen.
	 *
	 * @param window the window
	 */
	public void closeFeedbackScreen(FeedbackScreen window) {
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	/**
	 * Close input screen.
	 *
	 * @param window the window
	 * @param string the string
	 */
	public void closeInputScreen(InputScreen window, String string) {
		this.lastInput = string;
		window.closeWindow();
		//this.launchMainScreen();
	}
	
	/**
	 * Launch setup screen.
	 */
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
	
	/**
	 * Launch options screen.
	 *
	 * @param options the options
	 * @param text the text
	 * @return the int
	 */
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
	
	/**
	 * Launch options screen.
	 *
	 * @param options the options
	 * @return the int
	 */
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
	
	/**
	 * Launch feedback screen.
	 *
	 * @param text the text
	 */
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
	
	/**
	 * Launch input screen.
	 *
	 * @param text the text
	 * @param def the def
	 * @param v the v
	 * @return the string
	 */
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
	
	/**
	 * Runs the game.
	 *
	 * @param player the player
	 * @param weeks the weeks
	 * @param difficulty the difficulty
	 * @param itemShop the item shop
	 * @param athleteShop the athlete shop
	 * @param matches the matches
	 */
	public void simulateGame(Team player, int weeks, int difficulty, Shop itemShop, Shop athleteShop, Matches matches) {
		this.output("inside simulate game " + weeks);
		//this.options(new Options(new String[] {"hiya", "yooo"}));
		// for week in weeks
		for (int week = 1; week <= weeks; week++) {
			// (0) print game stats (including player.stats (which returns money)) (money, current week, and weeks remaining)
			boolean finalWeek = false;
			if (week == weeks) {
				finalWeek = true;
			}
			boolean inWeek = true; // is set to false when a bye is taken
			while (inWeek) {
				if (finalWeek) {
					this.output("Final Week", 69);
				} else {
					this.output("Week " + week + " / " + weeks, 69);
				}
				Options actions = new Options(new String[] {"Manage your team at the clubs", "Play Matches", "Go to the shop", "Take a Bye" + " (move to the next week)"} ); //move to the next week (as long as it aint the last week)
				if (finalWeek) {
					actions.options()[actions.last()] = "Finish Season";
				} 
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
					if (finalWeek) {
						break;
					}
					// take a bye
					// reset stamina
					this.player.resetStamina();
					// train athlete
					Options trainOptions = new Options( player.getAthletesAsSellables() ).join( "Skip" );
					trainOptions.setText("Train"); // BUTTON TEXT
					this.output("Choose an athlete to train over your bye", 69);
					this.output("<a style='color:#999;'><i>all athletes Stamina has been reset.</i></a>");
					int athleteChoice = this.options(trainOptions);
					Item train = new Item("Train", "increases all stats", new Stats(new int[] {1, 1, 1}), 0, 0);
					if (! this.last() ) {
						player.getAthlete(athleteChoice).useItem(train);
						this.launchFeedbackScreen("+1 stats on " + player.getAthlete(athleteChoice).getName());
					}
					// random events
					
					Random rand = new Random();
					int number = rand.nextInt(100) + 1; // 1 - 100
					int level = (this.difficulty + 1)*30; // either 30, 60, or 90
					if (number < level) {
						if (this.player.teamCount() == 0) { // higher chance a new athlete joins if team is empty
							Generator gen = new Generator(this.athleteNames, this.itemNames, this.itemDescs);
							Athlete a = gen.athlete();
							if (this.player.addAthlete(a)) {
								this.launchFeedbackScreen("A Random Event happened...<br>" + a + "<br>joined the team!");
							}
						} else { // athlete might quit, join, or have a stat boost
							if (rand.nextInt(2) == 0) { // quits
								int athleteIndex = rand.nextInt(this.player.teamCount());
								Athlete a = this.player.removeAthlete(athleteIndex);
								String[] reasons = {"they got hit by an axe", "they weren't getting paid", "they didn't like you", "you worked them way too hard", "they got a better offer somewhere else", "their grandma died", "their 'friend' got pregnant", "they realised you didn't know how to manage a team"};
								String reason = reasons[rand.nextInt(reasons.length)];
								if (this.player.getMoney().get() > 0 && rand.nextInt(3) == 0) { // chance they steal your money
									reason += ", and they took all your money with them <a style='color:#999;'><i>-$" + this.player.getMoney().get() + "</i></a>)";
									this.player.getMoney().set(0);
								}
								this.launchFeedbackScreen("A Random Event happened... <br>" + a + "<br>quit the team because " + reason + ".");
								
							} else { // chance an athlete joins if there is space
								Generator gen = new Generator(this.athleteNames, this.itemNames, this.itemDescs);
								Athlete a = gen.athlete();
								if (this.player.addAthlete(a)) {
									this.launchFeedbackScreen("A Random Event happened...<br>" + a + "<br>joined the team!");
								}
							}
						}
					}
					
					// update classes
					this.resetShop(itemShop, athleteShop);
					this.resetMatches(matches, player, week);
					inWeek = false;
					continue;
				}
			}
		}
		this.launchFeedbackScreen("Game Over!<br>Points Earned: " + this.points);
	}
	
	
	/** The player. */
	// game variables
	public Team player;
	
	/** The item shop. */
	public Shop itemShop;
	
	/** The athlete shop. */
	public Shop athleteShop;
	
	/** The weeks. */
	public int weeks = 5;
	
	/** The difficulty. */
	public int difficulty;
	
	/** The matches. */
	public Matches matches;
	
	/** The points. */
	public int points = 0;
	
	/**
	 * Start game.
	 */
	public void startGame() {
		// purchase the starting athletes in the team
		// ... use a shop class
		
		// pick a difficulty
		Options difficultySettings = new Options(new String[] {"Easy", "Medium", "Hard"} );
		this.output("Pick a difficulty level", 69);
		this.output("<html><a style='color:#999;'><i>affects start money, matches, shop items, and random events</i></a></html>");
		this.difficulty = this.options(difficultySettings);
		
		Shop shop = new Shop(); // Continue to use shop throughout the program
		Generator gen = new Generator(athleteNames, itemNames, itemDescs);
		
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		shop.addSellable(gen.athlete());
		
		this.player.setMoney(1000 - this.difficulty * 250);
		int choice;
		
		this.itemShop = new Shop();
		this.athleteShop = new Shop();
		this.resetShop(this.itemShop, this.athleteShop);
		
		this.matches = new Matches();
		this.resetMatches(this.matches, this.player, 1);
		
		this.simulateShop( shop, this.player );
		
		// print rules
		//this.output( this.rules() );
		
		simulateGame(this.player, this.weeks, this.difficulty, this.itemShop, this.athleteShop, this.matches);
	}
	
	/**
	 * The main method to start the game
	 *
	 * @param args the arguments
	 */
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




















