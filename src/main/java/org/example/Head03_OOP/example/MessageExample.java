package org.example.Head03_OOP.example;
class Player {
    private String name;
    private int health;

    Player(String name) {
        this.name = name;
        this.health = 100;
        //여기부터 값이 고정된다. 직접적인 접근과 조작이 안됨.
    }

    // 메시지를 받으면 실행되는 메서드
    void receiveDamage(int amount) {
        health -= amount;
        //health= health-amount   결과값은 -= 왼쪽에 넣어야한다
        System.out.println(name + " received " + amount + " damage. Remaining health: " + health);
    }
}

public class MessageExample {
    public static void main(String[] args) {
        Player playerA = new Player("Alice");
        Player playerB = new Player("Bob");

        // playerA가 playerB에게 메시지 전달 → 피해를 요청
        playerB.receiveDamage(30);
        //30이라는 값을 위에 receiveDamage에 전달한다
    }
}