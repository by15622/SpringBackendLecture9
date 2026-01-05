package org.example.Head03_OOP.example;

public class Order {
    private String orderId;
    private boolean isPaid;

    public Order() {
        this.orderId = "NONE";
        this.isPaid = false;
    }

    public Order(String orderId , boolean isPaid){
        this.orderId = orderId;
        this.isPaid = isPaid;
    }

    public String getOrderId(){
        return this.orderId;
    }

    public boolean getIsPaid(){
        return this.isPaid;
    }

    public void setOrderId(String orderId){
        this.orderId = orderId;
    }

    public void setIsPaid(boolean isPaid){
        this.isPaid = isPaid;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }
//getter or setter 생성 법 실습
}