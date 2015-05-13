package models;

import hello.models.User;
import org.junit.Test;

/**
 * Created by chanduk on 13/05/15.
 */
public class UserTest {

    @Test
    public void testAddUser(){
        User user = new User(101,"Jayantha","awakenindian20@gmail.com");
    }

}
