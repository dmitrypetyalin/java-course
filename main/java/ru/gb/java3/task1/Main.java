package ru.gb.java3.task1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 22.08.2022 22:26
 *
 * @author PetSoft
 */
public class Main {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3", "4", "5"};

        //-----------1---------------------------
        swap(arr, 0, 4);
        System.out.println(Arrays.toString(arr));

        //-----------2---------------------------
        List list = convert(arr);
        System.out.println(list.toString());

        //-----------3---------------------------
        Box<Apple> appleBox = new Box<>();
        for (int i = 0; i < 6; i++) {
            appleBox.add(new Apple());
        }
        System.out.println(appleBox.getWeight());

        Box<Orange> orangeBox = new Box<>();
        for (int i = 0; i < 4; i++) {
            orangeBox.add(new Orange());
        }
        System.out.println(orangeBox.getWeight());

        Box<Apple> appleBox1 = new Box<>();
        appleBox.loadTo(appleBox1);
        System.out.println(appleBox1.getWeight());

        System.out.println(appleBox1.compare(orangeBox));

    }

    public static <T> void swap(T[] array, int i, int j) {
        T tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static <T> List<T> convert(T[] array) {
        return Arrays.asList(array);
    }
}
