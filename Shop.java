import java.util.ArrayList;

public class Shop {
	private ArrayList<Sellable> sellables;
	public Shop() {
		this.sellables = new ArrayList<Sellable>();
	}
	public void clear() {
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
	public boolean canBuy(int index, Team player) throws Exception { // doesn't edit players money
		Sellable sellable = this.getSellable( index );
		if (player.getMoney().get() < sellable.price().get()) {
			throw new Exception("you need $" + this.price( index ) + " for " + sellable + ", you have $" + player.getMoney() + ".");
		}
		if (sellable instanceof Athlete && player.teamCount() >= player.getTeamSize()) {
			throw new Exception("your team has a maximum of " + player.getTeamSize() + " members!");
		}
		return true;
	}
	public Sellable buy(int index, Team player) { // EDITS players money
		player.getMoney().change( -this.sellables.get(index).price().get());
		Sellable sell = this.sellables.remove(index);
		sell.bought();
		return sell;
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




















































