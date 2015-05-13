package hello.models;

/**
 * Created by chanduk on 13/05/15.
 */

public class EmailProviderFactory {

    public static EmailServiceProvider getEmailServiceProvider(int serviceProviderId){
        if(serviceProviderId == 1){
            System.out.println("In google");
            return new Google();
        }else if (serviceProviderId == 2)
        {
            System.out.printf("In Yahoo");
            return new Yahoo();
        }
        return null;
    }

}
