package Day01.test6;

import java.util.concurrent.locks.ReentrantLock;

/**
 * ********概述：
 *
 */
class Salary implements Runnable {
    private int money = 0;
    private ReentrantLock lock = new ReentrantLock(true);

    @Override
    public void run() {
//    try {
//        lock.lock();
//        for(int i=0;i<3;i++){
//            Thread.sleep(100);
//            money+=1000;
//           System.out.println(Thread.currentThread().getName()+"账户内存款为："+money);
//        }
//    } catch (InterruptedException e) {
//        e.printStackTrace();
//    } finally {
//        lock.unlock();
//    }

//        for (int i = 0; i < 3; i++) {
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            money += 1000;
//            System.out.println(Thread.currentThread().getName() + "账户内存款为：" + money);
//        }
//    }
}
}

public class SalaryTest {
    public static void main(String[] args) {
        Salary s=new Salary();
        Thread t1=new Thread(s);
        Thread t2=new Thread(s);
        t1.setName("储户一");
        t2.setName("储户二");
        t1.start();
        t2.start();

    }
}
