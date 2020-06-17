package com.muyuan.gaoji;

//管程法
public class TestPC {

    public static void main(String[] args) {
        Syncontainner containner = new Syncontainner();

        new Productor(containner).start();
        new Consumer(containner).start();
    }

}

class Productor extends Thread{
    Syncontainner containner;

    public Productor(Syncontainner containner){
        this.containner = containner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("生产了"+i+"只鸡");
            containner.push(new Chicken(i));
        }
    }
}

class Consumer extends Thread{
    Syncontainner containner;

    public Consumer(Syncontainner containner){
        this.containner = containner;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println("消费了-->"+containner.pop().id+"只鸡");
        }
    }
}

class Chicken{
    int id;
    public Chicken(int id){
        this.id = id;
    }
}

class Syncontainner{

    Chicken [] chickens = new Chicken[10];

    int count = 0;
    //生产者放入产品
    public synchronized void push(Chicken chicken){
        //如果容器满了就需要等待消费
        if (count == chickens.length){
            //通知消费者，生产等待
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        //如果没有满，我们就需要丢入产品
        chickens [count] = chicken;
        count++;

        this.notifyAll();
    }


    //消费者消费产品
    public synchronized Chicken pop(){
        if(count == 0 ){
            //等待生产者生产
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        count--;
        Chicken chicken = chickens [count];
        this.notifyAll();
        return chicken;

    }



}