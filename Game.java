import java.util.Scanner;

public class Game {
	public void output(Object string) {
		System.out.println(string);
	}
	public void feedback(String string) {
		this.output("[!] " + string);
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
	public static void main(String[] args) {
		Game game = new Game();
		
		Validator nameValidator = new NameValidator(3, 15);
		
		Team player = new Team( game.ui("Choose a team name", nameValidator) );
		
		game.output( player );
		
		Validator weeksValidator = new WeeksValidator(5, 15);
		
		game.output("You typed " + game.ui("How many weeks should the season last for?", weeksValidator, ReturnType.INT));
	}
}




















