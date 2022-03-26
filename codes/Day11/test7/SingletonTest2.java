package Day11.test7;

//懒汉式单例 用的时候再新建对象
public class SingletonTest2 {
    public static void main(String[] args) {
       Order o1=Order.getInstance();
       Order o2=Order.getInstance();

       System.out.println(o1==o2);
    }
}

class Order{
    //私有化构造器
    private Order(){
    }

    //声明当前类对象,但并不创建
    private static Order instance=null;

    //
    public static Order getInstance(){
        if(instance==null) instance=new Order();
        return instance;
    }
}


