package org.example.Head05_BigO.example4;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapToTextFileExample {
    public static void main(String[] args) {

        Map<String, Integer> stockMap = new HashMap<>();
        stockMap.put("apple", 10);
        stockMap.put("banana", 20);
        stockMap.put("cherry", 30);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("stock.txt"))) {

            for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
                bw.write(entry.getKey() + " " + entry.getValue());
                bw.newLine();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}