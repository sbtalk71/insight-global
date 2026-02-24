package day4;

public class NotificationService {

    public void notify(Notifier notifier, String message){
        notifier.sendNotification(message);
    }
}
