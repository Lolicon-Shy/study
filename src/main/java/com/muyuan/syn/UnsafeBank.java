package com.muyuan.syn;

//两个人同事取钱
public class UnsafeBank {
    public static void main(String[] args) {
        Account account = new Account(1000,"结婚基金");

        Drawing you = new Drawing(account,50,"你");
        Drawing girlFriend = new Drawing(account,100,"girlFriend");

        you.start();
        girlFriend.start();
    }


}

class Account{
    int money;
    String name;
    public Account(int money,String name){
        this.money = money;
        this.name= name;
    }
}

class Drawing extends Thread{
    Account account;//账户

    int drawingMoney;

    int nowMoney;

    public Drawing (Account account,int drawingMoney , String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    //取钱
    @Override
    public void run() {

        synchronized (account   ){
            if (account.money-drawingMoney<0){
                System.out.println(Thread.currentThread().getName()+"钱不够，取不了");
                return;
            }

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //卡内余额
            account.money=account.money-drawingMoney;

            nowMoney = nowMoney+ drawingMoney;

            System.out.println(account.name+"余额为："+account.money);

            System.out.println(this.getName()+"手里的钱："+nowMoney);

        }


    }
}
