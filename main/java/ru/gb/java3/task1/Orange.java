package ru.gb.java3.task1;

/**
 * 22.08.2022 22:56
 *
 * @author PetSoft
 */
public class Orange extends Fruit {
    public Orange() {
        super(1.5f);
    }

    @Override
    public String toString() {
        return String.format("Orange{ weight = %f }", weight);
    }
}
