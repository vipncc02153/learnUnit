package pers.huangpy.main.sync;

public class M {

    public static void main(String[] arg){
        Integer tick = 200;
        Order newOrder = new Order();
        newOrder.setTicket(tick);

        for(int i = 0 ; i < 10 ;i ++){
            new Thread(()->{
                while(newOrder.getTicket() > 0){
                    newOrder.sale();
                }
            }).start();
        }
    }

}
