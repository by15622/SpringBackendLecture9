package org.example.Head03_OOP.example06;

public class Order {
    private Payment payment;

    public Order(Payment payment) {
        this.payment = payment;
    }

    public void process(double amount) {
        payment.pay(amount);
    }
}