/**
 * This class implements an Athlete. Athletes have their own name and stats.
 */

public class Athlete {
    /**
     * Name of the Athlete
     */
    private String name;
    /**
     * Age of the Athlete
     */
    private final int age;
    /**
     * Offence stat of the Athlete
     */
    private int offence;
    /**
     * Defence stat of the Athlete
     */
    private int defence;
    /**
     * Current stamina stat of the Athlete
     */
    private int stamina;
    /**
     * Injury status of the Athlete
     */
    private boolean isInjured;

    public Athlete(String name, int age, int offence, int defence) {
        this.name = name;
        this.age = age;
        this.offence = offence;
        this.defence = defence;
        stamina = 100;
        isInjured = false;
    }

    /**
     * Returns name of the Athlete
     */
    public String getName() {
        return name;
    }

    /**
     * Returns Age of the Athlete
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns injury status of the Athlete
     */
    public boolean isIs_injured() {
        return isInjured;
    }

    /**
     * Returns defence stat of the Athlete
     */
    public int getDefence() {
        return defence;
    }

    /**
     * Returns offence stat of the Athlete
     */
    public int getOffence() {
        return offence;
    }

    /**
     * Returns current stamina stat of the Athlete
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Sets a nickname for the Athlete
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the current stamina of the Athlete
     */
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    /**
     * Sets the current offence of the Athlete
     */
    public void setOffence(int offence) {
        this.offence = offence;
    }

    /**
     * Sets the current defence of the Athlete
     */
    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * Sets the injury status of the Athlete
     */
    public void setisInjured(boolean is_injured) {
        this.isInjured = is_injured;
    }
	
    /**
     * Use an item on the Athlete
     */
    public void useItem(Item item) {
		this.setOffence(this.getOffence() + item.getOffence());
		this.setDefence(this.getDefence() + item.getDefence());
		this.setStamina(this.getStamina() + item.getStamina());
    }


    /**
     * Returns the Athlete's details and statistics in a string
     */
    @Override
    public String toString() {
        return "Athlete{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", offence=" + offence +
                ", defence=" + defence +
                ", stamina=" + stamina +
                ", is_injured=" + isInjured +
                '}';
    }

    public static void main(String[] args) {
        Athlete Joe = new Athlete("Joe", 21, 40, 40);
        System.out.println(Joe);


    }
}
