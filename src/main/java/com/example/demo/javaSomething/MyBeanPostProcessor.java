package com.example.demo.javaSomething;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @author zh
 * @date 2021-03-05 17:40
 **/
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {

    public MyBeanPostProcessor() {
        System.out.println("MyBeanPostProcessor struct init");
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("oomTest".equals(beanName)) {

            System.out.println("MyBeanPostProcessor.postProcessBeforeInitialization; beanName:" + beanName);

        }
        return bean;
    }


    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if ("oomTest".equals(beanName)) {
            System.out.println("MyBeanPostProcessor.postProcessAfterInitialization; beanName:" + beanName);
        }
//        System.out.println("MyBeanPostProcessor.postProcessAfterInitialization; beanName:" + beanName);

        return bean;
    }

//    @Override
//    protected Object[] getAdvicesAndAdvisorsForBean(Class<?> beanClass, String beanName, TargetSource customTargetSource) throws BeansException {
//        System.out.println("MyBeanPostProcessor.getAdvicesAndAdvisorsForBean; beanName:" + beanName);
//        return new Object[0];
//    }

}
