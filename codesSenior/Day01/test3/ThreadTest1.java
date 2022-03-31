package Day01.test3;

/**
 * ********功能：实现Runnable接口
 * 1、创建一个实现了Runnable接口的类
 * 2、实现类去实现Runnable()中的抽象方法
 * 3、创建实现类的对象
 * 4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
 * 5、通过Thread类的对象调用start() （1）启动线程（2）调用当前线程的run()-->调用了Runnable类型的target的Run()
 *
 *
 * 比较线程的两种创建方式
 * 开发中，优先选择：实现Runnable接口方式
 * 原因：（1）实现的方式没有类的单继承性的局限性
 *      （2）实现的方式更适合来处理多个线程共享数据的情况
 *
 * 联系：public class Thread implements Runnable
 * 相同点：两种方式都需要重写run(),将线程执行的逻辑声明在run()中
 */

class MThread implements Runnable{
    
    @Override
    public void run() {
        for (int i = 0; i <100; i++) {
          if(i%2==0) System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

public class ThreadTest1 {
    public static void main(String[] args) {
        MThread t1 = new MThread();//创建实现类的对象
        Thread t2 = new Thread(t1);//将此对象那作为参数传递到Thread类的构造器中，创建Thread的对象
        t2.setName("线程一");
        t2.start();//通过Thread类的对象调用start() t2的线程
        Thread t3 = new Thread(t1);
        t3.setName("线程二");
        t3.start();

    }
}
