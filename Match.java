/**
 * This class implements a Match. In a match, the friendly team competes against the enemy team.
 * By the end of the match, the athletes in each team will have reduced stamina and some will be injured.
 */
public class Match {
    /**
     * The friendly Team
     */
    private Team friendlyTeam;
    /**
     * The enemy Team
     */
    private Team enemyTeam;
    /**
     * The friendly Team's score
     */
    private int friendlyScore;
    /**
     * The enemy Team's score
     */
    private int enemyScore;

    /**
     * Whether the player's team won or not
     */
    private boolean isFriendlyWin;
    /**
     * Whether the match was a tie or not
     */
    private boolean isTie;

    public Match(Team friendlyTeam, Team enemyTeam) {
        this.friendlyTeam = friendlyTeam;
        this.enemyTeam = enemyTeam;
        System.out.println(friendlyTeam.getName() + " vs " + enemyTeam.getName());
        System.out.println("Athletes 1-3 compete on offense");
        System.out.println("Athletes 4-5 compete on defense");
        offensePlayoff();
        defensePlayoff();
        result();
    }

    /**
     * The offense playoff. Here, athletes 1 to 3 compete based on their offense stats.
     * The winning athlete of the playoff loses less stamina than the losing athlete.
     * Whichever team wins a playoff gains a point.
     * If the playoff is a draw, no points are awarded.
     */
    public void offensePlayoff() {
        int playerNumber = 0;
        while (playerNumber < 3) {
            Athlete currentFriendlyAthlete = friendlyTeam.getAthlete(playerNumber);
            Athlete currentEnemyAthlete = enemyTeam.getAthlete(playerNumber);

            // If either player is injured, begin the injury playoff.
            if (currentFriendlyAthlete.getIsInjured() || currentEnemyAthlete.getIsInjured()) {
                injuryPlayoff(currentFriendlyAthlete, currentEnemyAthlete);
                playerNumber += 1;
                continue;
            }

            if (currentFriendlyAthlete.getOffence() > currentEnemyAthlete.getOffence()) {
                friendlyScore += 1;
                currentFriendlyAthlete.setStamina(currentFriendlyAthlete.getStamina() - 25);
                currentEnemyAthlete.setStamina(currentEnemyAthlete.getStamina() - 50);
            } else if (currentFriendlyAthlete.getOffence() < currentEnemyAthlete.getOffence()) {
                enemyScore += 1;
                currentEnemyAthlete.setStamina(currentEnemyAthlete.getStamina() - 25);
                currentFriendlyAthlete.setStamina(currentFriendlyAthlete.getStamina() - 50);
            } else {
                currentFriendlyAthlete.setStamina(currentFriendlyAthlete.getStamina() - 25);
                currentEnemyAthlete.setStamina(currentEnemyAthlete.getStamina() - 25);
            }
            playerNumber += 1;
        }
    }

    /**
     * The defense playoff. Here, athletes 1 to 3 compete based on their defense stats.
     * The winning athlete of the playoff loses less stamina than the losing athlete.
     * Whichever team wins a playoff gains a point.
     * If the playoff is a draw, no points are awarded.
     */
    public void defensePlayoff() {
        int playerNumber = 3;
        while (playerNumber < 5) {
            Athlete currentFriendlyAthlete = friendlyTeam.getAthlete(playerNumber);
            Athlete currentEnemyAthlete = enemyTeam.getAthlete(playerNumber);

            // If either player is injured, begin the injury playoff.
            if (currentFriendlyAthlete.getIsInjured() || currentEnemyAthlete.getIsInjured()) {
                injuryPlayoff(currentFriendlyAthlete, currentEnemyAthlete);
                playerNumber += 1;
                continue;
            }

            if (currentFriendlyAthlete.getDefence() > currentEnemyAthlete.getDefence()) {
                friendlyScore += 1;
                currentFriendlyAthlete.setStamina(currentFriendlyAthlete.getStamina() - 25);
                currentEnemyAthlete.setStamina(currentEnemyAthlete.getStamina() - 50);
            } else if (currentFriendlyAthlete.getDefence() < currentEnemyAthlete.getDefence()) {
                enemyScore += 1;
                currentEnemyAthlete.setStamina(currentEnemyAthlete.getStamina() - 25);
                currentFriendlyAthlete.setStamina(currentFriendlyAthlete.getStamina() - 50);
            } else {
                currentFriendlyAthlete.setStamina(currentFriendlyAthlete.getStamina() - 25);
                currentEnemyAthlete.setStamina(currentEnemyAthlete.getStamina() - 25);
            }
            playerNumber += 1;
        }
    }


