package Day01.test4;

/**
 * ********功能：使用同步方法解决实现Runnable接口的线程
 *
 *
 *
 *
 */

class Window3 implements Runnable{
    private int ticket=100;
    boolean isFlag=true;
    @Override
    public void run() {
        while (isFlag) {
            show();
            }
        }
        private synchronized void show(){ //同步监视器：this

            if (ticket > 0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                ticket--;
            }
            else isFlag=false;
        }
}
public class WindowTest4 {
    public static void main(String[] args) {

        Window3 w=new Window3();
        Thread t1=new Thread(w);
        Thread t2=new Thread(w);
        Thread t3=new Thread(w);
        t1.setName("窗口一");
        t2.setName("窗口二");
        t3.setName("窗口三");
        t1.start();
        t2.start();
        t3.start();

    }
}
