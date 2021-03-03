package com.example.demo.Java;

import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author zh
 * @date 2021-02-27 17:25
 **/

public class ExtendDemo {

    static class A {

    }


    static class A1 extends A {

    }

    static class B {

    }


    public static void main(String[] args) {
        List<? super A> list = Lists.newArrayList();
        A1 a1 = new A1();
        list.add(a1);
    }
}
