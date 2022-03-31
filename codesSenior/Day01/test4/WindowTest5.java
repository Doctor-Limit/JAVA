package Day01.test4;

/**
 * ********概述：使用同步方法继承Thread类
 *
 * 总结：（1）同步方法依旧涉及到同步监视器，只是不需要显式声明
 *      （2）非静态同步方法，同步监视器：this   静态方法，同步监视器：当前类本身
 *
 */
class Window4 extends Thread{
    private static int ticket=100;
    static boolean isFlag=true;
    @Override
    public void run() {
        while (isFlag){
                show();
            }
    }
    private static synchronized void show(){//静态：同步监视器Window4.class
   // private synchronized void show(){//对象不同 同步监视器：w1,w2,w3
        if(ticket>0) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
            ticket--;
        }else isFlag=false;
    }
}
public class WindowTest5 {
    public static void main(String[] args) {

        Window4 w1=new Window4();//三个类会生成三把锁
        Window4 w2=new Window4();
        Window4 w3=new Window4();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();
    }

}

