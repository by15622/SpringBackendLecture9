package org.example.Head04_JCF.example2;

import java.util.Arrays;
import java.util.List;

public class StreamBasicExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Tom", "Jerry", "Kim", "Tommy");

        names.stream()
                .filter(name -> name.startsWith("T"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
    }

}