    /**
     * The injury playoff. This begins if either of the athletes competing against each other is injured.
     * If a team's player is injured, the opposing team wins the playoff and gains a point.
     * If both teams' players are injured, then no points are awarded.
     * @param currentFriendlyAthlete    The current friendly athlete competing
     * @param currentEnemyAthlete       The current enemy athlete competing
     */
    public void injuryPlayoff(Athlete currentFriendlyAthlete, Athlete currentEnemyAthlete) {
        if (currentFriendlyAthlete.getIsInjured() && !currentEnemyAthlete.getIsInjured()) {
            enemyScore += 1;
        } else if (!currentFriendlyAthlete.getIsInjured() && currentEnemyAthlete.getIsInjured()) {
            friendlyScore += 1;
        }
    }

    /**
     * The match summary. Here, the final scores are read and the winning team is announced.
     * The post match status of both teams are displayed.
     * The boolean properties isFriendlyWin and isTie are also set here.
     */
    public void result() {
        System.out.println("\nThe final score is:");
        System.out.println(friendlyTeam.getName() + ": " + friendlyScore);
        System.out.println(enemyTeam.getName() + ": " + enemyScore);
        if (friendlyScore > enemyScore) {
            System.out.println("\n" + friendlyTeam.getName() + " are the winners!\n");
            isFriendlyWin = true;
            isTie = false;
        } else if (friendlyScore < enemyScore) {
            System.out.println("\n" + enemyTeam.getName() + " are the winners!\n");
            isFriendlyWin = false;
            isTie = false;
        } else {
            System.out.println("It's a draw!\n");
            isFriendlyWin = false;
            isTie = true;
        }

        System.out.println(friendlyTeam.getName() + " Status:");
        System.out.println(friendlyTeam);

        System.out.println("\n" + enemyTeam.getName() + " Status:");
        System.out.println(enemyTeam);

    }

    /**
     * Returns whether the match was a tie or not
     * @return tie
     */
    public boolean getIsTie() {
        return isTie;
    }

    /**
     * Returns whether the friendly team won or not
     * @return friendlyWin
     */
    public boolean getIsFriendlyWin() {
        return isFriendlyWin;
    }

    public static void main(String[] args) {
        Team a = new Team("Diamond Dogs");
        Athlete joe = new Athlete("Joe", 20, 80, 80);
        joe.setStamina(0);
        Athlete james = new Athlete("James", 21, 80, 80);
        Athlete john = new Athlete("John", 22, 80, 80);
        Athlete jock = new Athlete("Jock", 22, 80, 10);
        Athlete jordan = new Athlete("Jordan", 22, 80, 10);
        a.addAthlete(joe);
        a.addAthlete(james);
        a.addAthlete(john);
        a.addAthlete(jock);
        a.addAthlete(jordan);

        Team b = new Team("Cipher");
        Athlete peter = new Athlete("Peter", 20, 80, 20);
        peter.setStamina(0);
        Athlete paul = new Athlete("Paul", 20, 20, 20);
        Athlete patrick = new Athlete("Patrick", 20, 20, 20);
        Athlete phoenix = new Athlete("Phoenix", 20, 20, 20);
        //phoenix.setStamina(0);
        Athlete piper = new Athlete("Piper", 20, 20, 20);
        b.addAthlete(peter);
        b.addAthlete(paul);
        b.addAthlete(patrick);
        b.addAthlete(phoenix);
        b.addAthlete(piper);

        Match m = new Match(a, b);
    }
}
