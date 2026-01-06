package org.example.Head03_OOP.example09;

public class MobilePayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("모바일 결제: " + amount + "원");
    }
}