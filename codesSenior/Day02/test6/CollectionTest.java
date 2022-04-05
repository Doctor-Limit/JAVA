package Day02.test6;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ********概述：集合框架
 * 1、集合、数组都是对多个数据进行存储操作的结构，简称java容器
 *   说明：主要指的是内存层面的存储，不涉及到持久化的存储(.txt,.jpg,.avi,数据库的存储)
 *
 * 2、数组在存储多个数据方面的特点：
 *    >初始化以后，长度确定
 *    >需要指明元素类型（类型无法改变）
 *  缺点：初始化后长度无法修改
 *       数组中提供方法有限，对于添加、删除、修改、插入数据等操作较为不便，效率较低。
 *       获取数组中实际元素个数，没有现成属性或方法可用
 *       数组存储数据有序、可重复。对于无序、不可重复的需求无法满足
 *
 * 集合框架：
 *   /-----Collection接口：单列集合，用来存储一个一个的对象
 *     /----List接口：存储有序的、可重复的数据    ---》“动态”数组
 *         /---ArrayList LinkedList Vector
 *     /----Set接口：存储无序的、不可重复的数据    ---》数学中的“集合”
 *         /---HashSet LinkedHashSet TreeSet
 *
 *   /-----Map接口：双列集合，用来存储一对((x)key-value(y))一对的数据
 *                                  ---》函数 y=f(x) 多个不同key对应同一个value
 *     /---HashMap LinkedHashMap TreeMap HashTable Properties
 *
 * Collection接口中的方法及其使用
 *
 */

public class CollectionTest {

    @Test
    public void test1(){
        Collection coll=new ArrayList();

        //add(Object e) 将元素e添加到集合coll中
        coll.add("aa");
        coll.add("123");//自动装箱
        coll.add(new Date());

        //size():获取添加元素的个数
        System.out.println(coll.size());

        //addAll():将coll1集合中的元素添加到当前的集合中
        Collection coll1=new ArrayList();
        coll1.add(456);
        coll1.add(coll);
        coll.addAll(coll1);
        System.out.println(coll);

        //clear():清空集合元素
        coll.clear();

        //isEmpty():判定是否为空
        System.out.println(coll.isEmpty());

    }
}
