package org.example.Head04_JCF.example5;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CollectSquareEvenExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(2, 4, 4, 5, 10, 2);

        // TODO 구현 > 짝수 선별, 제곱 변환, 중복 제거, 리스트로 수집 수행
        List<Integer> processed = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .distinct()
                .collect(Collectors.toList());

        System.out.println("Processed list: " + processed);
    }
}