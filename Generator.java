import java.util.Random;

/**
 * The Generator class generates athlete names, item names and descriptions randomly.
 */
public class Generator {
	
	/** The rand. */
	private Random rand;
	
	/** The athlete names. */
	private String[] athleteNames;
	
	/** The item names. */
	private String[] itemNames;
	
	/** The item descs. */
	private String[] itemDescs;
	
	/**
	 * Instantiates a new generator.
	 *
	 * @param athleteNames the athlete names
	 * @param itemNames the item names
	 * @param itemDescs the item descs
	 */
	public Generator(String[] athleteNames, String[] itemNames, String[] itemDescs) {
		this.athleteNames = athleteNames;
		this.itemNames = itemNames;
		this.itemDescs = itemDescs;
		rand = new Random();
	}
	
	/** The team names 1. */
	private String[] teamNames1;
	
	/** The team names 2. */
	private String[] teamNames2;
	
	/** The team size. */
	private int teamSize;
	
	/** The field size. */
	private int fieldSize;
	
	/**
	 * Instantiates a new generator.
	 *
	 * @param athleteNames the athlete names
	 * @param teamNames1 the team names 1
	 * @param teamNames2 the team names 2
	 * @param teamSize the team size
	 * @param fieldSize the field size
	 */
	public Generator(String[] athleteNames, String[] teamNames1, String[] teamNames2, int teamSize, int fieldSize) {
		this.teamSize = teamSize;
		this.fieldSize = fieldSize;
		this.teamNames1 = teamNames1;
		this.teamNames2 = teamNames2;
		this.athleteNames = athleteNames;
		rand = new Random();
	}
	
	/**
	 * Generates a range
	 *
	 * @param a the a
	 * @param b the b
	 * @return the int
	 */
	private int range(int a, int b) {
		return this.rand.nextInt(b - a + 1) + a;
	}
	
	/**
	 * Generates a random Item object
	 *
	 * @return the item
	 */
	public Item item() {
		int index = this.rand.nextInt(this.itemNames.length);
		String name = this.itemNames[index];
		String desc = this.itemDescs[index];
		int price = this.range(5, 20)*10;
		return new Item(name, desc, new Stats(new int[] {this.range(0, 5), this.range(0, 5), this.range(0, 5)}), price, price - 10);
	}
	
	/**
	 * Generates a random Athlete object with default attributes
	 *
	 * @return the athlete
	 */
	public Athlete athlete() {
		int index = this.rand.nextInt(this.athleteNames.length);
		String name = this.athleteNames[index];
		int total = 12;
		int a = this.range(1, 5);
		int b = this.range(1, 10 - a);
		int c = total - a - b;
		return new Athlete(name, this.range(18, this.range(18, 96)), new Stats(new int[] {a, b, c}));
	}
	
	/**
	 * Generates an athlete with the specified level
	 *
	 * @param level the level of the athlete that indicates their overall skill
	 * @return the new athlete
	 */
	public Athlete athlete(int level) {
		int index = this.rand.nextInt(this.athleteNames.length);
		String name = this.athleteNames[index];
		int total = level;
		int a = this.range(this.range(1, level/3), level/3);
		int b = this.range(this.range(1, 2*level/3 - a), 2*level/3 - a);
		int c = total - a - b;
		return new Athlete(name, this.range(18, this.range(18, 96)), new Stats(new int[] {a, b, c}));
	}
	
	/**
	 * Generates a team with the specified number of athletes, difficulty level, and week.
	 *
	 * @param count the number of athletes in the team
	 * @param difficulty the difficulty level
	 * @param week the current week
	 * @return A new Team that has been randomly generated
	 */
	public Team team(int count, int difficulty, int week) {
		int index1 = this.rand.nextInt(this.teamNames1.length);
		int index2 = this.rand.nextInt(this.teamNames2.length);
		String name = this.teamNames1[index1] + " " + this.teamNames2[index2];
		Team team = new Team(name, this.teamSize, this.fieldSize);
		for (int i = 0; i < count; i++) {
			team.addAthlete( this.athlete(12 + difficulty * week) );
		}
		return team;
	}
}
