package com.example.demo.javaSomething;

public class SyncLock {
    private static volatile int state = 0;

    public static void setLock(int s) {
        state = s;
    }

    public static int getState() {
        return state;
    }


}
