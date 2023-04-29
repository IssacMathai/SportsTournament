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
        Team player = new Team( game.ui("Choose a team name", nameValidator) );
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
        
        // pick a difficulty
        Options difficultySettings = new Options(new String[] {"Easy", "Medium", "Hard"} );
        game.output("Pick a difficulty level");
        int difficulty = game.options(difficultySettings);
        
        // print rules
        game.output( game.rules() );
        
        // updated (testing can upload to glitch?)
    }
}




















