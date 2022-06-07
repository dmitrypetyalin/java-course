package ru.gb.task6;

/**
 * 08.04.2022 23:09
 *
 * @author PetSoft
 */
public abstract class Animal {
    private static int count;

    public abstract boolean run(int distance);

    public abstract boolean swim(int distance);


    public static int getCount() {
        return count;
    }

    static void addAnimal() {
        count++;
    }
}
