package Day01.test7;

import java.util.concurrent.*;

/**
 * ********概述：创建线程池
 *
 * 好处：（1）提高响应速度(减少了创建新进程的时间)
 *      （2）减低资源消耗（重复利用线程池中线程，不需要每次都创建）
 *      （3）便于线程管理
 *  corePoolSize:核心池大小
 *  maximumPoolSize:最大线程数
 *  keepAliveTime:线程没有任务时做多保持多长时间会终止
 *
 */
class NumberThread implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=100 ; i++) {
            if(i%2==0) System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class NumberThread1 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i <=100 ; i++) {
            if(i%2!=0) System.out.println(Thread.currentThread().getName()+":"+i);
        }
    }
}

class NumberThread2 implements Callable{

    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i < 20; i++) {
            if(i%2==0) System.out.println(i);
            sum+=i;
        }
        return sum;
    }
}
public class ThreadPool {
    public static void main(String[] args) {
          //提供指定线程数量的线程池
        ExecutorService service= Executors.newFixedThreadPool(10);
        ThreadPoolExecutor service1=(ThreadPoolExecutor) service;

        //设置线程池的属性
        System.out.println(service.getClass());
        service1.setCorePoolSize(15);
        //service1.setKeepAliveTime();


           //执行指定的线程的操作，需要提供实现Runnable或Callable接口实现类的对象
//        service.execute(new NumberThread());//适用于Runnable
//        service.execute(new NumberThread1());

//        FutureTask f1= (FutureTask) service.submit(new NumberThread2());
//        new Thread(f1).start();
//        try {
//            Object sum= f1.get();
//            System.out.println("总和为："+sum);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
        //  service.submit();//适用于Callable
        //关闭线程池
        service.shutdown();
    }
}
