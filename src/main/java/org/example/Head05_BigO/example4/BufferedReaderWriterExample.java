package org.example.Head05_BigO.example4;

import java.io.*;

public class BufferedReaderWriterExample {
    public static void main(String[] args) {
        // 맨 처음 실행할 때를 제외하고는 주석 처리
        // try(BufferedWriter bw = new BufferedWriter(new FileWriter("example.txt"))){
        // bw.write("this is first line.";
        // bw.newLine();
        // bw.write("this is second line.";
        // bw.newLine();
        // bw.write("this is thrid line.";
        // bw.newLine();
        // } catch(IOException e) {
        //   e.printStackTrace();
        // }
        // BufferedReader로 텍스트 파일을 한 줄씩 읽는 예시
        // FileReader 를 감싸는 방식(Decorator 패턴)
        try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
            String line;

            // readLine() 을 사용해 한 줄씩 읽기
            while ((line = br.readLine()) != null) { // 한 줄씩 읽다가 파일 끝이면 null 반환
                System.out.println(line); // 한 줄씩 출력
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // BufferedWriter로 텍스트 파일에 한 줄씩 쓰는 예시
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"))) {
            bw.write("Hello File I/O");
            bw.newLine(); // 줄바꿈
            bw.write("Using BufferedWriter for better performance");
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}