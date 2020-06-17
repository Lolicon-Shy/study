package com.muyuan.thread;

public class FindGirlFriend implements Runnable{
    private static String winner;
    public void run() {
        for (int i =0;i<=100;i++){
            if(Thread.currentThread().getName().equals("找不到")&& i%10==0){
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            boolean flag = gameOver(i);
            if (flag){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"的几率是"+i+"%");
        }
    }
    public boolean gameOver(int bu){
        if (winner!=null){
            return true;
        }else {
            if (bu>=100){
                winner = Thread.currentThread().getName();
                System.out.println("我能再一个月内找到女朋友吗？");
                System.out.println(winner);
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        FindGirlFriend demo = new FindGirlFriend();
        new Thread(demo,"找不到").start();
        new Thread(demo,"能找到").start();
    }
}
