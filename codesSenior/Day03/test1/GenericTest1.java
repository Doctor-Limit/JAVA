package Day03.test1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ********概述：定义泛型结构、泛型类、泛型接口、泛型方法
 *
 * 1、自定义类、泛型接口
 *
 */
public class GenericTest1 {

    @Test
    public void test3(){
        Order<String> order=new Order<>();
        Integer[] arr=new Integer[]{1,2,3,4};
        //泛型方法在调用时需指明泛型类型
        List<Integer> list=order.copyFromArrayToList(arr);
        System.out.println(list);
    }

    @Test
    public void test2(){

        //泛型不同的引用不能相互赋值
        ArrayList<String> list1=new ArrayList<>();
        ArrayList<Integer> list2=new ArrayList<>();

        //list1=list2;

        //静态方法中不能使用类的泛型  静态比泛型先创建
        //异常类不能声明为泛型类
    }

    @Test
    public void test1(){
        //若定义了泛型类，实例化没有指明类的泛型，则认为此泛型为Object类型
        //若定义了类是
        Order order=new Order();
        order.setOrderT(123);
        order.setOrderT("AA");

        //实例化时应指明泛型类型
        Order<String> order1=new Order<>("orderAA",1001,"AA");
        order1.setOrderT("AA:hello");

        //由于子类在继承带泛型的父类时，指明了泛型类型，则实例化子类对象时，不再需要指明泛型
        SubOrder order2=new SubOrder();
        order2.setOrderT(11);
    }
}
