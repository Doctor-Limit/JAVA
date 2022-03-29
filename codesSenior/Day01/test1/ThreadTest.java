package Day01.test1;

/**
 * ********功能：关于线程的测试
 * 创建一个继承于Thread类的子类
 * 重写thread中的run()-->将此线程执行的操作声明在run（）中
 * 创建Thread类的子类的对象
 *通过此对象调用start()
 */

//创建继承于thread的子类
class MyThread extends Thread{
    //重写run方法
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%10==0)
                System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

//不能通过直接调用run()方法的方式启动线程
//不可以让已经start（）的线程去执行第二次start（），只能再创建其他对象来创建新线程

public class ThreadTest {
    public static void main(String[] args) {

        //创建thread类的子类的对象
        MyThread t1 = new MyThread();//主线程创造

        //通过此对象调用start（）:（1）启动当前线程（2):调用当前线程的run（）
        t1.start();
        // t1.run();//只是主线程调用方法，并未开启另一个线程

        //依旧在main线程中执行
        for(int i=0;i<100;i++){
            if(i%10==0)
                System.out.println(Thread.currentThread().getName()+"*************"+i);
        }
    }

}
