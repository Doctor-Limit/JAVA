package Day02.test1;

import org.junit.jupiter.api.Test;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * ********概述：jdk 8之前的时间日期的API测试
 * 1、System类中的currentTimeMillis();
 * 2、java.util.Date和子类java.sql.Date
 * 3、SimpleDateFormat
 * 4、Calender
 *
 */
public class DateTimeTest {
/*
SimpleDateFormat的使用：SimpleDateFormat对日期和Date类的格式化和解析
1.1：格式化 日期--》字符串
1.2：解析 格式化的逆过程 字符串--》日期

2.SimpleDateFormat的实例化

 */
   @Test
    public void testSimpleDateTest() throws ParseException {
       //实例化SimpleDateFormat：使用默认的构造器
       SimpleDateFormat sdf = new SimpleDateFormat();
       //通过带参数的构造器格式化和解析
       SimpleDateFormat sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
       SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

       //格式化：日期--》字符串
       Date date=new Date();
       String format = sdf.format(date);
       String format1=sdf1.format(date);
       String format2=sdf2.format(date);
       System.out.println(date);
       System.out.println(format);
       System.out.println(format1);
       System.out.println(format2);

       //解析：格式化的逆过程 字符串--》日期
      String str="2022/4/4 下午2:51";//格式要确保正确,否则会抛异常
      Date date1 = sdf.parse(str);
      Date date2 =sdf2.parse("2022-02-18 11:48:32");//格式要与构造器格式对应,无则要与默认对应
      System.out.println(date1);
      System.out.println(date2);
   }

   @Test
    public void test1() throws ParseException {
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       String str="2021-11-23";
       Date date=sdf.parse(str);
       System.out.println(date.getTime());
       java.sql.Date date1=new java.sql.Date(date.getTime());//以毫秒数构建日期
       System.out.println(date1);
   }
   //三天打渔两天晒网 1990-01-01开始 求 xxxx-xx-xx 打渔？晒网

   @Test
    public void test2() throws ParseException {
       SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
       Date date1=sdf.parse("1990-01-01");
       long time1=date1.getTime();
       String s1="2020-09-08";
       Date date2=sdf.parse(s1);
       long time2=date2.getTime();
       long time=time2-time1;
       long day=(time/(86400000)+1)%5;
       if(day==1||day==2||day==3) System.out.println("打渔");
       else if(day==0||day==4) System.out.println("晒网");
   }

   /*
Calender日历类(抽象类)的使用

    */
   @Test
   public void test3(){
      //1、实例化
      //方式一：创建其子类（GregorianCalender）的对象
      //方式二：调用其静态方法getInstance()
      Calendar calendar=Calendar.getInstance();
      //System.out.println(calendar.getClass());

      //常用方法
      //get()
      int days=calendar.get(Calendar.DAY_OF_MONTH);
      System.out.println(days);
      System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

      //set()
      calendar.set(Calendar.DAY_OF_MONTH,22);
      System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

      //add()
      calendar.add(Calendar.DAY_OF_MONTH,3);//现有基础上加上
      System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

      //getTime()
      Date date1 = calendar.getTime();
      System.out.println(date1);

      //setTime()  Date-->日历类
      Date date2=new Date();
      calendar.setTime(date2);
      System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

   }
}
