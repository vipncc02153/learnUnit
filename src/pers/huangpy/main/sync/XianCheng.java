package pers.huangpy.main.sync;


class Xc implements Runnable{
    public static int chepiao = 100;
    public static String str = new String("weimeig");//提取出来提高可维护性，同时定义为static静态变量，使得str是公共的
    //如果不定义成static静态，则两个线程各自有各自的str，那么大家竞争的就不是同一个资源
    public void run(){
        while (true) {
            synchronized (str) {//若不定义为static静态，则两个线程的str是线程自己的，而不是公共的，因为这种写法，初始化的str写在了锁的外面
                if(chepiao>0){
                    System.out.println("第" + Thread.currentThread().getName() + "个车站正在卖出第" + (101-chepiao) + "张车票");
                    --chepiao;
                }else{
                    break;
                }
            }
        }
    }
}
public class XianCheng {
    public static void main(String [] args){
        Thread Xc1 = new Thread(new Xc());//模拟两个车站在卖车票，竞争共同的线程资源
        Xc1.start();
        Thread Xc2 = new Thread(new Xc());//模拟两个车站在卖车票，竞争共同的线程资源
        Xc2.start();
    }
}

