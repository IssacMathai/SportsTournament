import java.util.Random;
public class Generator {
	private String[] athleteNames;
	private String[] itemNames;
	private String[] itemDescs;
	private Random rand;
	public Generator(String[] athleteNames, String[] itemNames, String[] itemDescs) {
		this.athleteNames = athleteNames;
		this.itemNames = itemNames;
		this.itemDescs = itemDescs;
		rand = new Random();
	}
	private int range(int a, int b) {
		return this.rand.nextInt(b - a + 1) + a;
	}
	public Item item() {
		int index = this.rand.nextInt(itemNames.length);
		String name = this.itemNames[index];
		String desc = this.itemDescs[index];
		int price = this.range(5, 20)*10;
		return new Item(name, desc, new Stats(new int[] {this.range(0, 5), this.range(0, 5), this.range(0, 5)}), price, price - 10);
	}
	public Athlete athlete() {
		int index = this.rand.nextInt(athleteNames.length);
		String name = this.athleteNames[index];
		int total = 12;
		int a = this.range(1, 5);
		int b = this.range(1, 5);
		int c = total - a - b;
		return new Athlete(name, this.range(18, this.range(18, 96)), new Stats(new int[] {a, b, c}));
	}
}