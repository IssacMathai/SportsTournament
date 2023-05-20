/**
 * This class implements an Athlete. Athletes have their own name and stats.
 */

public class Athlete implements Sellable {
	/**
	 * Name of the Athlete
	 */
	private String name;
	/**
	 * Age of the Athlete
	 */
	private int age;
	/**
	 * Offence stat of the Athlete
	 */
	private Stats stats;
	private int stamina;

	public Athlete(String name, int age) {
		this.name = name;
		this.age = age;
		this.stats = new Stats(new int[] {0, 0, 0});
		this.stamina = 100;
	}
	public Athlete(String name, int age, Stats stats) {
		this.name = name;
		this.age = age;
		this.stats = stats;
		this.stamina = 100;
	}

	/**
	 * Returns name of the Athlete
	 *
	 * @return name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Returns Age of the Athlete
	 *
	 * @return age
	 */
	public int getAge() {
		return this.age;
	}

	/**
	 * Returns injury status of the Athlete
	 *
	 * @return isInjured
	 */
	public boolean isInjured() {
		return this.stamina <= 0;
	}

	/**
	 * Returns stats of the Athlete
	 *
	 * @return stats
	 */
	public Stats getStats() {
		return this.stats;
	}

	/**
	 * Returns current stamina stat of the Athlete
	 *
	 * @return stamina
	 */
	public int getStamina() {
		return this.stamina;
	}
	
	public void bought() {
		// does nothing
	}
	
	/**
	 * Sets a nickname for the Athlete
	 *
	 * @param name the new name of the team
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the current stamina of the Athlete
	 * The stamina of the Athlete can be no less than 0.
	 * If the Athlete's stamina is 0, the setIsInjured method is called to make the Athlete injured.
	 *
	 * @param stamina the new stamina of the athlete
	 */
	public void setStamina(int stamina) {
		this.stamina = Math.max(stamina, 0);
	}
	
	/**
	 * Use an item on the Athlete
	 * @param item  the item that the athlete is using
	 */
	public void useItem(Item item) {
		// impletent later!
		this.stats.apply( item.getEffects() );
	}


	/**
	 * Returns the Athlete's details and statistics in a string
	 */
	@Override
	public String toString() {
		return "<a style='margin:15px;'>" + this.name + " " + this.stats + "</a>";
	}
	
	public String toShopString() {
		return "<a style='margin:15px;'>" + this.name + " " + this.stats + " <a style='color:#999;'><i>Stamina " + this.getStamina() + "</i></a>";
	}
	
	public String matchString() {
		return "" + this.name + " (" + this.stats + ")";
	}

	public Money price() {
		// returns the value of the athlete
		int value = 0;
		int[] stats = this.stats.get();
		for (int i = 0; i < stats.length; i++) {
			value += 10 * stats[i];
		}
		return new Money(value);
	}
	
	public String getOption() {
		return "$" + this.price() + " - " + this;
	}
}
