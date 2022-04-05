package ru.gb.task3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Random;

/**
 * 26.03.2022 0:19
 *
 * @author PetSoft
 */
public class HomeWorkApp3 {
    private static final Logger LOG = LoggerFactory.getLogger(HomeWorkApp3.class);
    private static final Random random = new Random();

    public static void main(String[] args) {
        // 1 ----------------------------------------
        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(2);
        }

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        invertArray(arr);

        System.out.println("Inverted array:");
        System.out.println(Arrays.toString(arr));

        // 2 ----------------------------------------

        System.out.println(Arrays.toString(fillArray()));

        // 3 ----------------------------------------

        int[] array = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeArray(array);
        System.out.println(Arrays.toString(array));

        // 4 ----------------------------------------

        fillDiagonal();

        // 5 ----------------------------------------

        System.out.println(Arrays.toString(fillArray(20, 3)));

        // 6 ----------------------------------------

        int[] intArray = new int[100];

        for (int i = 0; i < intArray.length; i++) {
            intArray[i] = random.nextInt(10000);
        }
        StringBuilder minValue = new StringBuilder();
        StringBuilder maxValue = new StringBuilder();

        searchMinMax(intArray, minValue, maxValue);

        System.out.printf("Min value is: %s, Max value is: %s%n", minValue, maxValue);

        // 7 ----------------------------------------

        int[] balancedArray = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println(checkBalance(balancedArray));

        balancedArray = new int[]{1, 1, 1, 2, 1};
        System.out.println(checkBalance(balancedArray));


        // 8 ----------------------------------------

        int[] oneMoreArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        shiftIndex(oneMoreArray, -3);
        System.out.println(Arrays.toString(oneMoreArray));
    }

    /* Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ].
    С помощью цикла и условия заменить 0 на 1, 1 на 0 */

    public static void invertArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] == 0 ? 1 : 0);
        }
    }

    /* Задать пустой целочисленный массив длиной 100.
    С помощью цикла заполнить его значениями 1 2 3 4 5 6 7 8 … 100 */

    public static int[] fillArray() {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        return array;
    }

    // Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2

    public static void changeArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6)
                array[i] *= 2;
        }
    }

    /* Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
    и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей,
    если обе сложно). Определить элементы одной из диагоналей можно по следующему принципу:
    индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n] */

    public static void fillDiagonal() {
        int[][] twoDimArr = new int[20][20];
        for (int i = 0; i < twoDimArr.length; i++) {
            twoDimArr[i][i] = 1;
        }
        for (int[] ints : twoDimArr) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
    }


    /* Написать метод, принимающий на вход два аргумента: len и initialValue,
    и возвращающий одномерный массив типа int длиной len, каждая ячейка которого равна initialValue */

    public static int[] fillArray(int len, int initialValue) {
        int[] array = new int[len];
        Arrays.fill(array, initialValue);
        return array;
    }

    // Задать одномерный массив и найти в нем минимальный и максимальный элементы

    public static void searchMinMax(int[] array, StringBuilder minValue, StringBuilder maxValue) {
        int min = array[0];
        int max = array[0];
        for (int j : array) {
            if (min > j)
                min = j;
            if (max < j)
                max = j;
        }
        minValue.append(min);
        maxValue.append(max);
    }

    /* Написать метод, в который передается не пустой одномерный целочисленный массив, метод должен вернуть true,
    если в массиве есть место, в котором сумма левой и правой части массива равны.*/

    public static boolean checkBalance(int[] array) {
        long leftSum = 0;
        long rightSum = 0;
        int i = 0;
        int j = array.length - 1;
        do {
            leftSum += array[i];
            if (leftSum == rightSum && i == j)
                return true;
            for (; j > i; j--) {
                if (rightSum > leftSum)
                    break;
                rightSum += array[j];
            }
            i++;
        } while (i <= j);
        return false;
    }

    /* Написать метод, которому на вход подается одномерный массив и число n (может быть положительным, или отрицательным),
    при этом метод должен сместить все элементы массива на n позиций. Элементы смещаются циклично.
    Для усложнения задачи нельзя пользоваться вспомогательными массивами */

    public static void shiftIndex(int[] array, int shift) {
        int penPos = array.length - 1; // penultimate position of an array
        int i = 0;
        int j;
        int tmp;

        if (shift > array.length)
            shift %= array.length;

        if (shift >= 0) {
            for (; i < shift; i++) {
                tmp = array[penPos];
                for (j = penPos; j > 0; j--) {
                    array[j] = array[j - 1];
                }
                array[0] = tmp;
            }
        } else {
            for (; i > shift; i--) {
                tmp = array[penPos];
                array[penPos] = array[0];
                for (j = 1; j < penPos; j++) {
                    array[j - 1] = array[j];
                }
                array[array.length - 2] = tmp;
            }
        }
    }
}
