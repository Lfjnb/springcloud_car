package com.jk.utils;



import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;


@Component
public class DubboShiroUtil implements ApplicationContextAware{

    private static ApplicationContext context = null;

    public static <T> T getBean(Class<T> type) {
        return context.getBean(type);
    }

    public static <T> T getBean(String name, Class<T> type) {
        return context.getBean(name, type);
    }



    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.err.println("SpringBeanFactoryUtils be inited...+++++++");
        if (DubboShiroUtil.context == null) {
            DubboShiroUtil.context = applicationContext;
        }
    }
}

