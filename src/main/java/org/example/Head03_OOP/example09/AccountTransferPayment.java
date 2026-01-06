package org.example.Head03_OOP.example09;

public class AccountTransferPayment implements Payment {
    @Override
    public void pay(double amount) {
        System.out.println("계좌이체 결제: " + amount + "원");
    }
}