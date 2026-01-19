package org.example.Head05_BigO.example;

import java.util.HashMap;
import java.util.Map;

public class HashMapExample {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        map.put("apple", 1000);      //apple -> hash -> 저장
        map.put("banana", 1500);     //banana -> 다른 위치
        map.put("apple", 1200);      //같은 key -> 값 덮어쓰기

        System.out.println(map.get("apple"));

        System.out.println(map.containsKey("banana"));
    }
}

