import java.util.ArrayList;

/**
 * The Team class. It contains the athletes.
 */
public class Team {
	
	/** The name. */
	private String name;
	
	/** The money. */
	private Money money;
	
	/** The team size. */
	private int teamSize;
	
	/** The field count. */
	private int fieldCount;
	
	/** The athletes. */
	private ArrayList<Athlete> athletes;
	
	/** The reserves. */
	private ArrayList<Athlete> reserves;
	
	/** The inventory. */
	private Inventory inventory;
	
	/**
	 * Instantiates a new team.
	 */
	public Team() {
		this.name = "";
		this.money = new Money(0);
		this.teamSize = 0;
		this.fieldCount = 0;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	
	/**
	 * Instantiates a new team.
	 *
	 * @param name the name
	 */
	public Team(String name) {
		this.name = name;
		this.money = new Money(0);
		this.teamSize = 0;
		this.fieldCount = 0;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	
	/**
	 * Instantiates a new team.
	 *
	 * @param teamSize the team size
	 */
	public Team(int teamSize) {
		this.name = "";
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.fieldCount = teamSize;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	
	/**
	 * Instantiates a new team.
	 *
	 * @param name the name
	 * @param teamSize the team size
	 */
	public Team(String name, int teamSize) {
		this.name = name;
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.fieldCount = teamSize;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	
	/**
	 * Instantiates a new team.
	 *
	 * @param name the name
	 * @param teamSize the team size
	 * @param fieldCount the field count
	 */
	public Team(String name, int teamSize, int fieldCount) {
		this.name = name;
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.fieldCount = fieldCount;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	
	/**
	 * Returns whether athletes are injured.
	 *
	 * @return true, if all athletes are injured
	 */
	public boolean allInjured() { // if all the first 5 athletes are injured
		for (int i = 0; i < this.athletes.size(); i++) {
			if (i == 5) {
				break; // we don't care about reserved athletes
			}
			if (! this.athletes.get(i).isInjured()) {
				return false;
			}
		}
		return true; // they were all injured
	}
	
	/**
	 * Restores stamina to 100.
	 */
	public void resetStamina() {
		for (Athlete athlete : this.athletes) {
			athlete.setStamina(100);
		}
	}
	
	/**
	 * Sets the name of the team.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Gets the name of the team.
	 *
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the money the team has.
	 *
	 * @param money the new money
	 */
	public void setMoney(Money money) {
		this.money = money;
	}
	
	/**
	 * Sets the money the team has.
	 *
	 * @param money the new money
	 */
	public void setMoney(int money) {
		this.money = new Money(money);
	}
	
	/**
	 * Gets the money the team has.
	 *
	 * @return the money
	 */
	public Money getMoney() {
		return this.money;
	}
	
	/**
	 * Gets the team size.
	 *
	 * @return the team size
	 */
	public int getTeamSize() {
		return this.teamSize;
	}
	
	/**
	 * Gets the field count.
	 *
	 * @return the field count
	 */
	public int getFieldCount() {
		return this.fieldCount;
	}
	
	/**
	 * Team count.
	 *
	 * @return the int
	 */
	public int teamCount() {
		return this.athleteCount() + this.reserveCount();
	}
	
	/**
	 * Adds the sellable.
	 *
	 * @param sellable the sellable
	 * @return true, if inventory is not full
	 */
	public boolean addSellable(Sellable sellable) {
		if (sellable instanceof Athlete) { // add athlete
			return this.addAthlete( (Athlete) sellable );
		} else { // add item
			this.inventory.add( (Item) sellable );
			return false;
		}
	}
	
	/**
	 * Gets the inventory.
	 *
	 * @return the inventory
	 */
	public Inventory getInventory() {
		return this.inventory;
	}
	
	/**
	 * Use item.
	 *
	 * @param item the item
	 * @param athlete the athlete
	 * @return the item
	 */
	public Item useItem(int item, int athlete) { // should use an item from the players inventory, then remove it
		this.athletes.get(athlete).useItem( this.inventory.get(item) );
		return this.inventory.get().remove(item);
	}
	
	/**
	 * Swap athletes.
	 *
	 * @param first the first
	 * @param second the second
	 */
	public void swapAthletes(int first, int second) { // should swap 2 athletes
		Athlete athlete1 = this.athletes.get(first);
		Athlete athlete2 = this.athletes.get(second);
		this.athletes.set(first, athlete2);
		this.athletes.set(second, athlete1);
	}
	
	/**
	 * Number of athletes.
	 *
	 * @return the int
	 */
	// Athlete Stuff
	public int athleteCount() {
		return this.athletes.size();
	}
	
	/**
	 * Adds the athlete to the team.
	 *
	 * @param athlete the athlete
	 * @return true, if the team is not full
	 */
	// return true on success
	public boolean addAthlete(Athlete athlete) { // might throw an exception ("Team full!")
		if (!this.athletes.contains(athlete) && this.athletes.size() < this.teamSize) {
			this.athletes.add(athlete);
			return true;
		} else {
			return false;
		}
	}
    
    /**
     * Gets the athletes.
     *
     * @return the athletes
     */
    public ArrayList<Athlete> getAthletes() {
		return this.athletes;
	}
    
    /**
     * Gets the athletes as sellables.
     *
     * @return the athletes as sellables
     */
    public ArrayList<Sellable> getAthletesAsSellables() {
		ArrayList<Sellable> asdf = new ArrayList<Sellable>();
		for (Athlete athlete : this.athletes) {
			asdf.add( (Sellable) athlete );
		}
		return asdf;
	}
	
	/**
	 * Gets the athlete at the specified index
	 *
	 * @param index the index
	 * @return the athlete
	 */
	public Athlete getAthlete(int index) {
		return this.athletes.get(index);
	}
	
	/**
	 * Removes the specified athlete.
	 *
	 * @param athlete the athlete
	 */
	public void removeAthlete(Athlete athlete) {
		this.athletes.remove(athlete);
	}
	
	/**
	 * Removes the athlete at the specified index.
	 *
	 * @param index the index
	 * @return the athlete
	 */
	public Athlete removeAthlete(int index) {
		return this.athletes.remove(index);
	}
	
	/**
	 * The number of reserves.
	 *
	 * @return the int
	 */
	// Reserve Stuff
	public int reserveCount() {
		return this.reserves.size();
	}
	
	/**
	 * Adds a reserve if the team is not full.
	 *
	 * @param athlete the athlete
	 */
	public void addReserve(Athlete athlete) {
		if (!this.reserves.contains(athlete) && this.reserves.size() < this.teamSize) {
			this.reserves.add(athlete);
		}
	}
	
	/**
	 * Gets the reserve at the specified index
	 *
	 * @param index the index
	 * @return the reserve
	 */
	public Athlete getReserve(int index) {
		return this.reserves.get(index);
	}
	
	/**
	 * Removes the specified reserve
	 *
	 * @param athlete the athlete
	 */
	public void removeReserve(Athlete athlete) {
		this.reserves.remove(athlete);
	}
	
	/**
	 * Removes the reserve at the specified index.
	 *
	 * @param index the index
	 */
	public void removeReserve(int index) {
		this.reserves.remove(index);
	}
	
	/**
	 * Returns a string representation of the team
	 *
	 * @return the string
	 */
	// Other Stuff
	@Override
	public String toString() {
		String string = "";
		string += "<h1>" + this.name + "</h1>\n";
		//string += "$" + this.money + "<br>";
		for (int i = 0; i < this.athletes.size(); i++) {
			Athlete athlete = this.athletes.get(i);
			if (i == this.fieldCount) {
				string += "<a style='color:#999;'><i>-- reserves --</i>:</a>\n";
			}
			string += " " + athlete.toShopString() + "<\n";
		}
		// below should never happen
		for (Athlete reserve : this.reserves) {
			string += reserve + "\n";
		}
		if (this.teamCount() == 0) {
			string += "<a style='color:#999;'>The team has no members.</a>";
		}
		return string;
	}
	
	/**
	 * Returns a string representation of the athlete at the specified index
	 *
	 * @param index the index
	 * @return the string
	 */
	public String matchString(int index) {
		String string = "";
		
		if (index < this.teamCount()) {
			string += this.athletes.get(index).matchString();
		} else {
			string += "<a style='color:#999;'>[no athlete]</a>";
		}
		
		return string;
	}
}




















































