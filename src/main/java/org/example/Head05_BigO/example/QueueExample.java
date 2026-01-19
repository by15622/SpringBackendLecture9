package org.example.Head05_BigO.example;

import java.util.LinkedList;
import java.util.Queue;

public class QueueExample {
    public static void main(String[] args) {
        // 대기줄 시뮬레이션
        Queue<String> queue = new LinkedList<>();

        // 손님들이 줄을 섬
        queue.offer("A"); // A가 처음 도착
        queue.offer("B"); // B가 두번째 도착

        // 첫번째 손님 처리
        System.out.println(queue.poll()); // 출력: A -> A 처리되어 나감
        System.out.println(queue.peek()); // 출력: B -> B는 아직 대기
    }
}