package org.example.Head05_BigO.example;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        // 중복 없는 집합 생성
        Set<String> set = new HashSet<>();

        // 요소 추가
        set.add("apple"); // 해시값 계산 -> 저장
        set.add("banana"); // 다른 위치에 저장
        set.add("apple"); // 중복 무시

        // 포함 여부 확인 -> O(1)
        System.out.println(set.contains("banana")); // true

        // 크기 확인
        System.out.println(set.size());              // 2
    }
}