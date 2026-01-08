package org.example.Head03_OOP.example15;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        List<String> fruits = new ArrayList<>();

        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");
        System.out.println("After add: " + fruits);

        String firsFruit = fruits.get(0);
        System.out.println("First Fruit: " + firsFruit);

        fruits.remove(1);
        System.out.println("after remove index: 1 " + fruits);


        System.out.println("List size: " + fruits.size());

        fruits.clear();
        System.out.println("After clear: " + fruits);

    }
}
