package Day01.test2;

/**
 * ********功能：线程练习
 */
class method1 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2==0) System.out.println(Thread.currentThread().getName()+" "+i+"*");
        }
    }
}
class method2 extends Thread{
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            if(i%2!=0) System.out.println(Thread.currentThread().getName()+" "+i+"#");
        }
    }
}

public class ThreadDemo {
    public static void main(String[] args) {

//        method1 method1 = new method1();
//        method2 method2 = new method2();
//        method1.start();;
//        method2.start();

        //创建Thread的匿名子类
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2!=0) System.out.println(Thread.currentThread().getName()+" "+i+"#");
                }
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                for(int i=0;i<100;i++){
                    if(i%2==0) System.out.println(Thread.currentThread().getName()+" "+i+"*");
                }
            }
        }.start();
        System.out.println(Thread.currentThread().getName()+" hello");

    }

}
