package ru.gb.java2.task1;

/**
 * 25.04.2022 1:53
 *
 * @author PetSoft
 */
public class Wall implements Obstacle {
    private final int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public boolean overcome(Unit unit) {
        if (unit.jump(this.height)) {
            System.out.printf("%s %s has jumped over wall %dm.\n", unit.getClass().getSimpleName(), unit.getName(), height);
            return true;
        }
        System.out.printf("%s %s hasn't jumped over wall %dm.\n", unit.getClass().getSimpleName(), unit.getName(), height);
        return false;
    }
}
