package ru.gb.java2.task2;

/**
 * 29.04.2022 23:18
 *
 * @author PetSoft
 */
public class Utils {
    public static int sumArray(String[][] array, int size) {
        if (array == null) throw new NullPointerException("Array is null!");

        String message = String.format("Array must be %sx%s!", size, size);

        if (array.length != size) throw new MyArraySizeException(message);

        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i].length != size) throw new MyArraySizeException(message);

            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(String.format("Not a number in the cell [%d][%d]", i + 1, j + 1));
                }
            }

        }
        System.out.println("Sum: " + sum);
        return sum;
    }
}
