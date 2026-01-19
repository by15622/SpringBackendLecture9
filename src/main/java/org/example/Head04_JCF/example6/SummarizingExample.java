package org.example.Head04_JCF.example6;

import java.util.*;
import java.util.stream.Collectors;

public class SummarizingExample {
    public static void main(String[] args) {
        List<Integer> intScores = Arrays.asList(80, 95, 70, 100, 85);

        // TODO IntSummaryStatistics 구현
        IntSummaryStatistics intSummaryStatistics = intScores.stream()
                .collect(Collectors.summarizingInt(Integer::intValue));

        System.out.println("Int Summary Count = " + intSummaryStatistics.getCount());
        System.out.println("Int Summary Sum = " + intSummaryStatistics.getSum());
        System.out.println("Int Summary Min = " + intSummaryStatistics.getMin());
        System.out.println("Int Summary Max = " + intSummaryStatistics.getMax());
        System.out.println("Int Summary Average = " + intSummaryStatistics.getAverage());
    }
}