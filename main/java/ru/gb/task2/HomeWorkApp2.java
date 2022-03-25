package ru.gb.task2;

/**
 * 23.03.2022 0:30
 *
 * @author PetSoft
 */
public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(isInARange(10, 15));
        checkSign(10);
        System.out.println(isNegative(10));
        printStringNTimes("Hello", 2);
        System.out.println(isLeapYear(2000));
    }

    public static boolean isInARange(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    public static void checkSign(int number) {
        System.out.println(number >= 0 ? "Positive" : "Negative");
    }

    public static boolean isNegative(int number) {
        return number < 0;
    }

    public static void printStringNTimes(String s, int n) {
        for (int i = 0; i < n; i++) {
            System.out.println(s);
        }
    }

    public static boolean isLeapYear(int year) {
        return year % 4 == 0 && (year % 100 != 0 || year % 400 == 0);
    }
}