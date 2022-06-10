package ru.gb.task6;

/**
 * 08.04.2022 23:15
 *
 * @author PetSoft
 */
public class Cat extends Animal {
    private static final int RUN_LIMIT = 200;
    private static int count;
    private String name;
    private AnimalType type;

    private Cat() {
        count++;
        Animal.addAnimal();
    }

    public Cat(String name, AnimalType type) {
        this();
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean run(int distance) {
        if (distance <= RUN_LIMIT) {
            System.out.printf("%s %s has run %d m.\r\n", type.toString(), name, distance);
            return true;
        } else {
            System.out.printf("%s %s can't run so long!\r\n", type.toString(), name);
            return false;
        }
    }

    @Override
    public boolean swim(int distance) {
        System.out.printf("%s %s can't swim!\r\n", type.toString(), name);
        return false;
    }

    public AnimalType getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public static int getCount() {
        return count;
    }
}
