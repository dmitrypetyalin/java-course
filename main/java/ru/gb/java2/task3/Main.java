package ru.gb.java2.task3;

import java.util.Arrays;
import java.util.List;

/**
 * 12.05.2022 20:08
 *
 * @author PetSoft
 */
public class Main {
    public static void main(String[] args) {
        ListOfWords list1 = new ListOfWords();
        System.out.print("List of values: ");
        list1.print();
        System.out.println("List of unique values: " + Arrays.toString(list1.uniqueList().toArray()));
        System.out.println("List of duplicates: " + list1.mapOfDuplicates());

        PhoneBook pBook = PhoneBook.getInstance();
        pBook.add("Carlson", "+79133458732");
        pBook.add("Phillips", "+79233458766");
        pBook.add("Phillips", "+79033458766");
        pBook.add("Phillips", "+79133458766");
        pBook.add("MacArtur", "+79139818412");
        pBook.add("MacArtur", "+79133458732");
        pBook.add("MacArtur", "+79139015444");

        List<Entry<String, String>> list2 = pBook.get("MacArtur");
        for (Entry<String, String> entry : list2) {
            System.out.printf("%s - %s\n", entry.getN(), entry.getP());
        }
    }
}
