package Day11.test7;
/*
*************************单例设计模式
* 1、采取一定的方法保证整个软件系统中，对某个类只存在一个对象实例
* 2、饿汉式  懒汉式
* 3、区别：
*   饿汉式：对象加载时间过长(弊端)  线程安全(益处)
*   懒汉式：延迟对象的创建(益处)    线程不安全(弊端)
*
 */
//饿汉式单例  提前就新建好
public class SingletonTest1 {
    public static void main(String[] args) {

        Bank bank1=Bank.getInstance();
        Bank bank2=Bank.getInstance();//只存在一个实例对象，没有新建，所以二者地址相同

        System.out.println(bank1==bank2);
    }
}
class Bank{

    //私有化构造器:不允许从外面创建对象
    private Bank(){
    }

    //内部创建类的静态对象(静态允许直接调用，不需要创建对象)
    private static Bank instance=new Bank();

    //提供公共静态方法，返回类的对象
    public static Bank getInstance(){
        return instance;
    }

}














