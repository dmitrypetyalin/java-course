package ru.gb.java3.task1;

import java.util.ArrayList;
import java.util.List;

/**
 * 22.08.2022 23:02
 *
 * @author PetSoft
 */
public class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public float getWeight() {
        return fruits.size() == 0 ? 0f : fruits.size() * fruits.get(0).getWeight();
    }

    public boolean compare(Box<?> box) {
        return Math.abs(this.getWeight() - box.getWeight()) < 0.0001;
//        return this.getWeight() == box.getWeight();
    }

    public void loadTo(Box<T> box) {
        if (this.getWeight() == 0) return;
        for (T fruit : fruits) {
            box.add(fruit);
        }
        fruits.clear();
    }

    public void add(T fruit) {
        fruits.add(fruit);
    }
}
