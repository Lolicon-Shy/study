package com.muyuan.state;

public class TestState {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(()->{
           for (int i=0;i<5;i++){
               try {
                   Thread.sleep(100);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
            System.out.println("/////////");
        });

        Thread.State state = thread.getState();
        System.out.println(state);

        thread.start();
        state = thread.getState();

        while (state!= Thread.State.TERMINATED){//只要线程不中止就一直输出
            Thread.sleep(100);
            state=thread.getState();
            System.out.println(state);
        }

        thread.start();
    }
}
