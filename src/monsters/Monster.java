package monsters;

import main.RandomHelper;

/**
 * @author  Eric Groseclos
 * @version 1.0
 */
public abstract class Monster implements IMonster {

    private String name;

    private String attackLine;

    private int hp;

    private int exp;

    private int gold;

    private boolean dead;

    /**
     * A monster, which the player character battles. Has a set
     * amount of HP, just like the player has. The monster gives experience
     * when killed. Also, gold is obtained.
     * @param name  The monster's name
     * @param attackLine  The attack line that is displayed when battling
     * @param hp    The monster's HP
     * @param exp   The amount of EXP the monster gives
     * @param gold  The amount of gold the monster gives
     * @param dead  Is the monster alive or not?
     */
    public Monster(String name, String attackLine, int hp, int exp, int gold, boolean dead) {
        this.name = name;
        this.attackLine = attackLine;
        this.hp = hp;
        this.exp = exp;
        this.gold = gold;
        this.dead = dead;
    }

    /**
     * Returns a random monster among the available monsters,
     * which the player must do battle with.
     * @return  A monster
     */
    public static IMonster randomMonster() {

        IMonster monster = null;

        if (RandomHelper.getBigChance()) {

            switch (RandomHelper.getInt(1, 3)) {
                case 1:
                    monster = new Cyborg();
                    break;
                case 2:
                    monster = new Sauropod();
                    break;
                case 3:
                    monster = new Wyrm();
                    break;
                default:
            }

        } else {
            monster = new Colossus();
        }

        return monster;
    }

    public int attack() {

        String monsterName = getName();

        int damage = 0;

        switch (monsterName) {
            case "cyborg":
                damage = RandomHelper.getInt(15,30);
                break;
            case "sauropod":
                damage = RandomHelper.getInt(20,35);
                break;
            case "wyrm":
                damage = RandomHelper.getInt(25,40);
                break;
            case "colossus":
                damage = RandomHelper.getInt(35,50);
                break;
            default:
        }

        return damage;
    }

    public String getAttackLine() { return attackLine; }

    public void takeDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            dead = true;
        }
    }

    public boolean isDead() {
        return dead;
    }

    public String getName() {
        return name;
    }

    public int getHp() {
        return hp;
    }

    public int getExp() {
        return exp;
    }

    public int getGold() { return gold; }

}
