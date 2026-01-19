package org.example.Head05_BigO.example3;

import java.util.List;

public class PrinterBeforeGenericMethod {
    // 타입마다 거의 동일한 메서드를 반복 작성
    // 새로운 타입이 추가되면 또 메서드를 추가로 만들어야 함

    public void printStringList(List<String> list) {
        for (String s : list) {
            System.out.println("String: " + s);
        }
    }

    public void printIntegerList(List<Integer> list) {
        for (Integer i : list) {
            System.out.println("Integer: " + i);
        }
    }

    public void printUserList(List<User> list) {
        for (User u : list) {
            System.out.println("User: " + u.getName());
        }
    }
}