import java.util.ArrayList;

public class Team {
	private String name;
	private Money money;
	private int teamSize;
	private int fieldCount;
	private ArrayList<Athlete> athletes;
	private ArrayList<Athlete> reserves;
	private Inventory inventory;
	public Team() {
		this.name = "";
		this.money = new Money(0);
		this.teamSize = 0;
		this.fieldCount = 0;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	public Team(String name) {
		this.name = name;
		this.money = new Money(0);
		this.teamSize = 0;
		this.fieldCount = 0;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	public Team(int teamSize) {
		this.name = "";
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.fieldCount = teamSize;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	public Team(String name, int teamSize) {
		this.name = name;
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.fieldCount = teamSize;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
	public Team(String name, int teamSize, int fieldCount) {
		this.name = name;
		this.money = new Money(0);
		this.teamSize = teamSize;
		this.fieldCount = fieldCount;
		this.athletes = new ArrayList<Athlete>();
		this.reserves = new ArrayList<Athlete>();
		this.inventory = new Inventory();
	}
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
	public void resetStamina() {
		for (Athlete athlete : this.athletes) {
			athlete.setStamina(100);
		}
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setMoney(Money money) {
		this.money = money;
	}
	public void setMoney(int money) {
		this.money = new Money(money);
	}
	public Money getMoney() {
		return this.money;
	}
	public int getTeamSize() {
		return this.teamSize;
	}
	public int getFieldCount() {
		return this.fieldCount;
	}
	public int teamCount() {
		return this.athleteCount() + this.reserveCount();
	}
	public boolean addSellable(Sellable sellable) {
		if (sellable instanceof Athlete) { // add athlete
			return this.addAthlete( (Athlete) sellable );
		} else { // add item
			this.inventory.add( (Item) sellable );
			return false;
		}
	}
	public Inventory getInventory() {
		return this.inventory;
	}
	public Item useItem(int item, int athlete) { // should use an item from the players inventory, then remove it
		this.athletes.get(athlete).useItem( this.inventory.get(item) );
		return this.inventory.get().remove(item);
	}
	public void swapAthletes(int first, int second) { // should swap 2 athletes
		Athlete athlete1 = this.athletes.get(first);
		Athlete athlete2 = this.athletes.get(second);
		this.athletes.set(first, athlete2);
		this.athletes.set(second, athlete1);
	}
	// Athlete Stuff
	public int athleteCount() {
		return this.athletes.size();
	}
	// return true on success
	public boolean addAthlete(Athlete athlete) { // might throw an exception ("Team full!")
		if (!this.athletes.contains(athlete) && this.athletes.size() < this.teamSize) {
			this.athletes.add(athlete);
			return true;
		} else {
			return false;
		}
	}
    public ArrayList<Athlete> getAthletes() {
		return this.athletes;
	}
    public ArrayList<Sellable> getAthletesAsSellables() {
		ArrayList<Sellable> asdf = new ArrayList<Sellable>();
		for (Athlete athlete : this.athletes) {
			asdf.add( (Sellable) athlete );
		}
		return asdf;
	}
	public Athlete getAthlete(int index) {
		return this.athletes.get(index);
	}
	public void removeAthlete(Athlete athlete) {
		this.athletes.remove(athlete);
	}
	public Athlete removeAthlete(int index) {
		return this.athletes.remove(index);
	}
	// Reserve Stuff
	public int reserveCount() {
		return this.reserves.size();
	}
	public void addReserve(Athlete athlete) {
		if (!this.reserves.contains(athlete) && this.reserves.size() < this.teamSize) {
			this.reserves.add(athlete);
		}
	}
	public Athlete getReserve(int index) {
		return this.reserves.get(index);
	}
	public void removeReserve(Athlete athlete) {
		this.reserves.remove(athlete);
	}
	public void removeReserve(int index) {
		this.reserves.remove(index);
	}
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




















































