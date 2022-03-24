package Day11.test2;

import java.util.Date;

import static org.junit.Assert.*;

/*
 ************Java中的JUnit单元测试
 *
 *1、Java类要求:此类是public   此类提供公共的无参的构造器
 *
 *2、 此类中声明单元测试方法：方法权限为public，无返回值，没有形参
 *3、此单元测试方法上需要声明注解，@Test,并引入对应包
 *
 *
 *
 *
 */
public class JUnitTestTest {

    @org.junit.Test
    public void testEquals() {
        String s1="MM";
        String s2="MM";
        System.out.println(s1.equals(s2));

//
//        Object obj=new String("GG");
//        Date date=(Date) obj;


    }
}