package Day01.test8;

import org.junit.jupiter.api.Test;

/**
 * ********概述：String及常用类
 *
 *
 */
public class StringTest {

    /*
    1、常量与常量的拼接结果在常量池，且常量池中不会存在相同内容的常量。
    2、只要其中有一个是变量，结果就在堆中。
    3、若拼接的结果调用intern()方法,返回值就在常量池中。
     */
    @Test
    public void test3(){
        String s1="javaEE";
        String s2="hadoop";

        String s3="javaEEhadoop";
        String s4="javaEE"+"hadoop";//字面量的连接依旧在常量池中声明
        String s5=s1+"hadoop";
        String s6="javaEE"+s2;
        String s7=s1+s2;

        System.out.println(s3==s4);//true
        System.out.println(s3==s5);//false
        System.out.println(s3==s6);//false
        System.out.println(s5==s6);//false
        System.out.println(s5==s7);//false
        System.out.println(s6==s7);//false

        String s8=s5.intern();//返回值得到的s8使用的常量值中已经存在的"javaEEhadoop"
        System.out.println(s8==s3);//true

    }

    /*
    String的实例化方式
    一：通过字面量定义的方式
    二：通过new+构造器的方式

    String s=new String("abc");中创建了两个对象
    (1)堆空间中new结构（2）char[] 对应的常量池中的数据“abc”。
     */
    @Test
    public void test2(){
        //字面量定义：此时的数据s1和s2的数据声明在方法区的字符串常量池中
        String s1="javaEE";
        String s2="javaEE";

        //new+构造器：此时s3和s4保存的地址值，是数据在堆空间开辟空间后对应的地址值
        String s3=new String("javaEE");
        String s4=new String("javaEE");

        System.out.println(s1==s2);
        System.out.println(s1==s3);
        System.out.println(s3==s4);
        System.out.println("***********************");

        Person p1=new Person("tom",12);
        Person p2=new Person("tom",12);
        System.out.println(p1.name.equals(p2.name));
        System.out.println(p1.name==p2.name);//true 常量池中引用相同,只是对象地址不同

    }

    /*
    String:字符串，使用一对"来表示
    1、String为final的，不可被继承
    2、String实现了Serializable接口，表示字符串支持序列化
       实现了Comparable接口，表示String可比较大小
    3、String内部定义了final char[] value 用于存储字符串数据
    4、String：代表不可变的字符序列==》不可变性
       体现：(1)当对字符串重新赋值时，需要重写指定内存区域赋值，不能使用原有value进行赋值
            (2）当对现有的字符串进行连接操作时，也要重写指定内存区域赋值，不能使用原有的value赋值
            (3)当调用String的replace()方法修改指定字符或字符串时，也要重写指定内存区域赋值，不能使用原有的value赋值
    5、通过字面量的方式给一个字符串赋值，此时的字符串值声明在字符串常量池中
    6、字符串常量池中是不会存储相同内容的字符串的
     */
    @Test
    public void test1(){
        String s1="abc";//字面量的定义方式
        String s2="abc";
        //s1="hello";
        System.out.println(s1);
        System.out.println(s2);
        System.out.println(s1.equals(s2));
        System.out.println("*************************");

        String s3="abc";
        s3+="def";
        System.out.println(s3);

        System.out.println("************************");
        String s4="abc";
        String s5=s4.replace('a','m');
        System.out.println(s4);
        System.out.println(s5);

    }
}
