package org.example.Head03_OOP.example08;

public class PaymentServiceTest {
    public static void main(String[] args) {
        UserAccount account = new UserAccount("ACC001");
        PaymentService service = new PaymentService();

        account.deposit(10000);
        System.out.println("초기 입금 완료. 잔액: " + account.getBalance());

        try {
            account.deposit(-5000);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 (음수 입금): " + e.getMessage());
        }

        try {
            service.processPayment(account, -3000);
        } catch (IllegalArgumentException e) {
            System.out.println("예외 발생 (음수 출금): " + e.getMessage());
        }

        try {
            service.processPayment(account, 50000);
        } catch (IllegalStateException e) {
            System.out.println("예외 발생 (잔액 부족): " + e.getMessage());
        }

        // 4. 정상 결제 + 환불
        service.processPayment(account, 3000);
        service.processRefund(account, 3000);
    }
}