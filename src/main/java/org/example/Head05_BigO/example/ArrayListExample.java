package org.example.Head05_BigO.example;

import java.util.ArrayList;
import java.util.List;

public class ArrayListExample {
    public static void main(String[] args) {
        // ArrayList - 내부적으로 object[] 배열 사용
        List<String> list = new ArrayList<>();

        // 배열 끝에 추가, O(1)
        list.add("Apple");
        list.add("Banana"); // [Apple, Banana]
        System.out.println(list.get(1)); // 출력: Banana

        // 중간 삭제 -> 뒤의 요소를 다 한칸씩 앞으로 이동 O(n)
        list.remove(0);
        System.out.println(list); // 출력: [Banana]

        // 맨 끝에서 삭제 O(1)
        // list.remove(list.size() -1);
    }
}