package Day02.test6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * ********概述：集合元素的遍历操作
 * 内部方法：hasNext()和next()
 * 集合对象每次调用iterator()方法都得到全新的迭代器对象，默认游标在第一个元素之前
 * 内部定义了remove，可以在遍历的时候，删除集合中的元素，此方法不同于集合直接调用remove
 *
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll1= Arrays.asList(123,456,"Tom");

        //若执行次数超过容量则会抛异常
        Iterator iterator=coll1.iterator();
        for (int i = 0; i < coll1.size(); i++) {
            System.out.println(iterator.next());//获取元素
        }
        //推荐：若还有元素则进入其中实现遍历操作
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
    @Test
    public void test2(){
        Collection coll1= Arrays.asList(123,456,"Tom");
        Iterator iterator=coll1.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        while (iterator.hasNext()){
            Object obj=iterator.next();
            if("Tom".equals(obj))
                iterator.remove();
        }

        //迭代器已改变
        Iterator iterator1=coll1.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }

}
