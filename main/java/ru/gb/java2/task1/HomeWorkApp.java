package ru.gb.java2.task1;

import java.util.Random;

/**
 * 25.04.2022 2:22
 *
 * @author PetSoft
 */
public class HomeWorkApp {
    public static void main(String[] args) {
        Unit units[] = {
                new Human("Bob", 500, 2),
                new Human("Joe", 700, 3),
                new Cat("Whity", 350, 4),
                new Cat("Blacky", 400, 5),
                new Robot("Bb", 1000, 1),
                new Robot("Bumblebee", 2500, 25)};

        Obstacle obstacles[] = {
                new Track(10),
                new Wall(1),
                new Track(300),
                new Wall(5),
                new Track(1000)};

        for (Unit u : units) {
            for (Obstacle o : obstacles) {
                if (!o.overcome(u)) break;
            }
        }
    }
}
