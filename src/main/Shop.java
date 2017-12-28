package main;

import java.util.Scanner;

/**
 * @author  Eric Groseclos
 * @version 1.0
 */
public class Shop {

    // Keeps track of the player.
    // Needed for taking gold from that player, as well as bestowing
    //amulets on him/her.
    private IPlayer player;

    // Handles input from user.
    private Scanner sc;

    // Keeps track of when the shop should be exited.
    private boolean exitShop = false;

    private final String item_1 = "1. Attack Amulet (+ 5 strength) - 100 gold";

    private final String item_2 = "2. Defence Amulet (+ 2 toughness) - 100 gold";

    private final String exit = "E. Exit shop";


    public Shop(IPlayer player) {
        this.player = player;
        sc = new Scanner(System.in);
    }

    public void buy() {

        exitShop = false;

        System.out.println("Welcome! What do you want to buy?");

        showGold();

        do {

            System.out.println("*****");

            System.out.println(item_1);

            System.out.println(item_2);

            System.out.println(exit);

            System.out.print("> ");

            String choice = sc.nextLine().toLowerCase();

            switch (choice) {

                case "1":
                    if (player.getGold() < 100) {
                        System.out.println("You don't have enough gold...");
                    } else {
                        player.takeGold(100);
                        player.gainStrength();
                        System.out.println("You bought an amulet. You can feel its power.");
                        showGold();
                    }
                    break;

                case "2":
                    if (player.getGold() < 100) {
                        System.out.println("You don't have enough gold...");
                    } else {
                        player.takeGold(100);
                        player.gainToughness();
                        System.out.println("You bought an amulet. You feel warm and comfy.");
                        showGold();
                    }
                    break;

                case "e":
                    exitShop = true;
                    break;
            }

        } while (!exitShop);

    }

    /**
     * Tells the player how much gold he or she has
     */
    public void showGold() {
        System.out.println("You have " + player.getGold() + " gold.");
    }

}
