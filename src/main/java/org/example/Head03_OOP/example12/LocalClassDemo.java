package org.example.Head03_OOP.example12;

public class LocalClassDemo {
    public void executeTask() {
        final int taskId = 999;  // Java 8 이후로는 사실상 final이면 가능


        class LocalWorker {
            public void run() {
                System.out.println("LocalWorker started with taskId = " + taskId);
            }
        }

        LocalWorker worker = new LocalWorker();
        worker.run();
    }

    public static void main(String[] args) {
        LocalClassDemo demo = new LocalClassDemo();
        demo.executeTask();
    }
}