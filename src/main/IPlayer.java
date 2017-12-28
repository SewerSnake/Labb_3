package main;

/**
 * @author  Eric Groseclos
 * @version 1.0
 */
public interface IPlayer {
	
	/**
	 * Tells the player to attack
	 * @return the damage of the attack
	 */
	public int attack();

	/**
	 * Tells the player to take damage.
	 * This reduces the player's HP, and may result in him or her dying.
	 * @param damage - amount of hp points to subtract from hp
	 */
	public void takeDamage(int damage);

	/**
	 * Gives the player some experience.
	 * May level up the player. Restores the player's HP if this occurs.
	 * @param newExp - the amount of exp to add to the player
	 */
	public void giveExp(int newExp);
	
	/**
	 * Checks if this player is dead or not.
	 * @return true if dead, false if alive
	 */
	public boolean isDead();

	/**
	 * Returns the current HP of the player
	 */
	public int getHp();

    /**
     *  Returns the base HP of the player
     */
	public int getBaseHp();

	/**
	 * Returns the name of the player character
	 */
	public String getName();

	/**
	 * Returns the current EXP of the player
	 */
	public int getExp();

	/**
	 * Returns the current level of the player
	 */
	public int getLevel();

    /**
     * Returns how much gold the player currently has
     */
	public int getGold();

    /**
     *  Returns strength of the player.
     */
    public int getStrength();

    /**
     *  Returns the toughness of the player.
     */
    public int getToughness();

    /**
     * Takes the slain monster's gold, thus giving the player more gold.
     * @param moreGold amount of gold to increase by
     */
	public void giveGold(int moreGold);

    /**
     * Gives payment to the shop. Decreases the player's
     * gold
     * @param lessGold  amount of gold to decrease by
     */
	public void takeGold(int lessGold);

    /**
     * Improves the strength of the player's attacks
     */
	public void gainStrength();

    /**
     * Heightens the player's defences against monster attacks
     */
	public void gainToughness();

}
