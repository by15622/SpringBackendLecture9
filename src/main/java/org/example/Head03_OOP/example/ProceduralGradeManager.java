package org.example.Head03_OOP.example;
class Student {
    String name;
    int mathScore;
    int engScore;

    Student(String name, int mathScore, int engScore) {
        this.name = name;
        this.mathScore = mathScore;
        this.engScore = engScore;
    }

    double getAverage() {
        return (mathScore + engScore) / 2.0;
    }
}


public class ProceduralGradeManager {
    public static void main(String[] args) {
        String[] studentNames = {"Alice", "Bob", "Charlie"};
        int[] mathScores = {90, 80, 85};
        int[] engScores = {95, 75, 88};

        for (int i = 0; i < studentNames.length; i++) {
            int total = mathScores[i] + engScores[i];
            double average = total / 2.0;
            System.out.printf("%s 평균: %.1f\n", studentNames[i], average);
        }
    }
}


