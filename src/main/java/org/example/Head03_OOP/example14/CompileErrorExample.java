package org.example.Head03_OOP.example14;

import java.io.FileReader;

public class CompileErrorExample {
    public static void main(String[] args) {
        try {
            FileReader reader = new FileReader("test.txt");
        } catch (Exception e) {
            System.out.println("파일을 찾을 수 없습니다.");
        } // catch랑 throws랑 비교하는거 공부해야함
    }
}