package Day02.test6;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * ********概述：集合元素的遍历操作
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

}
