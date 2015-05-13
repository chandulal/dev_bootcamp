package hello.models;

public interface EmailServiceProvider{
    void sendMail();
}

class Google implements EmailServiceProvider{
    int serviceProviderId = 1;
    String status = "DeActive";

    @Override
    public void sendMail() {

    }
}

class Yahoo implements EmailServiceProvider{
    int serviceProviderId = 2;
    String status = "Active";

    @Override
    public void sendMail() {

    }
}