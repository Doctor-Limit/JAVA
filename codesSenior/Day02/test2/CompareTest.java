package Day02.test2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * ********概述：
 * 1、java中对象，正常情况下，只能比较：==或！=，不能使用>或<
 *   开发中，需要对多个对象进行排序，比较对象大小通过两个接口之一：
 *   Comparable或Comparator
 * 2、Comparable接口的使用
 *
 */
public class CompareTest {

    /*Comparable接口的使用
    1、像String、包装类等实现了Comparable接口，重写了compareTo()方法，给出了比较两个对象大小的方式
    2、像String、包装类重写compareTo()，进行了从小到大的排序
    3、重写compareTo(obj)的规则
       若当前对象this大于形参对象obj，则返回正整数。
       若当前对象this小于形参对象obj，则返回负整数。
       若当前对象this等于形参对象obj，则返回零。

     */
    @Test
    public void test1(){
        String[] str1=new String[]{"AA","DD","EE","JJ","GG","ZZ","MM"};
        Arrays.sort(str1);
        System.out.println(Arrays.toString(str1));
    }

}
