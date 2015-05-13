package hello.models;

/**
 * Created by chanduk on 13/05/15.
 */

interface Notification{
        public void sendNotification();
        }

public class Email implements Notification{

    @Override
    public void sendNotification() {
        System.out.println("Email Sent");
    }
}

