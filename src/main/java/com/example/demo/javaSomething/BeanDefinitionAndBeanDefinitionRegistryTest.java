package com.example.demo.javaSomething;

import com.example.demo.javaSomething.proxy.UserManagerImpl;
import com.example.demo.javaSomething.model.User;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.annotation.AnnotatedGenericBeanDefinition;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.ChildBeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

/**
 * @author zh
 * @date 2021-03-05 22:35
 **/

public class BeanDefinitionAndBeanDefinitionRegistryTest {


    public static void registerBean() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        BeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(UserManagerImpl.class);
        beanFactory.registerBeanDefinition("userManagerImpl", beanDefinition);


        UserManagerImpl userManager = (UserManagerImpl) beanFactory.getBean("userManagerImpl");
        userManager.addUser("zhou", "ff");
    }


    public static void populateBeanWithPropertyValues() {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        BeanDefinition beanDefinition = new AnnotatedGenericBeanDefinition(User.class);
        beanFactory.registerBeanDefinition("user", beanDefinition);

        MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
        mutablePropertyValues.addPropertyValue(new PropertyValue("name", "proxy"));
        mutablePropertyValues.addPropertyValue(new PropertyValue("age", "25"));
        mutablePropertyValues.addPropertyValue(new PropertyValue("name", "zhou"));

        BeanDefinition beanDefinition2 = new ChildBeanDefinition("user", mutablePropertyValues);
        beanFactory.registerBeanDefinition("user2", beanDefinition2);
        Object o = beanFactory.getBean("user2");


    }


    public static void main(String[] args) {
        registerBean();
        populateBeanWithPropertyValues();
    }
}
