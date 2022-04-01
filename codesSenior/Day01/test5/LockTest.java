package Day01.test5;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ********概述：方式三 Lock锁
 *
 * synchronized 与lock异同
 * 相同点：都可以用来解决线程安全问题
 * 不同点：synchronized机制在执行完相应的同步代码后，自动释放同步监视器
 *       lock需要手动启动同步(lock()),同时结束同步也需要手动的实现(unlock())
 *
 *
 * 解决线程安全方式：（1）同步代码块（2）同步监视器（3）lock方法
 *
 */
class Window implements Runnable{

    private int ticket=100;
    private ReentrantLock lock=new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try{
                //调用lock()
                lock.lock();
            if(ticket>0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"售票，票号为："+ticket);
            ticket--;}else break;
        }finally {
                  //调用解锁：unlock()
                lock.unlock();
            }
        }
    }
}

public class LockTest {
    public static void main(String[] args) {
        Window w=new Window();

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
