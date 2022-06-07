package ru.gb.java2.task5;

import java.util.Arrays;

/**
 * 07.06.2022 9:25
 *
 * @author PetSoft
 */
public class ThreadHomework {
    private static final int SIZE = 10_000_000;
    private static final int HALF = SIZE / 2;

    public static void main(String[] args) {
        firstMethod();
        secondMethod();
    }

    private static void firstMethod() {
        float[] arr = createArray();

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < arr.length; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }

        System.out.println("One thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private static void secondMethod() {
        float[] initArr = createArray();

        long startTime = System.currentTimeMillis();

        float[] leftArr = new float[HALF];
        float[] rightArr = new float[HALF];

        System.arraycopy(initArr, 0, leftArr, 0, HALF);
        System.arraycopy(initArr, HALF, rightArr, 0, HALF);

        Thread thread1 = new Thread(() -> recalculateArray(leftArr));
        Thread thread2 = new Thread(() -> recalculateArray(rightArr));

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        float[] mergedArr = new float[SIZE];
        System.arraycopy(leftArr, 0, mergedArr, 0, HALF);
        System.arraycopy(rightArr, 0, mergedArr, HALF, HALF);

        System.out.println("Two thread time: " + (System.currentTimeMillis() - startTime) + " ms.");
    }

    private static float[] createArray() {
        float[] array = new float[SIZE];
        Arrays.fill(array, 1.0f);
        return array;
    }

    private static float calculate(int i, float value) {
        return (float) ((value * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2)));
    }

    private static void recalculateArray(float[] array) {
        for (int i = 0; i < array.length; i++) {
            array[i] = calculate(i, array[i]);
        }
    }
}
