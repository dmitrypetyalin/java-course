package ru.gb.java2.task3;

import java.util.ArrayList;
import java.util.List;

/**
 * 12.05.2022 10:56
 *
 * @author PetSoft
 */
public class PhoneBook {
    private static PhoneBook phoneBook;
    private List<Entry<String, String>> list;

    private PhoneBook() {
        list = new ArrayList<>();
    }

    public static synchronized PhoneBook getInstance() {
        if (phoneBook == null) {
            phoneBook = new PhoneBook();
        }
        return phoneBook;
    }

    public void add(String name, String phoneNumber) {
        if (name == null || phoneNumber == null) throw new NullPointerException();
        if (name.equals("") || phoneNumber.equals(""))
            throw new IllegalArgumentException("Name or number shouldn't be empty!");
        list.add(new Entry<>(name, phoneNumber));
    }

    public List<Entry<String, String>> get(String name) {
        if (name == null) throw new NullPointerException();
        if (name.equals("")) throw new IllegalArgumentException("Name or number shouldn't be empty!");

        List<Entry<String, String>> pList = new ArrayList<>();
        for (Entry<String, String> stringStringEntry : list) {
            if (stringStringEntry.getN().equals(name)) {
                pList.add(stringStringEntry);
            }
        }
        return pList;
    }
}
