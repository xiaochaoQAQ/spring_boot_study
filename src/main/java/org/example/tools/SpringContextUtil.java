package org.example.tools;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ApplicationObjectSupport;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil extends ApplicationObjectSupport {
    public <T> T getBean(Class<T> clazz) {
        ApplicationContext ac = getApplicationContext();
        if(ac == null){
            return null;
        }
        return ac.getBean(clazz);
    }
}
