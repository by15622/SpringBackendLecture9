package org.example.Head03_OOP.example12;

public class Outertest {
    private int instanceValue = 200;

    public class Inner {
        public void printInstanceValue() {
            System.out.println("Outertest instanceValue: " + instanceValue);

        }
    }
}
