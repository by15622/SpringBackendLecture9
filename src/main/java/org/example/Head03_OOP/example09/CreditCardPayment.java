package org.example.Head03_OOP.example09;

public class CreditCardPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("신용카드 결제: " + amount + "원");
    }
}