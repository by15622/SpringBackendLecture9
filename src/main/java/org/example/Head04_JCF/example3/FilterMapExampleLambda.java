package org.example.Head04_JCF.example3;

import java.util.HashMap;
import java.util.Map;


public class FilterMapExampleLambda {
    public static void main(String[] args) {
        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 90);
        scores.put("Lee", 75);
        scores.put("Park", 88);

        scores.entrySet().stream()
                .filter(entry -> entry.getValue() >= 80)
                .forEach(entry -> System.out.println("High Scorer: " + entry.getKey() + " => " + entry.getValue()));

    }
}