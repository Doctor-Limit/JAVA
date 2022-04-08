package Day03.test1;

import org.junit.jupiter.api.Test;

/**
 * ********概述：定义泛型结构、泛型类、泛型接口、泛型方法
 *
 * 1、自定义类、泛型接口
 *
 */
public class GenericTest1 {

    @Test
    public void test2(){

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


    }
}
