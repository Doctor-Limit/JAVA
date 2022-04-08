package Day02.test9;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ********概述：
 * /-----Map接口：双列集合，用来存储一对((x)key-value(y))一对的数据
 *                                  ---》函数 y=f(x) 多个不同key对应同一个value
 *     /---HashMap:作为Map的主要实现类，线程不安全，效率高，存储null的key和value
 *        /---LinkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历
 *                      原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                           对于频繁的遍历操作，此类执行效率高于HashMap
 *     /---TreeMap:保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序或定制排序
 *                 底层使用红黑树，
 *     /---HashTable:作为古老的实现类，线程安全，效率低，不可存储null的key和value
 *        /---Properties:常用来处理配置文件，key和value都是String类型
 *
 *    HashMap底层：数组+链表（jdk7及之前）
 *                数组+链表+红黑树（jdk8）
 *
 *    Map结构：
 *        Map中的key：无序、不可重复，使用Set存储所有的key
 *                  --->key所在类要重写equals（）和hashCode（）（以HashMap为例）
 *        Map中的value：无序、可重复的，使用Collection存储所有的value
 *                  --->value所在类要重写equals（）
 *        一个键值对：key-value构成了一个Entry对象
 *        Map中的entry：无序、不可重复的，使用Set存储所有的entry
 *
 *    HashMap底层实现原理：
 *      jdk7：HashMap map=new HashMap(); 在实例化后，底层创建了长度为16的一维数组Entry[] table;
 *      ...可能已经执行过多次put...
 *      map.put(key1,value1);
 *      首先，调用key1所在类的hashCode()计算key1哈希值，此哈希值经过某种算法计算以后， 得到在Entry数组的存放位置，
 *      若此位置上数据为空，此时的key1-value1添加成功--->情况一
 *      若此位置上数据不为空，(意味着此位置上存在一个或多个数据(以链表形式存在))，比较key1和已经存在的一个或多个
 *      数据的哈希值：
 *                若key1的哈希值与已经存在的数据的哈希值都不相同，此时key1-value1添加成功--->情况二
 *                若key1的哈希值和已经存在的某一个数据(key2-value2)的哈希值相同，继续比较，调用key1所在类的equals(key2)方法：
 *                      若equals（）返回false，此时key1-value1添加成功--->情况三
 *                      若equals（）返回true，使用value1替换value2
 *
 *      对于情况二与三：此时key1-value1和原来的数据以链表形式存储
 *      在添加过程中，会涉及到扩容问题，当超出临界值（且要存放的位置非空），默认扩容为原容量的2倍，并将所有数据复制过来
 *
 *      jdk8：与jdk7的不同
 *      1、new HashMap():底层并未初始就创建一个长度为16的数组
 *      2、jdk8底层的数组是Node[],而非entry[]
 *      3、首次调用put（）方法时，底层创建长度为16的数组
 *      4、jdk7底层结构只有：数组+链表  jdk8底层结构：数组+链表+红黑树
 *      当数组的某一个索引位置上的元素以链表形式存在的数据个数>8且当前数组的长度>64时，
 *      此时此索引位置上的所有数据改用红黑树存储
 *
 *      DEFAULT_INITIAL_CAPACITY:HashMap默认容量16
 *      DEFAULT_LOAD_FACTOR:HashMap默认加载因子：0.75
 *      threshold:扩容的临界值=容量*填充因子：16*0.75==》12
 *      TREEIFY_THRESHOLD:Bucket中链表长度大于该默认值，转化为红黑树：8
 *      MIN_TREEIFY_CAPACITY:桶中Node被树化时最小的hash容量：64
 *
 *      LinkedHashMap的底层实现原理：提供双向节点,实现排序
 *
 */
public class MapTest {

    @Test
    public void test3(){
        Map map=new HashMap();
        map.put("AA",123);
        map.put(34,12);
        map.put("BB",34);

        //遍历所有key集：KeySet()
        Set set=map.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有value集：values()
        Collection values=map.values();
        Iterator iterator1=values.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

        //遍历所有key-value
        //entrySet():
        Set entrySet=map.entrySet();
        Iterator iterator2=entrySet.iterator();
        while (iterator2.hasNext()){
            Object obj=iterator2.next();
            //entrySet集合中元素都是entry 以一个key-value对作为一个元素
            Map.Entry entry=(Map.Entry)obj;
            System.out.println(entry.getKey()+"--->"+entry.getValue());
        }

        Set keySet=map.keySet();
        Iterator iterator3=keySet.iterator();
        while (iterator3.hasNext()){
            Object key=iterator3.next();
            Object value=map.get(key);
            System.out.println(key+"==>"+value);
        }
    }

    @Test
    public void test2(){

        Map map=new HashMap();
        map.put("AA",123);
        map.put(34,12);
        map.put("BB",34);

        //Object get(Object key)
        System.out.println(map.get(34));

        //containsKey(Object key)
        boolean isExist=map.containsKey("BB");
        System.out.println(isExist);

        isExist=map.containsValue(12);
        System.out.println(isExist);

        map.clear();
        System.out.println(map.isEmpty());
    }

    @Test
    public void test1(){
        Map map=new HashMap();
        //添加
        map.put("AA",39);
        map.put(34,31);
        map.put("BB",53);
        //修改
        map.put("AA",45);

        Map map1=new HashMap();
        map1.put("CC",12);
        map1.put("DD",34);
        System.out.println(map1);
        //添加所有
        map.putAll(map1);
        System.out.println(map);

        //remove(Object obj)
        Object value=map.remove("CC");
        System.out.println(map);

        //clear() 只是清空数据，并未将其改为null
        map.clear();
        System.out.println(map);
    }
}
