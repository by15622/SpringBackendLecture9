package org.example.Head03_OOP.example12;

public class Outer {
    private static int staticValue = 100;
    private int instanceValue = 50;
    // 멤버변수2개 지정

    // 정적 중첩 클래스
    public static class StaticNested {
        public void printValues() {
            // 외부 클래스의 static 멤버에는 직접 접근 가능
            System.out.println("Outer.staticValue: " + staticValue);

            // 외부 클래스의 인스턴스 멤버에는 직접 접근 불가능
            // System.out.println(instanceValue); // 컴파일 에러
        }   // 위대로 주석없애고 쓰면 에러뜸
    }
}
