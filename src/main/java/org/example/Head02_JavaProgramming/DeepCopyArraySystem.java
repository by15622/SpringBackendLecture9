package org.example.Head02_JavaProgramming;

import java.util.Arrays;

public class DeepCopyArraySystem {
    public static void main(String[] args) {
        int[] original = {1, 2, 3, 4, 5};
        int[] copy = new int[original.length];

        // 원본의 index 1부터 3개를 copy의 index 0부터 복사
        System.arraycopy(original, 1, copy, 0, 3);

        System.out.println("original = " + Arrays.toString(original)); // [1, 2, 3, 4, 5]
        System.out.println("copy     = " + Arrays.toString(copy));     // [2, 3, 4, 0, 0]
    }
}
