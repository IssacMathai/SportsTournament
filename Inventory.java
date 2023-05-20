import java.util.ArrayList;

public class Inventory {
	private ArrayList<Item> items;
	public Inventory() {
		this.items = new ArrayList<Item>();
	}
	public ArrayList<Item> get() {
		return this.items;
	}
	public ArrayList<Sellable> getSellables() {
		ArrayList<Sellable> asdf = new ArrayList<Sellable>();
		for (Item item : this.items) {
			asdf.add( (Sellable) item );
		}
		return asdf;
	}
	public Item get(int index) {
		return this.items.get(index);
	}
	public void add(Item item) {
		this.items.add(item);
	}
	public boolean exists(int index) {
		return 0 <= index && index < this.items.size();
	}
	public void remove(int index) {
		this.items.remove(index);
	}
	public Item use(int index) {
		Item item = this.get(index);
		this.remove(index);
		return item;
	}
	public String toString() {
		String string = "Inventory\n";
		for (int i = 0; i < this.items.size(); i++) {
			string += this.items.get(i) + "\n";
		}
		if (this.items.size() == 0) {
			string += "<a style='color:#999;'>Inventory currenty has no items.</a>";
		}
		return string;
	}
}