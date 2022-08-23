package ru.gb.java3.task1;

/**
 * 22.08.2022 23:03
 *
 * @author PetSoft
 */
public abstract class Fruit {
    protected final float weight;

    public Fruit(float weight) {
        this.weight = weight;
    }

    public float getWeight() {
        return this.weight;
    }
}
