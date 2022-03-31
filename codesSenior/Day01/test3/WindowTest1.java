package Day01.test3;

/**
 * ********功能：通过第二种方法多线程实现卖票
 */
class Window1 implements Runnable{
    private int ticket=100;
    @Override
    public void run() {
        while (true){
            if(ticket>0) {
                System.out.println(Thread.currentThread().getName()+"卖票：票号为" + ticket);
                ticket--;
            }
            else break;
        }
    }
}

public class WindowTest1 {
    public static void main(String[] args) {

        Window1 w1=new Window1();//共用一个对象
        Thread t1=new Thread(w1);
        Thread t2=new Thread(w1);
        Thread t3=new Thread(w1);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();
    }
}
