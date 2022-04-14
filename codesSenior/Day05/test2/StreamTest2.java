package Day05.test2;

import Day01.test8.Person;
import Day05.test1.PersonData;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * ********概述：Stream的终止操作
 *
 */
public class StreamTest2 {

    //匹配与查找
    @Test
    public void test1(){
        List<Person> list = PersonData.getPeople();

        //allMatch(Predicate p)--检查是否匹配所有元素  全部返回真才为真
        //1、是否所有人年龄大于20
        System.out.println(list.stream().allMatch(p -> p.getAge() > 20));

        //anyMatch(Predicate p)--检查是否存在一个满足  有一个为真即为真
        //2、是否有人年龄小于18
        System.out.println(list.stream().anyMatch(p -> p.getAge() < 18));

        //noneMatch(Predicate p)--检查是否没有匹配的元素
        //3、是否没有人叫Tom
        System.out.println(list.stream().noneMatch(p -> p.getName().equals("Tom")));

        //findFirst():返回第一个元素
        Optional<Person> first = list.stream().findFirst();//Optional类型 容器类
        System.out.println(first);

        //findAny():找任意一个元素
        System.out.println(list.parallelStream().findAny());
        //stream顺序流顺序不会改变
        //parallelStream并发流每次的顺序可能都在变


    }

    @Test
    public void test2(){

        List<Person> list = PersonData.getPeople();
        //count--返回流中元素总个数  返回值为long型
        System.out.println(list.stream().filter(p -> p.getAge() > 18).count());

        //max(Comparator c)--返回流中最大值
        //1、返回名字哈希值最大的哈希值
        System.out.println(list.stream().map(p -> p.getName().hashCode()).max(Integer::compare));

        //min(Comparator c)--返回流中最小值
        //2、返回年龄最小的人
        System.out.println(list.stream().min((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge())));
        System.out.println();

        //forEach(Consumer c)--内部迭代
        list.stream().forEach(System.out::println);

        //集合的内部迭代
        list.forEach(System.out::println);

    }

    @Test
    public void test3(){
        //reduce(T identity,BinaryOperator)--可以将流中元素反复结合得到一个值,返回
        //1、计算1-10的自然数和
        List<Integer> list= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        System.out.println(list.stream().reduce(0, Integer::sum));


        //reduce(BinaryOperator)--可以将流中元素反复结合得到一个值,返回Optional<T>
        //计算年龄总和
        List<Person> p1 = PersonData.getPeople();
        System.out.println(p1.stream().map(Person::getAge).reduce(Integer::sum));
        System.out.println(p1.stream().map(Person::getAge).reduce((i1, i2) -> i1 + i2));

    }

    //收集
    @Test
    public void test4(){
        //collect(Collector c)--将流转化为其他形式，接受一个Collector接口的实例，用于给Stream转化
        //1、查找年龄大于20的人并返回一个List或Set
        List<Person> list = PersonData.getPeople();
        list.stream().filter(p->p.getAge()>20).collect(Collectors.toList()).forEach(System.out::println);
        System.out.println();

        list.stream().filter(p->p.getAge()>20).collect(Collectors.toSet()).forEach(System.out::println);

    }


}
