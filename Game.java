import java.util.Scanner;

public class Game {
	public void output(Object string) {
		System.out.println(string);
	}
	public void feedback(String string) {
		this.output("[!] " + string);
	}
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
	public static void main(String[] args) {
		Game game = new Game();
		
		Validator nameValidator = new NameValidator(3, 15);
		
		game.output("You typed " + game.ui("Type something", nameValidator));
		
		//Validator weeksValidator = new NameValidator(3, 15);
		
		//game.output("You typed " + game.ui("Type something", weeksValidator));
	}
}
