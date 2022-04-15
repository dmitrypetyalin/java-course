package ru.gb.task6;

/**
 * 08.04.2022 23:14
 *
 * @author PetSoft
 */
public class Dog extends Animal {
    private static int count;
    private static final int RUN_LIMIT = 500;
    private static final int SWIM_LIMIT = 10;
    private String name;
    private AnimalType type;

    private Dog() {
        count++;
        Animal.addAnimal();
    }

    public Dog(String name, AnimalType type) {
        this();
        this.name = name;
        this.type = type;
    }

    @Override
    public boolean run(int distance) {
        if (distance < RUN_LIMIT) {
            System.out.printf("%s %s has run %d m.\r\n", type.toString(), name, distance);
            return true;
        } else {
            System.out.printf("%s %s can't run so long!\r\n", type.toString(), name);
            return false;
        }
    }

    @Override
    public boolean swim(int distance) {
        if (distance < SWIM_LIMIT) {
            System.out.printf("%s %s has swum %d m.\r\n", type.toString(), name, distance);
            return true;
        } else {
            System.out.printf("%s %s can't swim so long!\r\n", type.toString(), name);
            return false;
        }
    }

    public static int getCount() {
        return count;
    }

    public String getName() {
        return name;
    }

    public AnimalType getType() {
        return type;
    }
}
