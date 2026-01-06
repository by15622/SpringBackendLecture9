package org.example.Head03_OOP.example08;

public class UserAccountTest {
    private final String accountId;
    private double balance;

    public UserAccountTest(String accountId) {
        if (accountId == null || accountId.isBlank()) {
            throw new IllegalArgumentException("계좌 ID는 필수입니다.");

        }
        this.accountId = accountId;
        this.balance = 0;
    }
    public String getAccountId() {
        return accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("입금 금액은 0보다 커야 합니다.");
        }
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("출금 금액은 0보다 커야 합니다.");
        }
        if (balance < amount) {
            throw new IllegalStateException("잔액 부족: 현재 잔액 = " + balance);
        }
        balance -= amount;
    }
}