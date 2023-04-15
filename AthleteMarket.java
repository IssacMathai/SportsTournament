import java.util.ArrayList;
/**
 * This class implements a Market.
 */
public class AthleteMarket extends Market {
	/**
	 * Takes a parameter of type Team of athletes and converts to an ArrayList of objects then
	 * Call the parent constructor
	 */
	public AthleteMarket(Team athletes) {
		super(new ArrayList<Object>(athletes.getTeamMembers()));
	}
	
	/**
	 * Return an array of all the athletes in the market
	 */
	public ArrayList<Athlete> getItems() {
		ArrayList<Object> objects = this.getObjects();
		ArrayList<Athlete> athletes = new ArrayList<Athlete>();
		// Cast list to type Athlete
		for (Object object : objects) {
			athletes.add( (Athlete) object );
		}		
		return athletes;
	}
	
	/**
	 * Gets an athlete price from an index
	 */
	public int getItemPrice(int index) {
		ArrayList<Athlete> athletes = this.getItems();
		return athletes.get(index).getPrice();
	}
	
	/**
	 * View Items in the shop
	 */
	@Override
	public String toString() {
		String string = "";
		for (Object object : this.getObjects()) {
			Athlete athlete = (Athlete) object;
			string += " $" + athlete.getPrice() + " - " + athlete + "\n";
		}
		return string;
	}
	
	/**
	 * Take an athlete out of the Market and put it in the team
	 * return true if purcahse was successful,
	 * false if else
	 */
	public boolean buyItem(int index, Team team) {
		ArrayList<Athlete> athletes = this.getItems();
		// check if Athlete exists
		if (this.objectExists(index)) {
			team.addAthlete(athletes.get(index));
			this.removeObject(index);
			return true;
		}
		return false;
	}
	public static void main(String[] args) {
		
	}
}














