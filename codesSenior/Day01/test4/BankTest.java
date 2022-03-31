package Day01.test4;

/**
 * ********概述：使用同步机制将单例中的懒汉式改写为线程安全的
 *
 *
 *
 */

class Bank{

private Bank(){}
private static Bank instance=null;

public static  Bank getInstance(){//静态方法：当前类本身
//    synchronized (Bank.class) {
//        //方式一：效率差-->已经新建完成后就不需要再进入比较
//        if(instance==null) instance=new Bank();
//        return instance;
//    }
        //方式二：效率更高--》后面的线程不需要再进行比较
    if(instance==null) {
        synchronized (Bank.class) {
            if (instance == null) instance = new Bank();
        }
    }
    return instance;
  }

}

public class BankTest {

}
