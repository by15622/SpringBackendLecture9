package org.example.Head03_OOP.example11;

public class DipTest {
    public static void main(String[] args) {
        NotificationSender[] notificationSenders = new NotificationSender[]{
                new EmailNotificationSender(),
                new SmsNotificationSender()
        };
        for (NotificationSender notificationSender : notificationSenders) {
            NotificationService notificationService = new NotificationService(notificationSender);
            notificationService.notify("Hi Hi");
        }
    }
}
