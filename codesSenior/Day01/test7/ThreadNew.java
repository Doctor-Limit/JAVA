package Day01.test7;

import java.util.concurrent.*;

/**
 * ********概述：实现Callable接口
 *
 *
 * 实现callable方式创建多线程比实现runnable方式更好：
 * （1）call（）具有返回值
 * （2）call（）可抛出异常，被外面操作捕获，获取异常信息
 * （3）call（）支持泛型
 *
 */
//创建一个实现Callable的实现类
class NumThread implements Callable{
    //实现call方法，将此线程需要执行的操作声明在call()中
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 1; i <=100 ; i++) {
             if(i%2==0){
                 System.out.println(i);
                 sum+=i;
             }
        }
        return sum;
    }
}
public class ThreadNew {
    public static void main(String[] args) {
        //创建callable接口实现类的对象
        NumThread n1=new NumThread();
        //将此callable接口实现类的对象传递到FutureTask构造器中，创建FutureTask的对象
        FutureTask f1 = new FutureTask(n1);//实现Callable接口
        //将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start()方法
        new Thread(f1).start();
        try {
            //获取callable中call方法的返回值
        Object sum= f1.get();//get()返回值即为FutureTask构造器参数实现call()重写后的返回值
        System.out.println("总和为"+sum);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
