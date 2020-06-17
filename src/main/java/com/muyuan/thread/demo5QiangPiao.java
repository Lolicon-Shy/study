package com.muyuan.thread;

public class demo5QiangPiao implements Runnable{

    private int Piao=1000;

    public void run() {

        while (true){
            if (Piao<=0){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"--->拿到了第"+Piao--+"张票");
        }
    }

    public static void main(String[] args) {
        demo5QiangPiao demo = new demo5QiangPiao();
        new Thread(demo,"小明").start();
        new Thread(demo,"大明").start();
        new Thread(demo,"中黑").start();
    }
}
