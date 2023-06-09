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
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns Age of the Athlete
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * Returns injury status of the Athlete
     *
     * @return isInjured
     */
    public boolean getIsInjured() {
        return isInjured;
    }

    /**
     * Returns defence stat of the Athlete
     *
     * @return defence
     */
    public int getDefence() {
        return defence;
    }

    /**
     * Returns offence stat of the Athlete
     *
     * @return offence
     */
    public int getOffence() {
        return offence;
    }

    /**
     * Returns current stamina stat of the Athlete
     *
     * @return stamina
     */
    public int getStamina() {
        return stamina;
    }

    /**
     * Sets a nickname for the Athlete
     *
     * @param name the new name of the team
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the current stamina of the Athlete
     * The stamina of the Athlete can be no less than 0.
     * If the Athlete's stamina is 0, the setIsInjured method is called to make the Athlete injured.
     *
     * @param stamina the new stamina of the athlete
     */
    public void setStamina(int stamina) {
        this.stamina = Math.max(stamina, 0);
        if (this.stamina == 0) {
            setIsInjured(true);
        }
    }

    /**
     * Sets the current offence of the Athlete
     * @param offence the new offence stat the athlete should have
     */
    public void setOffence(int offence) {
        this.offence = offence;
    }

    /**
     * Sets the current defence of the Athlete
     * @param defence the new defence stat the athlete should have
     */
    public void setDefence(int defence) {
        this.defence = defence;
    }

    /**
     * Sets the injury status of the Athlete
     *
     * @param is_injured whether the athlete is now injured or not
     */
    public void setIsInjured(boolean is_injured) {
        this.isInjured = is_injured;
    }
	
    /**
     * Use an item on the Athlete
     * @param item  the item that the athlete is using
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
