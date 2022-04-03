package Day01.test9;

import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * ********概述：String类及其他结构之间的转换
 */
public class StringTest1 {

    @Test
    public void test4(){
        String s1="javaEEhadoop";
        String s2="javaEE";
        String s3=s2+"hadoop";
        System.out.println(s1==s3);

        final String s4="javaEE";
        String s5=s4+"hadoop";//加上final后s4变为常量，所以依旧拼接算在常量池里操作，所以地址相同
        System.out.println(s1==s5);

    }

    //编码：字符串--》字节（看的懂--》看不懂的二进制数据）
    //解码：编码的逆过程，字节--》字符串（看不懂的二进制数据--》看的懂）
    //String与byte[]之间的转化
    //解码时要求使用的字符集必须与编码时使用的字符集一致，否则会出现乱码
    @Test
    public void test3() throws UnsupportedEncodingException {
        //编码
    String s1="abc123中国";
    byte[] bytes=s1.getBytes();//使用getBytes[]方法编码(默认的编码字符集转换)
    System.out.println(Arrays.toString(bytes));
    byte[] gbks=s1.getBytes("gbk");
    System.out.println(Arrays.toString(gbks));//输出地址的内容，否则只会返回一个地址

        //解码
        String s2=new String(bytes);//使用默认字符集解码
        System.out.println(s2);
        String s3=new String(gbks);
        System.out.println(s3);//出现乱码，编码集和解码集不同

        String s4=new String(gbks,"gbk");
        System.out.println(s4);//未出现乱码，此时编码集与解码集相同


    }

    //String与char[]的转换
    @Test
    public void test2(){
        String s1="abc123";
        char temp=' ';
        char []charArray=s1.toCharArray();//调用String的toCharArray方法转换
        for (int i = 1; i <charArray.length/2; i++) {
            temp=charArray[i];
            charArray[i]=charArray[charArray.length-1-i];
            charArray[charArray.length-1-i]=temp;
        }
        String s3=new String(charArray);
        System.out.println(s3);
//        for (int i = 0; i < charArray.length; i++) {
//            System.out.println(charArray[i]);
//        }
//        char []arr=new char[]{'h','e','l','l','o'};
//        String s2=new String(arr);
//        System.out.println(s2);
    }

    //String与基本数据类型、包装类之间的转换
    @Test
    public void test1() {
        String s1 = "123";
        int num = Integer.parseInt(s1);
        System.out.println(num);

        String s2=String.valueOf(num);
        String s3=num+"";
        System.out.println(s3);
        System.out.println(s2);
        System.out.println(s1==s3);
    }
}
