package com.example.demo.jvmSomething;

import com.example.demo.javaSomething.model.User;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceTest {
    public void test() {
        Object a = new Object();
        ReferenceQueue<Object> queue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(a, queue);
        System.out.println(a);//java.lang.Object@548c4f57
        System.out.println(phantomReference.get());//null
        System.out.println(queue.poll());//null
        System.out.println("-------------------");
        a = null;
        System.gc();
        System.out.println(a);//null
        System.out.println(phantomReference.get());//null
        //引用在回收之前被加入到了引用队列中
        System.out.println(queue.poll());//java.lang.ref.WeakReference@74a14482
    }
    public static void main(String[] args) {
        new PhantomReferenceTest().test();
    }

    public void testJVMStackReference() {
        User a = new User();
        User b = new User();
        a = null;
    }
}
