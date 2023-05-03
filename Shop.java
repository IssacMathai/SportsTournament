import java.util.ArrayList;

public class Shop {
	private ArrayList<Sellable> sellables;
	public Shop() {
		this.sellables = new ArrayList<Sellable>();
	}
	public int sellableCount() {
		return this.sellables.size();
	}
	// return true on success
	public boolean addSellable(Sellable sellable) {
		this.sellables.add(sellable);
		return true;
	}
    public ArrayList<Sellable> getSellables() {
		return this.sellables;
	}
	public Sellable getSellable(int index) {
		return this.sellables.get(index);
	}
	public void removeSellable(Sellable sellable) {
		this.sellables.remove(sellable);
	}
	public void removeSellable(int index) {
		this.sellables.remove(index);
	}
	public boolean canBuy(int index, Money money) { // doesn't edit money
		return money.get() >= this.sellables.get(index).price().get();
	}
	public Sellable buy(int index, Money money) { // EDITS money
		money.change( -this.sellables.get(index).price().get());
		return this.sellables.remove(index);
	}
	public Money price(int index) {
		return this.sellables.get(index).price();
	}
	// Other Stuff
	@Override
	public String toString() {
		String string = "";
		string += "Shop\n";
		for (Sellable sellable : this.sellables) {
			string += sellable.getOption() + "\n";
		}
		if (this.sellableCount() == 0) {
			string += "The shop is empty.";
		}
		return string;
	}
}




















































