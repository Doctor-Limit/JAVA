package Day02.test8;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ********概述：Set接口框架
 *  /----Set接口：存储无序的、不可重复的数据    ---》数学中的“集合”
 *       /---HashSet :作为Set接口的主要实现类，线程不安全的，可存储null值
 *         /---LinkedHashSet :作为HashSet的子类，遍历其内部数据时，可按照添加顺序遍历
 *                            对于频繁的遍历，LinkedHashSet效率高于HashSet
 *       /---TreeSet:可以按照添加的对象的指定属性，进行排序
 *
 * 1、Set接口中无额外方法，都是父类Collection的方法
 * 2、向Set中添加的数据其所在的类一定要重写hashcode()和equals()
 *    重写两个方法尽量保持一致性，相等的对象必须具有相等的散列码
 *    对象中用作equals()方法比较的Field，都用来计算hashCode
 *
 */
public class SetTest {

    /*
    Set:无序性 不等于随机性
    存储的数据在底层数组中并非按照数组索引的顺序添加，而是根据数据的哈希值确定
    Set：不可重复性
    保证添加的元素按照equals()判断时，不能返回true，相同的元素只能添加一个

    HashSet添加元素的过程：
    我们向HashSet添加元素a，首先调用元素a所在类的hashCode（）方法，计算元素a的哈希值，此哈希值接着通过
    某种算法计算出在HashSet底层数组中的存放位置（即为索引位置），判断数组此位置上是否已有元素
         若此位置上无其他元素，元素a添加成功--->情况1
         若此位置上有其他元素b(或以链表形式存在的多个元素)，则比较元素a与元素b的哈希值
             若哈希值不相同，则元素a添加成功--->情况2
             若哈希值相同，需要调用a所在类的equals()方法：
                 equals()返回true，元素a添加失败
                 equals()返回false，元素a添加成功--->情况3

    对于添加成功的情况2和情况3，元素a与已经存在指定索引位置上数据以链表的方式存储
    jdk7：元素a放到数组中，指向原来的元素
    jdk8：原来的元素在数组中，指向元素a

    HashSet 底层：数组+链表形式存储
     */
    @Test
    public void test1(){
        Set set=new HashSet();
        set.add("Tom");
        set.add(123);
        set.add(false);
        set.add(345);

        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet根据添加顺序遍历
    //作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个与
    //后一个数据
    @Test
    public void test2(){
        Set set=new LinkedHashSet();
        set.add("Tom");
        set.add(123);
        set.add(false);
        set.add(345);

        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
