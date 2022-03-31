package Day01.test4;

/**
 * ********功能：使用同步代码块解决继承Thread类的方式的线程安全问题
 *
 */
class Dog{
}
class Window2 extends Thread{
    private static int ticket=100;
    static Dog dog=new Dog();
    @Override
    public void run() {
        while (true){
            synchronized(Window2.class){//类也可以作为对象，类只会加载一次
           //synchronized(dog){// synchronized(this)不行，对象不同
            if(ticket>0) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖票，票号为：" + ticket);
                ticket--;
            }else break;
            }
        }
    }
}
public class WindowTest3 {
    public static void main(String[] args) {

        Window2 w1=new Window2();//三个类会生成三把锁
        Window2 w2=new Window2();
        Window2 w3=new Window2();
        w1.setName("窗口一");
        w2.setName("窗口二");
        w3.setName("窗口三");
        w1.start();
        w2.start();
        w3.start();

    }

}
