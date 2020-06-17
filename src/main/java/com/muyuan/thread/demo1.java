package com.muyuan.thread;

public class demo1 extends Thread{

    @Override
    public void run() {
        for (int i = 0; i<20 ;i++){
            System.out.println("美阳今年"+i+"岁了");
        }
    }

    public static void main(String[] args) {
        demo1 demo1 = new demo1();
        demo1.start();


        for (int i = 0; i<2000 ; i++){
            System.out.println("gun");
        }

    }
}
