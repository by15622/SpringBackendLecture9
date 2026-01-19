package org.example.Head05_BigO.example2;

import java.util.ArrayList;
import java.util.List;

public class WildCardProducerExample {
    // List<? extends Shape>의 예시: List<Circle>, List<Rectangle>, List<Shake>
    public static void printAllShapes(List<? extends Shape> shapes) {
        // 읽기는 가능: 모든 요소가 최소한 Shape임이 보장됨
        for (Shape s : shapes) {
            System.out.println(s.getArea());
        }
        // shapes.add(new Circle(2.0)); // 컴파일 에러. ? extends Shape에 삽입 불가능
    }

    public static void main(String[] args) {
        List<Circle> circleList = new ArrayList<>();
        circleList.add(new Circle(3.0));
        circleList.add(new Circle(4.0));
        circleList.add(new Circle(5.0));

        printAllShapes(circleList); // OK. Circle is-a Shape

        // Rectangle 리스트도 전달 가능
        // List<Rectangle> recList = new ArrayList<>();
        // printAllShape(rectList);
    }
}