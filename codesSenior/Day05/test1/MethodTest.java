package Day05.test1;


import Day01.test8.Person;
import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;


/**
 * ********概述：方法引用的使用
 * 场景：当要传递给Lambda体的操作，已经有实现的方法了，就可使用方法引用
 *
 * 方法引用本质上就是Lambda表达式，Lambda表达式作为函数式接口的实例，
 * 所以方法引用，也就是函数式接口的实例
 *
 * 使用格式：类（对象） :: 方法名
 * （1）对象::非静态方法
 * （2）类::静态方法
 * （3）类::非静态方法
 *      当两个参数对应着第一个参数作为第二个方法的调用者时才可进行格式三引用
 *
 *
 * 要求：接口中的抽象方法的形参列表和返回值类型与方法引用的方法的形参列表和返回值类型相同
 *      （对于情况一和情况二）
 *
 */
public class MethodTest {

    //Consumer中的void accept(T t)  PrintStream中的void println(T t)
    //对象::实例方法
    @Test
    public void test1(){
        Consumer<String> c1=str-> System.out.println(str);
        c1.accept("kunkun");

        PrintStream ps=System.out;
        Consumer<String> c2=ps::println;
        c2.accept("caijikun");

    }

    //Supplier 中的get()
    //Person中的String getName()
    @Test
    public void test2(){
        Person p1=new Person("Tom",22);
        Supplier<String> s1=()->p1.getName();
        System.out.println(s1.get());

        //等价于
        Supplier<String> s2=p1::getName;
        System.out.println(s2.get());
    }

    //类::静态方法
    //Comparator中的int compare(T t1,T t2)
    //Integer中的int compare(T t1,T t2)
    @Test
    public void test3(){
        Comparator<Integer> c1=((o1, o2) -> Integer.compare(o1,o2));
        System.out.println(c1.compare(12, 21));

        Comparator<Integer> c2=Integer::compare;
        System.out.println(c2.compare(21, 12));

    }

    //Function 中的R apply(T t1)
    //Math 中的long round(Double d)
    @Test
    public void test4(){
        Function<Double,Long> fun1=d->Math.round(d);

        Function<Double,Long> fun2=Math::round;
        System.out.println(fun1.apply(3.2));
        System.out.println(fun2.apply(4.2));

    }

    //类::实例方法
    //Comparator中的int compare(T t1,T t2)
    //String 中的int t1.compareTo(t2)
    @Test
    public void test5(){
        Comparator<Integer> c1=(o1,o2)->o1.compareTo(o2);
        System.out.println(c1.compare(12,21));

        Comparator<String> c2=String::compareTo;
        System.out.println(c2.compare("12", "21"));

    }

    //BiPredicate 中的boolean test(T t1,T t2)
    //String 中的boolean t1.equals(t2)
    @Test
    public void test6(){
        BiPredicate<String,String> b1=(o1,o2)->o1.equals(o2);
        System.out.println(b1.test("12", "21"));

        BiPredicate<String,String> b2=String::equals;
        System.out.println(b2.test("12", "21"));

    }

    //Function中的R apply(T t1)
    //Person中的String getName()
    @Test
    public void test7(){
        Person p1=new Person("Tom",21);
        Function<Person,String> f1=e->e.getName();
        System.out.println(f1.apply(p1));

        Function<Person,String> f2=Person::getName;
        System.out.println(f2.apply(p1));

    }

}
