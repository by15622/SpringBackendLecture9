package org.example.Head03_OOP.example;

import java.util.ArrayList;
import java.util.List;

public class Ordertest2 {
    private String orderId;
    private List<Product> products;
    private boolean isPaid;

    // 기본 생성자
    public Ordertest2() {
        this.orderId = "NONE";
        this.products = new ArrayList<>();
        this.isPaid = false;
    }

    // 오버로딩된 생성자
    public Ordertest2(String orderId, List<Product> products) {
        this.orderId = orderId;
        this.products = products;
        this.isPaid = false;
    }

    // this() 호출 예시
    public Ordertest2(String orderId) {
        this(orderId, new ArrayList<>());
    }

    //getter 생성 법 실습
}