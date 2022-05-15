package ru.gb.java2.task3;

import java.util.*;

/**
 * 12.05.2022 20:03
 *
 * @author PetSoft
 */
public class ListOfWords {
    private List<String> list;

    {
        list = new ArrayList<>();
        for (int i = 0; i <= 15; i++) {
            list.add(String.valueOf(i));
        }
        list.add(1, "11");
        list.add(5, "13");
        list.add(10, "0");
        list.add(3, "2");
        list.add(7, "7");
        list.add("11");
    }

    public List<String> uniqueList() {
        List<String> arrayList = new ArrayList<>();
        for (String s : list) {
            if (!arrayList.contains(s)) {
                arrayList.add(s);
            }
        }
        return arrayList;
    }

    public Map<String, Integer> mapOfDuplicates() {
        Map<String, Integer> map = new HashMap<>();
        for (String key : list) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        return map;
    }

    public void print() {
        System.out.println(Arrays.toString(list.toArray()));
    }
}
