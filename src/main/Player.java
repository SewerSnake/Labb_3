package main;

/**
 * @author  Eric Groseclos
 * @version 1.0
 */
public class Player implements IPlayer {

    private String name;

    private int hp;

    private int baseHp;

    private int exp;

    private int level;

    private int gold;

    private int strength;

    private int toughness;

    private boolean dead;

    /**
     * Creates a Player instance with the given name as parameter.
     * Instantiates all fields needed for the character.
     * The player has Hit Points (HP), experience (EXP),
     * a level, a pile of gold, a strength value, and
     * a toughness value. The player is either alive or dead.
     * If he or she dies, the game ends.
     * @param name  The name of the player character
     */
    public Player(String name) {
        this.name = name;
        hp = 200;
        baseHp = 200;
        exp = 0;
        level = 1;
        gold = 0;
        strength = 0;
        toughness = 0;
        dead = false;
    }


    public int attack() {
        return (2 * strength) + RandomHelper.getInt(25,35);
    }

    
    public void takeDamage(int damage) {

        hp -= damage;

        if (hp <= 0) {
            dead = true;
        }
    }


    public void giveExp(int newExp) {

        exp += newExp;

        if (exp >= 100) {

            hp = baseHp;

            int numberOfLevels = exp / 100;

            exp = exp % 100;

            while (numberOfLevels > 0) {
                level++;
                numberOfLevels--;
            }

            System.out.println("You leveled up, and are now level " + level +"!");

        }
    }

    public boolean isDead() {
        return dead;
    }

    public int getHp() {
        return hp;
    }

    public int getBaseHp() {
        return baseHp;
    }

    public String getName() { return name; }

    public int getExp() {
        return exp;
    }

    public int getLevel() {
        return level;
    }

    public int getGold() { return gold; }

    public int getStrength() { return strength; }

    public int getToughness() { return toughness; }

    public void giveGold(int moreGold) {
        gold += moreGold;
    }

    public void takeGold(int lessGold) {
        gold -= lessGold;
    }

    public void gainStrength() {
        strength += 5;
    }

    public void gainToughness() {
        toughness += 2;
    }

}
