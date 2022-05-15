package ru.gb.task6;

import java.util.List;
import java.util.Random;

import static ru.gb.task6.AnimalType.*;

/**
 * 08.04.2022 23:18
 *
 * @author PetSoft
 */
public class HomeWorkApp6 {
    public static void main(String[] args) {
        Random random = new Random();
        List<Animal> animals = List.of(
                new Dog("Bobik", DOG),
                new Dog("Sharik", DOG),
                new Cat("Barsik", CAT),
                new Cat("Pushok", CAT),
                new Cat("Vaska", CAT)
        );

        for (Animal a : animals) {
            a.run(random.nextInt(700));
            a.swim(random.nextInt(20));
        }

        System.out.println("Dogs: " + Dog.getCount());
        System.out.println("Cats: " + Cat.getCount());
        System.out.println("Animals: " + Animal.getCount());
    }
}
