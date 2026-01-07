package org.example.Head03_OOP.example12;

public class Maint {
    public static void main(String[] args) {

        Outertest outer = new Outertest();
        Outertest.Inner inner = outer.new Inner();
        inner.printInstanceValue();
    }
}