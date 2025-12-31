package org.example.Head02_JavaProgramming;

import java.util.Arrays;

public class DeepCopyArrayCopyOf {
    public static void main(String[] args) {
        int[] original = {1, 2, 3};

        // 원본 배열 전체 복사
        int[] copy = Arrays.copyOf(original, original.length);

        copy[1] = 200;

        System.out.println("original = " + Arrays.toString(original)); // [1, 2, 3]
        System.out.println("copy     = " + Arrays.toString(copy));     // [1, 200, 3]
    }
}
