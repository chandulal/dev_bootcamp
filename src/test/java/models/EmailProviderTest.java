package models;

import hello.models.EmailProviderFactory;
import hello.models.EmailServiceProvider;
import org.junit.Test;

/**
 * Created by chanduk on 13/05/15.
 */
public class EmailProviderTest {

    @Test
    public void testCreateEmailServiceProvider(){
        EmailServiceProvider serviceProvider  = EmailProviderFactory.getEmailServiceProvider(1);
    }
}
