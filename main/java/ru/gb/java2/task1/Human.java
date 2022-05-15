package ru.gb.java2.task1;

/**
 * 25.04.2022 1:47
 *
 * @author PetSoft
 */
public class Human implements Unit {
    private final String name;
    private final int runAbility;
    private final int jumpAbility;

    public Human(String name, int runAbility, int jumpAbility) {
        this.name = name;
        this.runAbility = runAbility;
        this.jumpAbility = jumpAbility;
    }

    @Override
    public boolean run(int length) {
        return this.runAbility >= length;
    }

    @Override
    public boolean jump(int height) {
        return this.jumpAbility >= height;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
