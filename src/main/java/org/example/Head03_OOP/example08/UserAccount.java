package org.example.Head03_OOP.example08;

public class UserAccount {
    private final String accountId;   // 계좌 고유 ID
    private double balance;           // 계좌 잔액 (외부에 직접 공개하지 않음)

    public UserAccount(String accountId) {
        if (accountId == null || accountId.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 계좌 ID입니다.");
        } //왜 else를 안쓰는지 생각해봐
        this.accountId = accountId;
        this.balance = 0.0;  // 초기 잔액은 0
    }

    // 입금 로직
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("입금 금액은 0보다 커야 합니다.");
        }
        balance += amount; // balance = balance + amount;
        System.out.println("계좌 [" + accountId + "]에 " + amount + "원 입금. 현재 잔액: " + balance + "원");
    }

    // 출금 로직
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("출금 금액은 0보다 커야 합니다.");
        }
        if (balance < amount) {
            throw new IllegalStateException("잔액이 부족합니다. 현재 잔액: " + balance + "원");
        }
        balance -= amount; //balance = balance - amount;
        System.out.println("계좌 [" + accountId + "]에서 " + amount + "원 출금. 남은 잔액: " + balance + "원");
    }

    // 읽기 전용 접근자 (외부에서 잔액을 확인할 수만 있음)
    public double getBalance() {
        return balance;
    }

    public String getAccountId() {
        return accountId;
    }
}