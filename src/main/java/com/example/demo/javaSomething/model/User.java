package com.example.demo.javaSomething.model;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author zh
 * @date 2021-03-05 16:58
 **/

public class User implements InitializingBean, BeanNameAware, ApplicationContextAware {

    private Integer age;
    private String name;
    private String tel;
    private String province;
    private String county;

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Invoke User setBeanName name:" + name);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Invoke User afterPropertiesSet");

    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("Invoke User setApplicationContext");
    }
}
