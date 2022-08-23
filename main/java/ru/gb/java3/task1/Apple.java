package ru.gb.java3.task1;

/**
 * 22.08.2022 22:56
 *
 * @author PetSoft
 */
public class Apple extends Fruit {
    public Apple() {
        super(1.0f);
    }

    @Override
    public String toString() {
        return String.format("Apple{ weight = %f }", weight);
    }
}
