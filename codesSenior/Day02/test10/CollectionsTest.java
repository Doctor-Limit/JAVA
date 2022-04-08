package Day02.test10;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * ********概述：操作Collection、Map的工具类
 *
 *
 */
public class CollectionsTest {

    @Test
    public void test2(){
        List list=new ArrayList();
        list.add(23);
        list.add(0);
        list.add(3);
        list.add(-3);
        list.add(-19);

        //报异常：首先复制的数组长度要大于被复制数组长度
//        List dest=new ArrayList();
//        Collections.copy(dest,list);//将list复制到dest


        List dest= Arrays.asList(new Object[list.size()]);
        Collections.copy(dest,list);

        System.out.println(dest);

        //返回线程安全的方法
        List list1=Collections.synchronizedList(list);

    }

    @Test
    public void test1(){

        List list=new ArrayList();
        list.add(23);
        list.add(0);
        list.add(3);
        list.add(-3);
        list.add(-19);

        System.out.println(list);
        //反转链表
        //Collections.reverse(list);
        //对链表元素进行随机排序
        //Collections.shuffle(list);
        //从小到大排序
        //Collections.sort(list);
        //交换元素
        //Collections.swap(list,1,3);
        //查看该元素出现的次数
        System.out.println(Collections.frequency(list,0));

        System.out.println(list);
    }

}
