import java.util.ArrayList;
/**
 * This class implements a Market.
 */
public class Market {
	/**
	 * A list of all object in the market
	 */
	private ArrayList<Object> objects = new ArrayList<Object>();
	
	/**
	 * Create a market of objects from an ArrayList of Objects
	 */
	public Market(ArrayList<Object> objects) {
		this.objects = objects;
	}
	
	public ArrayList<Object> getObjects() {
		return this.objects;
	}
	
	/**
	 * Returns the number of items in the market
	 */
	public int length() {
		return this.objects.size();
	}
	
	/**
	 * Returns whether a specific Object is in the Market
	 */
	public boolean objectExists(int index) {
		return 0 <= index && index <= this.objects.size() - 1;
	}
	
	/**
	 * Removes a specific Object in the Market
	 * returns true is successful
	 */
	public boolean removeObject(int index) {
		if (this.objectExists(index)) {
			this.objects.remove(index);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
	}
}