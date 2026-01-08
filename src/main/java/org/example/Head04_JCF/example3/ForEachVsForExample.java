package org.example.Head04_JCF.example3;

import java.util.Arrays;
import java.util.List;

public class ForEachVsForExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6);

        // 전통적인 for
        System.out.println("=== Using for loop ===");
        for (int i = 0; i < numbers.size(); i++) {
            if(numbers.get(i) % 2 != 0) {
                continue; // 홀수 건너뛰기
            }
            System.out.println("Even number: " + numbers.get(i));
        }

        // 향상된 for
        System.out.println("=== Using enhanced for ===");
        for (Integer num : numbers) {
            if (num % 2 != 0) {
                continue;
            }
            System.out.println("Even number: " + num);
        }


        // 스트림 forEach
        System.out.println("=== Using Stream filter + forEach ===");
        numbers.stream()
                .filter(n -> n % 2 == 0)  //짝수만 통과
                .forEach(n -> System.out.println("Even number: " + n));
    }
}