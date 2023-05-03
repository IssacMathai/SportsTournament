public class Item implements Sellable {
	private String name;
	private String description;
	private Stats effects;
	private Money priceValue;
	private Money priceRetail;
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.description;
	}
	public Money price() {
		return this.priceValue;
	}
	public Item(String name, String description, Stats effects, int priceValue, int priceRetail) {
		this.name = name;
		this.description = description;
		this.effects = effects;
		
		this.priceValue = new Money(priceValue);
		this.priceRetail = new Money(priceRetail);
	}
	public Stats getEffects() {
		return this.effects;
	}
	
	private String displayStat(int stat) {
		if (stat >= 0) {
			return "+" + stat;
		} else {
			return "" + stat;
		}
	}
	
	@Override
	public String toString() {
		return this.getName() + " - " + this.getDesc()
		+ " " + this.getEffects();
	}
	
	public String getOption() {
		return "$" + this.price() + " - " + this;
	}
}