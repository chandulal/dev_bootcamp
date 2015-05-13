package hello.models;

/**
 * Created by chanduk on 13/05/15.
 */
public class User {
    private int userId;
    private String userName;

    public String getEmail() {
        return email;
    }

    private String email;
    public User(int userId, String userName, String email) {
        this.userId=userId;
        this.userName=userName;
        this.email=email;
    }
}
