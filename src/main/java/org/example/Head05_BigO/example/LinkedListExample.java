package org.example.Head05_BigO.example;

import java.util.LinkedList;
import java.util.List;

public class LinkedListExample {
    public static void main(String[] args) {
        // LinkedList 생성 - Node 객체들이 연결됨
        List<Integer> linkedList = new LinkedList<>();

        // 요소 추가
        linkedList.add(1); // head -> [1] <- tail
        linkedList.add(2); // head -> [1] <-> [2] <- tail
        linkedList.add(3); // head -> [1] <-> [2] <-> [3] <- tail

        // 중간 삭제 - 포인터만 변경 O(1) 하지만 찾는데에 O(n) 필요
        linkedList.remove(1); // 인덱스 1번에 해당하는 값(=2) 삭제
        System.out.println(linkedList); // 출력: [1, 3]
    }
}

// Iterator 사용하면 삭제 중 순회 가능
// Iterator<Integer> iter = linkedList.iterator();
// while(iter.hasNext()) {
// 		if(조건) iter.remove(); // 안전한 삭제
// }