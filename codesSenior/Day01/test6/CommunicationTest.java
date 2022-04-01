package Day01.test6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ********概述：使用两个线程打印1-100，线程1、线程2交替打印
 *
 *************************线程通信
 * wait():一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify():一旦执行此方法，就会唤醒被wait的一个进程，若有多个线程被wait，就唤醒优先级最高的进程
 * notifyAll():一旦执行此方法，就会唤醒所有被wait的进程
 *
 * 说明：（1）三个方法必须使用在同步代码块或同步方法中
 *      （2）三个方法的调用者必须是同步代码块或同步方法中的同步监视器，
 *          否则，会出现IllegalMonitorStateException异常
 *      （3）三个方法定义在Object类中，任何对象充当同步监视器时都可调用
 *
 *
 * sleep()和wait()方法的异同
 *  相同点：一旦执行方法，都可以使得当前的线程进入阻塞状态
 *  不同点：（1）两个方法声明位置不同，Thread中声明sleep(),Object类中声明wait()
 *        （2）调用的要求不同，sleep()可以在任何需要的场景下调用，wait()方法必须使用在同步代码块或同步方法中
 *         (3)是否释放同步监视器：若两个方法都用在同步代码块或同步方法中，sleep方法不会释放锁，而wait方法会释放锁
 *
 */

class Number implements Runnable{
    private int number=1;
    private ReentrantLock lock=new ReentrantLock(true);
    @Override
    public  void run() {
//     while (true){
//            try {
//                lock.lock();
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }finally {
//                lock.unlock();
//            }
//            if(number<=100){
//                System.out.println(Thread.currentThread().getName()+":"+number);
//                number++;
//            }else break;
//        }
     while (true){
         synchronized (this){
             notify();//唤醒另外一个线程
             if(number<=100){
                 try {
                     Thread.sleep(100);
                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
                 System.out.println(Thread.currentThread().getName()+":"+number);
                 number++;
                 try {
                     wait();//使调用wait()方法的线程进入阻塞状态  此时会释放锁

                 } catch (InterruptedException e) {
                     e.printStackTrace();
                 }
             }else break;
         }
     }
    }
}

public class CommunicationTest {

    public static void main(String[] args) {
        Number number=new Number();
        Thread t1=new Thread(number);
        Thread t2=new Thread(number);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();

    }

}
