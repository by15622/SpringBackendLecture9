package org.example.Head04_JCF.example2;

import java.util.ArrayList;
import java.util.List;

public class FilterExampleLambda {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(15);
        numbers.add(20);
        numbers.add(25);
        numbers.add(30);

        numbers.stream()
                .filter(num -> num % 2 == 0)
                .forEach(num -> System.out.println("Even number: " + num));
    }
}
