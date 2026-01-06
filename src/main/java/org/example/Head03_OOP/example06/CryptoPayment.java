package org.example.Head03_OOP.example06;

public class CryptoPayment implements Payment {

    @Override
    public void pay(double amount) {
        // 크립토 결제에 필요한 로직
        System.out.println("크립토로 " + amount + "원 결제 완료.");

    }
}
