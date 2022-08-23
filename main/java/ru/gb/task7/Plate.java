package ru.gb.task7;

/**
 * 11.04.2022 21:06
 *
 * @author PetSoft
 */
public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        if (n > food)
            return false;
        food -= n;
        return true;
    }

    public void addFood(int food) {
        this.food += food;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
