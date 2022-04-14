package Day05.test2;

import Day01.test8.Person;
import Day05.test1.PersonData;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

/**
 * ********概述：测试Stream中间操作
 *
 */
public class StreamAPITest1 {

    @Test
    public void test1(){

        List<Person> list = PersonData.getPeople();
        Stream<Person> stream = list.stream();

        //filter(Predicate p)--接收Lambda，从流中排除出某些元素
        //控制台中输出年龄小于20的人
        stream.filter(e->e.getAge()<20).forEach(System.out::println);//此时流已关闭，需要重新创建流来使用

        System.out.println();

        //limit(n)--截断流，使其元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);
        System.out.println();

        //skip(n)--跳过元素，返回一个扔掉了n个元素的流，若流中元素不足n个，则返回空流
        list.stream().limit(20).forEach(System.out::println);
        System.out.println();

        //distinct()--筛选，通过流所生成的元素的hashCode()和equals()去除重复元素
        list.add(new Person("Tom",12));
        list.add(new Person("Tom",12));
        list.add(new Person("Tom",12));
        list.stream().limit(list.size()).forEach(System.out::println);
        System.out.println();

        list.stream().distinct().forEach(System.out::println);

    }

    @Test
    public void test2(){

        //map(Function f)--接收一个函数作为参数，将元素转化为其他形式或提取信息,该函数会被应用
        //                 到每个元素上，并将其映射成一个新的元素
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(s->s.toUpperCase(Locale.ROOT)).forEach(System.out::println);
        System.out.println();

        //1、获取姓名长度大于三的人的姓名   先返回姓名，再用过滤器过滤再输出显示
        List<Person> list1 = PersonData.getPeople();
        list1.stream().map(Person::getName).filter(s->s.length()>3).forEach(System.out::println);
        System.out.println();

        //2、
        Stream<Stream<Character>> streamStream = list.stream().map(StreamAPITest1::fromStringToStream);
        streamStream.forEach(s->{
            s.forEach(System.out::print);
        });

        System.out.println("\n");


        //flatMap(Function f)--接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连成一个流
        list.stream().flatMap(StreamAPITest1::fromStringToStream).forEach(System.out::print);

    }

    //将字符串中的多个字符构成的集合转换为对应的Stream的实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list=new ArrayList<>();
        for(Character c:str.toCharArray()) {
            list.add(c);
        }
        return list.stream();
    }

    //排序
    @Test
    public void test3(){
        //sorted()——自然排序   默认从小到大
        List<Integer> list = Arrays.asList(12, 345, 23, 15, 556, 23, 0, 1);
        list.stream().sorted().forEach(System.out::print);
        System.out.println("\n");

        //内部依旧实现的是Comparable接口

        //sorted()——定制排序
        List<Person> list1 = PersonData.getPeople();
        list1.stream().sorted((p1,p2)->{
            int ageValue= Integer.compare(p1.getAge(),p2.getAge());
            if(ageValue!=0){
                return ageValue;
            }else {
                return -Integer.compare(p1.hashCode(),p2.hashCode());
            }
        }).forEach(System.out::println);

    }

}
