package Day02.test8;

import org.junit.jupiter.api.Test;
import java.util.*;

/**
 * ********概述：
 */
public class TreeSetTest {

    /*
    向TreeSet添加的数据，要求必须是同类的对象
    两种排序方式：自然排序和定制排序

    自然排序中：比较两个对象是否相同的标准：compareTo返回0而不是equals
    定制排序中，比较两个对象是否相同的标准：compare返回0而不是equals

     */
    @Test
    public void test1(){

        TreeSet set=new TreeSet();
        set.add(123);
        set.add(-34);
        set.add(9);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Comparator com=new Comparator() {
            //按照年龄从小到大排序
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };
        TreeSet set=new TreeSet();//写上参数就可按比较器中方法排序
    }

}
