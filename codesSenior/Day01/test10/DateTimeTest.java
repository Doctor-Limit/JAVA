package Day01.test10;

import org.junit.jupiter.api.Test;
import java.util.Date;

/**
 * ********概述：JDK8之前日期与时间的API测试
 */
public class DateTimeTest {
    /*
    java.util.Data类
             |--java.sql.Data类：对应数据库中日期类型的变量

    1、两个构造器的使用
    构造器一：Date（）：创建一个对应当前时间的Date对象
    构造器二：创建指定毫秒数的Date对象
    2、两个方法的使用
     >toString:显示当前年月日时分秒
     >getTime:获取当前Date对象对应的毫秒数。（时间戳）

    3、 java.sql.Data类：对应数据库中日期类型的变量
        >如何实例化
        >java.util.Date对象--->java.sql.Date对象

     */
    @Test
    public void test3(){
        java.sql.Date date1=new java.sql.Date(1649038096375l);
        System.out.println(date1);//仅打印年月日

        //java.util.Date对象--->java.sql.Date对象
        Date date2=new Date();//无法强转，new的就是一个父类对象
        java.sql.Date date3=new java.sql.Date(date2.getTime());
        System.out.println(date3);
    }

    @Test
    public void test2(){
        //构造器一：Date（）：创建一个对应当前时间的Date对象
        Date date1=new Date();
        System.out.println(date1.toString());//Mon Apr 04 10:03:43 CST 2022
        System.out.println(date1.getTime()); //返回当前时间与1970年1月1日之间以毫秒为单位的时间差:1649038096375

         //构造器二：创建指定毫秒数的Date对象
        Date date2=new Date(1649038096375l);
        System.out.println(date2.toString());
    }

    @Test
    public void test1(){
        long time=System.currentTimeMillis();
        //返回当前时间与1970年1月1日之间以毫秒为单位的时间差-->时间戳
        System.out.println(time);
    }
}
