package hello.models;

/**
 * Created by chanduk on 13/05/15.
 */
public class Sms implements Notification {
    @Override
    public void sendNotification() {
        System.out.println("SMS sent");
    }
}
