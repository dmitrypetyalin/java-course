package ru.gb.java2.task1;

/**
 * 25.04.2022 1:53
 *
 * @author PetSoft
 */
public class Track implements Obstacle {
    private final int length;

    public Track(int length) {
        this.length = length;
    }

    @Override
    public boolean overcome(Unit unit) {
        if (unit.run(this.length)) {
            System.out.printf("%s %s has run %d\n", unit.getClass().getSimpleName(), unit.getName(), length);
            return true;
        }
        System.out.printf("%s %s hasn't run track %dm. \n", unit.getClass().getSimpleName(), unit.getName(), length);
        return false;
    }
}
