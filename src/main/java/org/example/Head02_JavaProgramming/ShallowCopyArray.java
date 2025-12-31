package org.example.Head02_JavaProgramming;

public class ShallowCopyArray {
    public static void main(String[] args) {
        int[] original = {1, 2, 3};
        int[] copy = original;
        copy[0] = 100;
        System.out.println(original[0]); // 100
    }
}