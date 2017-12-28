package monsters;

/**
 * @author  Eric Groseclos
 * @version 1.0
 */
public interface IMonster {

	/**
	 * Tells the monster to attack
	 * @return the damage of the attack
	 */
	public int attack();

    /**
     * Gets the monster's attack information.
     * @return A line containing how the monster battles
     */
	public String getAttackLine();

	/**
	 * Tells the monster to take damage.
	 * This reduces the monster's HP, and may result in it dying
	 * @param damage - amount of hp points to subtract from hp
	 */
	public void takeDamage(int damage);

	/**
	 * Checks if this monster is dead or not.
	 * @return true if dead, false if alive
	 */
	public boolean isDead();

	/**
	 * Returns the name of the monster
	 */
	public String getName();
	
	/**
	 * Returns the current HP of the monster
	 */
	public int getHp();

    /**
     * Returns the amount of gold the monster carries
     */
	public int getGold();

	/**
	 * Returns the amount of EXP points that the player should gain
	 * when he or she kills this monster
	 */
	public int getExp();

	
}
