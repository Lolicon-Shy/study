package com.muyuan.state;

public class demo1 implements Runnable{

    private Boolean flag = true;


    public void run() {
        int i = 0;
        while (flag){
            System.out.println("run......Thread"+i++);
        }
    }

    public void stop(){
        this.flag = false;
    }

    public static void main(String[] args) {
        demo1 d= new demo1();

        new Thread(d).start();

        for (int i=0;i<=1000;i++){
            System.out.println("mian"+i);
            if (i==900){
                d.stop();
                System.out.println("该线程终止了");
            }
        }
    }
}
