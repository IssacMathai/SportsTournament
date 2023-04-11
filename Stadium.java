import java.util.Scanner;

/**
 * This class implements the Stadium. The stadium contains the player's team along with 3 different enemy teams.
 * The player can select matches to play, with each match corresponding to the enemy team they will be facing.
 * The player may only play each match once, provided their team is full and not all their athletes are injured.
 */
public class Stadium {
    /**
     * The player's team
     */
    private Team friendlyTeam;
    /**
     * The first enemy team
     */
    private Team enemyTeam1;
    /**
     * The second enemy team
     */
    private Team enemyTeam2;
    /**
     * The third enemy team
     */
    private Team enemyTeam3;
    /**
     * Whether the first match has been played already
     */
    private boolean hasPlayed1;
    /**
     * Whether the second match has been played already
     */
    private boolean hasPlayed2;
    /**
     * Whether the third match has been played already
     */
    private boolean hasPlayed3;


    public Stadium(Team friendlyTeam, Team enemy1, Team enemy2, Team enemy3) {
        this.friendlyTeam = friendlyTeam;
        enemyTeam1 = enemy1;        // The idea is to randomly generate enemy teams for the week, then pass them into
        enemyTeam2 = enemy2;        // the stadium class.
        enemyTeam3 = enemy3;
        hasPlayed1 = false;         // If one instance of Stadium exists per week, then Stadium should only be
        hasPlayed2 = false;         // constructed once and so hasPlayed should not reset if the player exits the
        hasPlayed3 = false;         // stadium and reenters it (in the same week).
    }

    /**
     * Gets user input
     *
     * @return user input integer
     */
    public int getUserInput() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    /**
     * Prompts the user to decide what they want to do in the Stadium.
     */
    public void userPrompt() {
        System.out.println("\nWelcome to the stadium. To select a match to play, please input the corresponding number.");
        System.out.println("1: " + enemyTeam1.getName());
        System.out.println("2: " + enemyTeam2.getName());
        System.out.println("3: " + enemyTeam3.getName());
        System.out.println("\nTo leave, input 4.");

        int input = getUserInput();
        if (input == 1) {
            if (canPlay(hasPlayed1)) {
                Match m1 = new Match(friendlyTeam, enemyTeam1);
                hasPlayed1 = true;
                outcome(m1);
                userPrompt();
            } else {
                userPrompt();
            }
        } else if (input == 2) {
            if (canPlay(hasPlayed2)) {
                Match m2 = new Match(friendlyTeam, enemyTeam2);
                hasPlayed2 = true;
                outcome(m2);
                userPrompt();
            } else {
                userPrompt();
            }
        } else if (input == 3) {
            if (canPlay(hasPlayed3)) {
                Match m3 = new Match(friendlyTeam, enemyTeam3);
                hasPlayed3 = true;
                outcome(m3);
                userPrompt();
            } else {
                userPrompt();
            }
        } else if (input == 4) {
            System.out.println("You are leaving the stadium.");
        }
    }

    /**
     * Checks if the player meets the conditions to play a match.
     *
     * @param hasPlayed passes in the match's corresponding hasPlayed property
     * @return boolean
     */
    public boolean canPlay(boolean hasPlayed) {
        if (friendlyTeam.getTeamCount() < 5) {
            System.out.println(friendlyTeam.getName() + " must have 5 athletes in order to play.");
            return false;
        }
        if (friendlyTeam.isAllInjured()) {
            System.out.println("Cannot play this match as " + friendlyTeam.getName() + "'s players are all injured.");
            return false;
        }
        if (hasPlayed) {
            System.out.println("You have already played this match.");
            return false;
        }
        return true;
    }

    /**
     * Prints a message depending on the outcome of the match.
     *
     * @param m passes in the match that the player has just played.
     */
    public void outcome(Match m) {
        if (m.getIsTie()) {
            System.out.println("\nDraw. Some points and money awarded.");
        } else if (m.getIsFriendlyWin()) {
            System.out.println("\n" + friendlyTeam.getName() + " have won! Points and money awarded.");
        } else {
            System.out.println("\n" + friendlyTeam.getName() + " have lost. No points or money awarded.");
        }
    }

    public static void main(String[] args) {
        Team a = new Team("Diamond Dogs");
        Athlete joe = new Athlete("Joe", 20, 20, 20);
        //joe.setStamina(0);
        Athlete james = new Athlete("James", 21, 20, 20);
        //james.setStamina(0);
        Athlete john = new Athlete("John", 22, 20, 20);
        //john.setStamina(0);
        Athlete jock = new Athlete("Jock", 22, 20, 20);
        //jock.setStamina(0);
        Athlete jordan = new Athlete("Jordan", 22, 20, 20);
        //jordan.setStamina(0);
        a.addAthlete(joe);
        a.addAthlete(james);
        a.addAthlete(john);
        a.addAthlete(jock);
        a.addAthlete(jordan);

        Team b = new Team("Cipher");
        Athlete peter = new Athlete("Peter", 20, 100, 20);
        Athlete paul = new Athlete("Paul", 20, 100, 20);
        Athlete patrick = new Athlete("Patrick", 20, 100, 20);
        Athlete phoenix = new Athlete("Phoenix", 20, 20, 20);
        Athlete piper = new Athlete("Piper", 20, 20, 20);
        b.addAthlete(peter);
        b.addAthlete(paul);
        b.addAthlete(patrick);
        b.addAthlete(phoenix);
        b.addAthlete(piper);

        Team c = new Team("Pirates");
        Athlete al = new Athlete("Al", 20, 20, 20);
        Athlete be = new Athlete("Be", 20, 20, 20);
        Athlete cd = new Athlete("Cd", 20, 20, 20);
        Athlete ef = new Athlete("Ef", 20, 20, 20);
        Athlete gh = new Athlete("Gh", 20, 20, 20);
        c.addAthlete(al);
        c.addAthlete(be);
        c.addAthlete(cd);
        c.addAthlete(ef);
        c.addAthlete(gh);

        Team d = new Team("Goblins");
        Athlete zz = new Athlete("ZZ", 20, 10, 20);
        Athlete yy = new Athlete("YY", 20, 10, 20);
        Athlete xx = new Athlete("XX", 20, 10, 20);
        Athlete ww = new Athlete("WW", 20, 20, 10);
        Athlete vv = new Athlete("VV", 20, 20, 10);
        d.addAthlete(zz);
        d.addAthlete(yy);
        d.addAthlete(xx);
        d.addAthlete(ww);
        d.addAthlete(vv);

        Stadium s = new Stadium(a, b, c, d);
        s.userPrompt();
    }


}
