package org.example.Head04_JCF.example5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoiningExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");

        // TODO 구현
        String result = names.stream()
                .collect(Collectors.joining(", ")); // 구분자가 쉼표 + blank

        System.out.println("Formatted result: " + result);
    }
}