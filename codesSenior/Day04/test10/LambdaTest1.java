package Day04.test10;

import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * ********概述：
 *
 * (o1,o2)->Integer.compare(o1,o2);
 * 格式：
 *    ->:lambda的操作符或箭头操作符
 *    ->左边：lambda形参列表（接口中抽象方法的形参列表）
 *    ->右边：lambda体(重写的抽象方法的方法体)
 *
 * Lambda表达式的使用
 *
 * Lambda表达式的本质：作为函数式接口的实例
 *
 *    ->左边：lambda形参列表的参数类型可以省略(类型推断),如果lambda形参列表只有一个参数，其一对()也可省略
 *    ->右边：lambda体使用一对{}包裹，若lambda体只有一条执行语句(可能是return语句)，可省略这一对{}及return关键字
 *
 * 如果一个接口中只声明了一个抽象方法，该接口就称为函数式接口
 *
 * @FunctionalInterface
 * 注解为函数式接口
 *
 *
 */
public class LambdaTest1 {

    //格式一：无参，无返回值
    @Test
    public void test1(){
        Runnable r1=()->System.out.println("无参无返回值");
        r1.run();
    }

    //格式二:有参无返回值
    @Test
    public void tes2(){
        Consumer<String> consumer=new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println("wuhu");
            }
        };
       consumer.accept("kksk");

       Consumer<String> consumer1=(String s)-> {System.out.println("区别:"+s);};
       consumer1.accept("无");
    }

    //数据类型可省略，因为可有编译器推断得出，称为类型推断
    @Test
    public void test3(){
        Consumer<String> c1=(s -> {//类型推断
            System.out.println(s);
        });
        c1.accept("kunkun");
    }

    //lambda若只需要一个参数时，参数小括号可省略
    @Test
    public void test4(){

        Consumer<String> c1=s -> {
            System.out.println(s);
        };
        c1.accept("kunkun");
    }

    //lambda需要两个或以上的参数，多条执行语句，并可有返回值
    @Test
    public void test5(){
        Comparator<Integer> c1=((o1, o2) -> {
            System.out.println(o1);
            System.out.println(o2);
            return o1.compareTo(o2);
        });
        System.out.println(c1.compare(12, 21));
    }

    //当lambda体只有一句语句时，return与大括号若有，都可以省略
    @Test
    public void test6(){
        Comparator<Integer> c1=(o1,o2)-> o1.compareTo(02);
        System.out.println(c1.compare(12,21));
    }

}
