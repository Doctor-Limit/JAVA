package Day05.test1;

import Day01.test8.Person;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * ********概述：
 * Stream关注的是对数据的运算，与CPU产生交流
 *   集合关注的是数据的存储，与内存相关
 *
 * Stream 自己不会存储元素
 * Stream 不会改变源对象，相反会返回一个持有结果的新Stream
 * Stream 操作是延时执行的，需要等到需要结果的时候才会执行
 *
 *
 * Stream执行流程
 *   (1)Stream的实例化
 *   (2)一系列的中间操作(过滤、映射...)
 *   (3)终止操作
 *
 * 1、一个中间操作链，对数据源的数据进行处理
 * 2、一旦执行终止操作，就执行中间操作链，并产生结果，之后，中间操作链不会再被使用
 *
 */
public class StreamAPITest {

    //通过集合创建Stream
    @Test
    public void test1(){
        List<Person> list=PersonData.getPeople();
        //default Stream<E> stream():返回一个顺序流
        Stream<Person> stream = list.stream();


        //default Stream<E> parallelStream():返回一个并行流
        Stream<Person> stream1 = list.parallelStream();

    }

    //通过数组创建Stream
    @Test
    public void test2(){

        int[] arr=new int[]{1,2,3,4,5,6};
        //调用Arrays类的static<T> Stream<T> stream(T[] array):返回一个流
        IntStream stream = Arrays.stream(arr);

        Person p1=new Person("Tom",12);
        Person p2=new Person("Jack",21);
        Person[] people=new Person[]{p1,p2};
        Stream<Person> stream1 = Arrays.stream(people);

    }

    //通过Stream的of()方法创建Stream
    @Test
    public void test3(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5, 6);
        Stream<Person> personStream = Stream.of(new Person("Tom", 12), new Person("Jack", 21));

    }

    //创建无限流创建Stream
    @Test
    public void test4(){

        //迭代
        //public static<T> Stream<T> iterate(final T seed,final UnaryOperator<T> f)

        //遍历前十个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::print);

        System.out.println();
        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)
        Stream.generate(Math::random).limit(10).forEach(System.out::print);

    }


}
