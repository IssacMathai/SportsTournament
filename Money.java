public class Money {
	private int money;
	public Money(int money) {
		this.money = money;
	}
	public Money() {
		this.money = 0;
	}
	public void set(int money) {
		this.money = money;
	}
	public int get() {
		return this.money;
	}
	public void change(int money) {
		 this.money += money;
	}
	public String toString() {
		return "" + this.money;
	}
}