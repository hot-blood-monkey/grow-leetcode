package com.example.demo.JVM;

import com.alibaba.fastjson.JSON;
import sun.misc.Launcher;

import java.net.URL;

public class ClassLoadInitProcess {

    public static void main(String[] args) {
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(JSON.toJSON(url));
        }
    }

}
