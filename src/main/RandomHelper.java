package main;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author  Eric Groseclos
 * @version 1.0
 */
public class RandomHelper {

    // Static instance variable, which is used for the generation of
    // random numbers needed during the course of the game.
    private static Random random = new Random();

    /**
     * Something is determined with a probability of 90 %.
     * @return  A boolean value
     */
    public static boolean getBigChance() {

        return random.nextDouble() < 0.9;

    }

    /**
     * Something is determined with a probability of 50 %.
     * @return  A boolean value
     */
    public static boolean get50Chance() {

        int number = RandomHelper.getInt(0,1);

        if (number == 1) {
            return false;
        } else {
            return true;
        }

    }

    /**
     * An integer value is obtained. The value in question is within
     * the interval of the two parameters.
     * @param lower The lower bound
     * @param upper The upper bound
     * @return  A random number, which is within the desired interval
     */
    public static int getInt(int lower, int upper) {
        return ThreadLocalRandom.current().nextInt(lower, upper + 1);
    }

}
