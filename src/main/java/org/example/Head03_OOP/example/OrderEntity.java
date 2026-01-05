package org.example.Head03_OOP.example;

public class OrderEntity {
    private String orderId;
    private boolean isPaid;
    private String name;

    public OrderEntity() {
        this.orderId = "NONE";
        this.isPaid = false;
    }

    public OrderEntity(String orderId, boolean isPaid) {
        this.orderId = orderId;
        this.isPaid = isPaid;
    }

    public String getOrderId() {
        return this.orderId;
    }

    public boolean getIsPaid() {
        return this.isPaid;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public void setIsPaid(boolean isPaid) {
        this.isPaid = isPaid;
    }

}