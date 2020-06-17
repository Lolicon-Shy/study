package com.muyuan.thread;

public class demo3implRunable implements Runnable{

    public void run() {
        for (int i = 0; i<20;i++){
            System.out.println("我是runable"+i);
        }
    }

    public static void main(String[] args) {
        demo3implRunable demo3implRunable = new demo3implRunable();
        Thread thread = new Thread(demo3implRunable);
        thread.start();

        for (int i = 0;i<200;i++){
            System.out.println(i);
        }
    }
}
