package Day03.test1;

import java.util.ArrayList;
import java.util.List;

/**
 * ********概述：
 */
public class Order<T>{

    String orderName;
    int orderId;

    //类的内部结构使用类的泛型
    T orderT;

    public Order(){
        //T[] arr=new T[10];编译不通过

        T[] arr=(T[]) new Object[10];

    }
    public Order(String orderName,int orderId,T orderT){
        this.orderId=orderId;
        this.orderName=orderName;
        this.orderT=orderT;
    }

    //如下方法都不是泛型方法
    public T getOrderT(){
        return orderT;
    }
    public void setOrderT(T orderT){
        this.orderT=orderT;
    }

    //泛型方法，在方法中出现了泛型的结构，泛型参数与类的泛型参数没有任何关系
    //泛型方法所属的类是不是泛型类无关

    //泛型方法，可声明为静态的，泛型参数在调用方法时决定，并非在实例化时确定
    public <E>List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list=new ArrayList<>();
        for(E e:arr){
          list.add(e);
        }
        return list;
    }

}
