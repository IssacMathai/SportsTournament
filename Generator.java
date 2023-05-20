import java.util.Random;
public class Generator {
	private Random rand;
	private String[] athleteNames;
	private String[] itemNames;
	private String[] itemDescs;
	public Generator(String[] athleteNames, String[] itemNames, String[] itemDescs) {
		this.athleteNames = athleteNames;
		this.itemNames = itemNames;
		this.itemDescs = itemDescs;
		rand = new Random();
	}
	private String[] teamNames1;
	private String[] teamNames2;
	private int teamSize;
	private int fieldSize;
	public Generator(String[] athleteNames, String[] teamNames1, String[] teamNames2, int teamSize, int fieldSize) {
		this.teamSize = teamSize;
		this.fieldSize = fieldSize;
		this.teamNames1 = teamNames1;
		this.teamNames2 = teamNames2;
		this.athleteNames = athleteNames;
		rand = new Random();
	}
	private int range(int a, int b) {
		return this.rand.nextInt(b - a + 1) + a;
	}
	public Item item() {
		int index = this.rand.nextInt(this.itemNames.length);
		String name = this.itemNames[index];
		String desc = this.itemDescs[index];
		int price = this.range(5, 20)*10;
		return new Item(name, desc, new Stats(new int[] {this.range(0, 5), this.range(0, 5), this.range(0, 5)}), price, price - 10);
	}
	public Athlete athlete() {
		int index = this.rand.nextInt(this.athleteNames.length);
		String name = this.athleteNames[index];
		int total = 12;
		int a = this.range(1, 5);
		int b = this.range(1, 10 - a);
		int c = total - a - b;
		return new Athlete(name, this.range(18, this.range(18, 96)), new Stats(new int[] {a, b, c}));
	}
	public Athlete athlete(int level) {
		int index = this.rand.nextInt(this.athleteNames.length);
		String name = this.athleteNames[index];
		int total = level;
		int a = this.range(this.range(1, level/3), level/3);
		int b = this.range(this.range(1, 2*level/3 - a), 2*level/3 - a);
		int c = total - a - b;
		return new Athlete(name, this.range(18, this.range(18, 96)), new Stats(new int[] {a, b, c}));
	}
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