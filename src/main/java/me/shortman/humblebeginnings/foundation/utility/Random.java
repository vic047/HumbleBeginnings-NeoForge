package me.shortman.humblebeginnings.foundation.utility;


public final class Random {
    public static int randIntBetween(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    /* Returns true if a random number between 0 and 100 is
    *  smaller than the inputted chance, else false.
    * */
    public static boolean isLuckyWithChanceOf(int chance) {
        if (chance > 100) {
            chance = 100;
        } else if (chance < 1) {
            chance = 1;
        }
        return randIntBetween(1, 100) < chance;
    }
}
