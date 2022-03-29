package Day01.test2;

import com.sun.tools.javac.Main;

/**
 * ********功能：测试Thread类中常用方法
 * 1、start():启动当前线程：调用当前线程的run()
 * 2、run():通常需要重写Thread类中的此方法，将创建的线程要执行的操作声明到此方法中
 * 3、currentThread():静态方法，返回执行当前代码的线程
 * 4、getName():获取当前线程的名字
 * 5、setName():设置当前线程的名字
 * 6、yield():释放当前cpu的执行权(但可能下一刻又是当前进程分配到执行权)
 * 7、join():在线程A中调用线程B的join(),此时A进入阻塞状态,直到B线程执行完，A才结束阻塞状态(分配到执行权才可继续执行)
 * 8、stop():已过时，不建议使用   强制结束线程
 * 9、sleep(long milltime):让当前线程睡眠指定milltime毫秒，在指定的milltime毫秒时间内，当前进程为阻塞状态(依旧结束
 *                          阻塞状态后需要等待cpu分配执行权)
 * 10、isAlive():判定该线程是否存活
 *
 *
 * 线程优先级(1~10)
 *  1.MAX_PRIORITY:10 MIN_PRIORITY:1 NORMAL_PRIORITY:5(默认优先级)
 *  2.如何获取和设置当前线程的优先权：
 *     获取：getPriority()
 *     设置: setPriority(int p)
 *   高优先级的线程要抢占低优先级线程cpu的执行权，但是只是从概率上讲，高优先级的线程高概率的情况下被执行，并不意味着
 *   只有当高优先级线程执行完后，低优先级的线程才执行
 */

class HelloThread extends Thread{

    @Override
    public void run() {
        for(int i=0;i<100;i++){//不能抛异常，因为子类抛出的异常不能比父类更大(此时被重写类未抛出异常)
            try {
                sleep(10);//ms为单位
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(i%2==0) System.out.println(Thread.currentThread().getName()+" "+i+"*");
        }
    }
    public HelloThread(String name){
        super(name);
    }

}

public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("Thread:1");
   //     h1.setName("线程一");//在启动之前，否则无法修改
        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        Thread.currentThread().setName("主线程");
        for(int i=0;i<100;i++){
            if(i%2==0) System.out.println(Thread.currentThread().getName()+
                    Thread.currentThread().getPriority()+" "+i+"#");
            if(i==20) {
                try {
                    h1.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }
        System.out.println(h1.isAlive());
    }
}
