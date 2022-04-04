package Day01.test10;

import org.junit.jupiter.api.Test;

/**
 * ********概述：StringBuffer与StringBuilder的使用
 *
 */
public class StringBufferBuilderTest {
    /*
    String:不可变的字符序列，底层使用char[]数组存储
    StringBuffer:可变的字符序列:线程安全（效率较低），底层使用char[]数组存储
    StringBuilder:可变的字符序列:线程不安全（效率较高），底层使用char[]数组存储

    源码分析：
    String str=new String();//new char[0]
    String str1=new String("abc")//new char[]{'a','b','c'};
    StringBuffer sb1=new StringBuffer();//new char[16]底层创建了一个长度为16的数组
    此时sb1.length()=0；
    sb1.append('a');//value[0]=a;
    sb1.append('b')//value[1]=b;

    StringBuffer sb2=new StringBuffer("abc");//value=new char["abc".length()+16];
    此时sb2.length()=3;

    （1）如果添加到数据底层添加已满？
    默认情况下扩容为2倍+2，同时将原有数组中的元素复制到新的数组


   开发中建议使用StringBuffer(int capacity)或StringBuilder(int capacity)提前告知容量

     */
    @Test
    public void test1(){

        StringBuffer sb1=new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);
        StringBuffer sb2=new StringBuffer("abc");
        System.out.println(sb2.length());

    }

}
