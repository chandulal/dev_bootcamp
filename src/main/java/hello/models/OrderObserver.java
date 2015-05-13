package hello.models;

/**
 * Created by chanduk on 13/05/15.
 */

interface Observer {

    //method to update the observer, used by subject
    public void update();

    //attach with subject to observe
    public void setSubject(Subject sub);
}

public class OrderObserver implements Observer {
    private String orderDetail;
    private Subject order;

    @Override
    public void setSubject(Subject sub) {
        this.order=sub;
    }
    @Override
    public void update() {
        Email email = new Email();
        Sms sms = new Sms();
        orderDetail = (String) order.getEmailDetails(this);
        if(orderDetail != null){
            order.sendNotification(email);
            order.sendNotification(sms);
        }
    }

}
