package Day01.test4;

/**
 * ********功能：线程安全的处理
 *
 * 1、卖票过程中，出现重票、错票情况。--》线程的安全问题
 * 2、原因：当某个线程操作车票的过程中，尚未操作完成时，其他线程参与进来，也操作车票。--》车票==共享数据
 * 3、解决办法：当一个线程A操作ticket的时候，其他线程不能参与进来，直到线程A操作完ticket后，其他线程
 *            才可以操作ticket，即使线程A出现阻塞也不会改变。
 * 4、在JAVA中，通过同步机制来解决线程安全问题。
 *
 *    方式一：
 *    synchronized(同步监视器){
 *        //需要被同步的代码
 *    }
 *    1、操作共享数据的代码即为需要被同步的代码--》不能包含代码过多或过少
 *    2、共享数据：多个线程共同操作的变量   ticket为共享数据
 *    3、同步监视器：锁--》任何一个类的对象，都可以充当锁
 *      ！！！要求：多个线程必须共用同一把锁
 *    在实现Runnable接口创建多线程的方式中，我们可以考虑用this充当同步监视器
 *    然而在继承Thread类创建多线程的方式中，慎用this充当同步监视器，考虑使用当前类充当同步监视器
 *
 *    方式二：
 *     如果操作共享数据的代码完整的声明在一个方法中，我们不妨将其方法声明为同步的。
 *
 *
 *
 *
 *
 *
 * 5、同步解决了线程的安全问题--益处
 *    操作同步代码只能有一个线程参与，其他线程等待，相当于一个单线程，效率低--局限性
 *
 *
 */

class Window1 implements Runnable{
    private int ticket=100;
    Object obj=new Object();
    @Override
    public void run() {
        while (true){
            //此时的this：唯一的当前Window的实例对象
            synchronized(this){//synchronized(obj){
                if (ticket > 0) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                    ticket--;
                } else break;
            }
        }
    }
}
public class WindowTest2 {
    public static void main(String[] args) {

        Window1 w=new Window1();
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
