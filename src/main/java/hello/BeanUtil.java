package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class BeanUtil{
    private static ApplicationContext applicationContextStatic;

    @Autowired
    private ApplicationContext applicationContext;

    @PostConstruct
    public void init(){
        BeanUtil.applicationContextStatic = applicationContext;
    }

    public static <T> T getBean(Class<T> klass) {
        return applicationContextStatic.getBean(klass);
    }
}