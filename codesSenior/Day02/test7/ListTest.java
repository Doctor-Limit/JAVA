package Day02.test7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ********概述：List接口-------动态数组
 *  /---ArrayList：作为List接口的主要实现类，线程不安全，效率高，底层使用Object[] elementData存储
 *  /---LinkedList：对于频繁的插入、删除操作，使用此类比Arraylist高，底层使用双向链表存储
 *  /---Vector：作为List接口的古老实现类，线程安全，效率低，底层使用Object[] elementData存储
 *
 *  ArrayList源码分析：
 *  2.1 jdk7 ArrayList arraylist=new ArrayList();底层创建了默认长度为10的Object[]数组elementData
 *           List.add(123)//elementData[0]=123;
 *           ...
 *           List.add(11) 若此次添加导致底层elementData数组容量不够，则扩容
 *           默认情况下，扩容为原来的1.5倍，同时将原数组的数据复制到新数组中
 *
 *           结论：开发中使用带参构造器，ArrayList list=new ArrayList(int capacity)
 *
 *  2.2 jdk8 ArrayList 底层Object[] elementData初始化为{}，并没有创建长度数组
 *           List.add(123)//第一次调用add()时，底层才创建了长度10的数组，并将123添加到element[0]中
 *           ...
 *           后续添加扩容操作与jdk7 相同
 *
 *  2.3 jdk7中ArrayList对象的创建类似于单例的饿汉式，jdk8中对象的创建相当于懒汉式，延缓了数组的创建，节省内存
 *
 *  3.LinkedList源码分析：
 *          LinkedList list=new LinkedList();内部声明Node类型的first和last属性，默认值为null
 *          list.add(123);将123封装到Node中，创建了Node对象
 *
 *          其中，Node定义为： 体现了双向链表的功能
 *          private static class Node<E>{
 *              E item;
 *              Node<E> next;
 *              Node<E> prev;
 *
 *              Node(Node<E>prev,E element,Node<E> next){
 *              this.item=item;
 *              this.next=next;
 *              this.prev=prev;
 *              }
 *          }
 *
 * 4.Vector源码分析：创建长度为10的数组，默认扩容为原数组的2倍。
 *
 * 同：三个类实现类List接口，存储数据特点相同，存储有序的、可重复的数据
 * 异：见上
 *
 */
public class ListTest {

    @Test
    public void test3(){
        ArrayList list=new ArrayList();
        list.add("Tom");
        list.add(123);
        list.add(34);
        list.add(false);

        //方式一
//        Iterator iterator=list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

        //方式二：
         for(Object obj : list){
             System.out.println(obj);
         }

        //方式三：
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }


    }

    /*
    增：add(Object obj)
    删：remove(int index)/remove(Object obj)
    改：set(int index,Object ele)
    查：get(int index)
    长度：size()
    遍历：(1)Iterator迭代器
         (2)foreach
     */
    @Test
    public void test2(){
        ArrayList list=new ArrayList();
        list.add("Tom");
        list.add(123);
        list.add(34);
        list.add(false);
        list.add(34);

        //int indexOf：返回obj首次出现位置，若不存在则返回-1
        int index=list.indexOf(false);
        System.out.println(index);

        //int lastIndexOf(Object obj): 返回obj在集合末次出现的位置，不存在则返回-1
        System.out.println(list.lastIndexOf(34));

        //Object remove(int index)：删除指定index位置元素，并返回被删除的元素
        System.out.println(list.remove(0));

        //Object set(int index,Object ele):设置指定index位置的元素为ele
        list.set(1,"CC");
        System.out.println(list);

        //List sublist(int fromIndex,int toIndex):返回fromIndex到toIndex位置的左闭右开子集合
        List subList = list.subList(1, 3);//不会对本身list造成影响
        System.out.println(subList);

    }

    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        list.add("Tom");
        list.add(123);
        list.add(34);
        list.add(false);
        System.out.println(list);

        //void add(int index,Object ele):在index位置插入ele元素
        list.add(1,"e");
        System.out.println(list);

        //Boolean addAll(int index,Collection ele):从index位置开始将ele的所有元素添加进来
        List list1= Arrays.asList(1,4,2);
        list.addAll(list1);
        System.out.println(list.size());

        //Object get(int index)获取指定index元素位置
        System.out.println(list.get(1));

    }
}
