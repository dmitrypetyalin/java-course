package ru.gb.task7;

/**
 * 11.04.2022 21:20
 *
 * @author PetSoft
 */
public class HomeWorkApp7 {
    public static void main(String[] args) {
        Plate plate = new Plate(100);

        Cat[] cats = new Cat[]{
                new Cat("Whity", 20),
                new Cat("Blacky", 30),
                new Cat("Pushok", 60),
                new Cat("Crazy", 30),
                new Cat("Vaska", 10)
        };

        for (Cat c : cats) {
            c.eat(plate);
        }

        for (Cat c : cats) {
            System.out.printf("Is cat %s full: %b\r\n", c.getName(), c.isFull());
        }

        System.out.println();

        plate.addFood(50);

        for (Cat c : cats) {
            c.eat(plate);
        }

        for (Cat c : cats) {
            System.out.printf("Is cat %s full: %b\r\n", c.getName(), c.isFull());
        }
    }
}
