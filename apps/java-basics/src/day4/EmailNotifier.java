package day4;

public class EmailNotifier implements Notifier{
    private String email;

    public EmailNotifier(String email) {
        this.email = email;
    }

    @Override
    public void sendNotification(String message) {
        System.out.println("sent "+message+" to "+email);
    }
}
