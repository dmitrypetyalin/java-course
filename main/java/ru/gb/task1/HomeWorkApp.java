package ru.gb.task1;

/**
 * 20.03.2022 22:41
 *
 * @author PetSoft
 */
public class HomeWorkApp {
    public static void main(String[] args) {
        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
    }

    private static void printThreeWords() {
//        System.out.println("Orange");
//        System.out.println("Banana");
//        System.out.println("Apple");

        Fruits[] fruits = Fruits.values();
        for (Fruits fruit : fruits) {
            System.out.println(fruit);
        }
    }

    private static void checkSumSign() {
        int a = 1;
        int b = -1;
        if (a + b >= 0)
            System.out.println("Сумма положительная");
        else
            System.out.println("Сумма отрицательная");

    }

    private static void printColor() {
        int value = 10;
        if (value <= 0)
            System.out.println("Красный");
        if (value > 0 && value <= 100)
            System.out.println("Желтый");
        if (value > 100)
            System.out.println("Зеленый");
    }

    private static void compareNumbers() {
        int a = 20;
        int b = 20;
        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}
