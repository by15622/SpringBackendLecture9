package org.example.Head04_JCF.example3;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class MapEntryTransformationExample {
    public static void main(String[] args) {

        Map<String, Integer> scores = new HashMap<>();
        scores.put("Kim", 90);
        scores.put("Lee", 85);
        scores.put("Park", 92);

        Function<Map.Entry<String,Integer>, String> entryToString =

        new Function<Map.Entry<String,Integer>, String>() {

            public String apply(Map.Entry<String, Integer> e) {
                return e.getKey() + ": " + e.getValue();
            }
        };

        scores.entrySet().stream()
                .map(entryToString)
                .forEach(result -> System.out.println("Student Info: " + result));

    }

}
