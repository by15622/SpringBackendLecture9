package org.example.Head05_BigO.example2;

import java.util.ArrayList;
import java.util.List;

// T extends Shape: Shape를 구현한 타입만 담을 수 있는 컨테이너
// 일반 <T> 였다면 T에 대해 아무 메서드도 호출할 수 없음
public class ShapeContainer<T extends Shape> {
    private List<T> shapes = new ArrayList<>();

    public void add(T shape) {
        shapes.add(shape);
    }

    // T가 Shape의 하위 타입임이 보장되므로 getArea() 메서드를 안전하게 호출 가능
    public double totalArea() {
        double sum = 0;
        for (T s : shapes) {
            // T extends Shape 덕분에
            // 컴파일러가 s가 반드시 getArea() 를 가지고 있음을 알 수 있음
            sum += s.getArea();
        }
        return sum;
    }
}