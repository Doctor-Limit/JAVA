package Day02.test6;

import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.concurrent.Callable;

/**
 * ********概述：Collection接口中声明的方法的测试
 *
 * 向Collection接口的实现类的对象中添加数据obj时，要求obj所在类重写equals()
 *
 *
 *
 *
 */
public class CollectionTest1 {

    @Test
    public void test1(){

        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(new String("tom"));
        coll.add(false);
        coll.add(new Date());

        //contains(Object obj):判断当前集合中是否包含obj

        boolean contains=coll.contains("123");
        System.out.println(contains);
        System.out.println(coll.contains(new String("tom")));//默认比较内容而不是地址

        //containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在于当前集合中
         Collection coll1= Arrays.asList(123,456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2(){
        //remove(Object obj) 从当前集合中移除obj元素
        Collection coll=new ArrayList();
        coll.add(123);
        coll.add(new String("tom"));
        coll.add(false);

        System.out.println(coll.remove(1234));
        System.out.println(coll);

        //removeAll(Collection coll1):从当前集合中移除coll1中所有元素
        Collection coll1=Arrays.asList(123,"Tom");//只要成功删除一个就返回为真
        System.out.println(coll.removeAll(coll1));
        System.out.println(coll);

    }

    @Test
    public void test3(){
        Collection coll=new ArrayList();
        Collection coll1=Arrays.asList(123,456,"Tom");
        Collection coll2=Arrays.asList(123,456,"Tom");
        coll.add(123);
        coll.add(new String("tom"));
        coll.add(false);

        //retainAll(Collection coll1)交集 :获取当前集合与coll1集合的交集，并返回给当前集合
//        System.out.println(coll.retainAll(coll1));
//        System.out.println(coll);

        //equals(Object obj):判断当前集合和形参集合是否相同（根据建立集合的方式决定是否有序还是无序）
        System.out.println(coll1.equals(coll2));
    }

    @Test
    public void test4(){
        Collection coll=Arrays.asList(123,456,"Tom");

        //hashCode():返回当前对象的哈希值
        System.out.println(coll.hashCode());

        //集合--》数组：toArray()
        Object[] arr=coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

        //数组--》集合:Arrays类的静态方法asList()
        List strings = Arrays.asList(new String[]{"AA","BB"});
        System.out.println(strings);

        //new int[]会当成一个元素
        List arr1 = Arrays.asList(134, 256);
        System.out.println(arr1.size());

        List arr2 = Arrays.asList(new Integer[]{134, 256});
        System.out.println(arr2.size());

        //iterator():返回Iterator接口的实例，用于遍历集合元素，放在IteratorTest.java中

    }

}
