package ru.gb.java2.task2;

/**
 * 29.04.2022 23:37
 *
 * @author PetSoft
 */
public class Main {
    public static void main(String[] args) {
        String[][] array1 = {
                {"1", "2", "3", "4"},
                {"-1", "-2", "-3", "-4"},
                {"901", "-56", "37", "304"},
                {"2341", "9002", "03", "40089"}};

        String[][] array2 = {
                {"1", "2", "3", "4"},
                {"-1", "-2", "-3", "-4"},
                {"901", "-56", "37", "304"},
                {"2341", "9002", "03", "40089"}};

        String[][] array3 = {
                {"1", "2", "3", "4"},
                {"-1", "-2", "-3", "-4"},
                {"901", "-56", "37",},
                {"2341", "9002", "03", "40089"}};

        try {
            Utils.sumArray(array1, 4);
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }

        try {
            Utils.sumArray(array2, 4);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            Utils.sumArray(array3, 4);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }
}
