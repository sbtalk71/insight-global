package day4;

public class NotificationMain {
    public static void main(String[] args) {
        NotificationService notificationService=new NotificationService();

        Notifier notifier=new EmailNotifier("admin@admin.com");

        notificationService.notify(notifier,"Hello There!");

        notificationService.notify(notifier,"Hi");


    }
}
