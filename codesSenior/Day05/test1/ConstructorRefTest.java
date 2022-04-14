package Day05.test1;

import Day01.test8.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * ********概述：
 *
 * 构造器引用
 *      方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致。
 *      抽象方法的返回值类型即为构造器所属的类的类型
 *
 * 数组引用
 *     可把数组看做一个特殊的类，写法与构造器引用一致
 *
 *
 */
public class ConstructorRefTest {

    //构造器引用
    //supplier中的T get()
    //Person的空参构造器:Person
    @Test
    public void test1(){
        Supplier<Person> s1=()->new Person("Tom",21);

        Supplier<Person> s2=Person::new;

        System.out.println(s1.get());
        System.out.println();
        System.out.println(s2.get());

    }

    //Function中的R apply(T t1)
    @Test
    public void test2(){
        BiFunction<String,Integer,Person> b1=(name,age)->new Person(name,age);
        System.out.println(b1.apply("Tom",21));

        BiFunction<String,Integer,Person> b2=Person::new;
        System.out.println(b2.apply("Jack", 12));
    }

    //数组引用
    @Test
    public void test3(){
        Function<Integer,String[]> f1=length->new String[length];
        String[] a1=f1.apply(5);
        System.out.println(Arrays.toString(a1));

        Function<Integer,String[]> f2=String[]::new;
        String[] a2=f2.apply(10);
        System.out.println(Arrays.toString(a2));

    }

}
