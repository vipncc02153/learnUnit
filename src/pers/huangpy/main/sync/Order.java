package pers.huangpy.main.sync;

import java.util.concurrent.TimeUnit;

public class Order{

    private volatile Integer ticket;

    public Integer getTicket() {
        return ticket;
    }

    public void setTicket(Integer ticket) {
        this.ticket = ticket;
    }

    public synchronized void sale(){
        if (ticket > 0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票---->" + (this.ticket--));
        }else{
            System.out.println(Thread.currentThread().getName() + "卖完了");
        }
    }

}
