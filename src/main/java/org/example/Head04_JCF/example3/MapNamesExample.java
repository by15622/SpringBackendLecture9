package org.example.Head04_JCF.example3;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class MapNamesExample {
    public static void main(String[] argn) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");


        Function<String, Integer> nameLength = new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                return s.length();
            }
        };

        names.stream()
                .map(s -> {
                    return s.toUpperCase();
                })
                .forEach(System.out::println);

        //.map)s -> s.toUpperCase())     -> 원래 이거였음
        //.forEach(System.out::println);
    }
}
