package ru.gb.task7;

/**
 * 11.04.2022 21:06
 *
 * @author PetSoft
 */
public class Cat {
    private String name;
    private int appetite;
    private boolean fullness;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        this.fullness = false;
    }

    public void eat(Plate plate) {
        if (!fullness)
            fullness = plate.decreaseFood(appetite);
    }

    public boolean isFull() {
        return fullness;
    }

    public String getName() {
        return name;
    }
}
