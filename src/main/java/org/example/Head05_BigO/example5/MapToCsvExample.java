package org.example.Head05_BigO.example5;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MapToCsvExample {
    public static void main(String[] args) {
        Map<String, Integer> stockMap = new HashMap<>();
        stockMap.put("apple", 10);
        stockMap.put("banana", 20);
        stockMap.put("cherry", 30);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("stock.csv")))
        {
            bw.write("key,value");
            bw.newLine();

            for (Map.Entry<String, Integer> entry : stockMap.entrySet()) {
                String key = entry.getKey();
                int value = entry.getValue();

                if(key.contains(",") || key.contains("\"") || key.contains("\n")) {
                    key = "\"" + key.replace("\"", "\"\"") + "\"";
                }

                bw.write(key + "," + value);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}