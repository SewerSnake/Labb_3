package main;

import java.util.Scanner;

import monsters.*;

/**
 * @author  Eric Groseclos
 * @version 1.0
 */
public class Game {

	// Keeps track of when the main loop should be aborted.
	private boolean lostGame, wonGame;

	// Handles input from user.
	private Scanner sc;

	// Keeps track of current player.
	private IPlayer player;

	// Keeps track of the player's two attack lines.
    private String[] attacks = new String[] {"You strike the monster with your sword, dealing ",
            "You shoot the monster with your bow, dealing "};

	// A shop where the player can buy amulets.
    private Shop shop;

	// Keeps track of whether gameplay should resume or not.
    private boolean isPaused = false;

	/**
	 * Creates a new Game.
	 */
	public Game() {

	    sc = new Scanner(System.in);

	}

	/**
	 * Welcomes the player. Creates all necessary instances.
     * Contains the main game loop. The loop continues until
     * the player has either won or lost the game.
	 */
	public void startGame() {

		System.out.println("************************");
		System.out.println("* Welcome to The Game! *");
		System.out.println("************************");

		System.out.print("Enter your name: ");

		String name = sc.nextLine();

        player = new Player(name);

        shop = new Shop(player);
		
		System.out.println();
		
		String input = null;

		while (!wonGame && !lostGame) {

			printMainMenu();

			System.out.print("> ");

			input = sc.nextLine();

			switch(input) {
				case "1":
					goAdventure();
					break;
				case "2":
					goCharacter();
					break;
				case "3":
					shop.buy();
					break;
				case "4":
					System.out.println("Goodbye!");
					lostGame = true;
					break;
                default:
                    System.out.println("Not one of the options given! Please try again!");

			}
		}
		
		if (wonGame) {
			System.out.println("Congratulations! You won The Game!");
		}

	}
	
	/**
	 * Prints all menu options
	 */
	private void printMainMenu() {
		System.out.println("1. Go adventuring");
		System.out.println("2. Show details about your character");
        System.out.println("3. Go to shop");
		System.out.println("4. Exit game");
	}
	
	/**
	 * First menu option - fighting monsters
	 */
	private void goAdventure() {

	    IMonster monster = null;

	    if (RandomHelper.getBigChance()) {

	        monster = Monster.randomMonster();

            battle(monster);

        } else {
	        System.out.println("You see nothing but swaying grass all around you...");
        }
	}
	
	/**
	 * Initiates a battle between the player and the given monster
	 * @param monster - the monster to fight
	 */
	private void battle(IMonster monster) {

	    System.out.println("Uh oh! A " + monster.getName() + " appeared!");

        while (true) {

            int damageToMonster = player.attack();
            System.out.println(attacks[RandomHelper.get50Chance() ? 0 : 1] + damageToMonster + " damage");
            monster.takeDamage(damageToMonster);

            if (monster.isDead()) {
                System.out.println("You killed the monster, gaining " + monster.getExp() + " experience!");
                break;
            }

            pause();

            int damageToPlayer = monster.attack() - 2 * player.getToughness();
            if (damageToPlayer < 0) {
                damageToPlayer = 0;
            }
            System.out.println(monster.getAttackLine() + damageToPlayer + " damage");
            player.takeDamage(damageToPlayer);

            if (player.isDead()) {
                break;
            }

            pause();

        }

        if (player.isDead()) {
            System.out.println("You were killed by the monster! Game over...");
            lostGame = true;
        } else {
            player.giveExp(monster.getExp());

            player.giveGold(monster.getGold());

            if (player.getLevel() >= 10) {
                wonGame = true;
            }

            System.out.println("You are level " + player.getLevel() +", and you have " + player.getExp() +
                    " exp, " + player.getHp() + " hp and " + player.getGold() + " gold");

            pause();
        }
	}
	
	/**
	 * Second menu option - show details about character
	 */
	private void goCharacter() {
        System.out.println("************************");
	    System.out.println("Name: " + player.getName());
	    System.out.println("Level: " + player.getLevel());
		System.out.println("Hp: " + player.getHp() + "/" + player.getBaseHp());
		System.out.println("Exp: " + player.getExp() + "/" + 100);
        System.out.println("Gold: " + player.getGold());
        System.out.println("Strength: " + player.getStrength());
        System.out.println("Toughness: " + player.getToughness());
        System.out.println("************************");
	}

	/**
	 * Pauses the game, waiting for Enter to be pressed
	 */
	private void pause() {
		while(true) {
			System.out.println("Press Enter to continue");
			String command = sc.nextLine();
			if (command.equals("")){
			    break;
            }
		}
	}
	
}
