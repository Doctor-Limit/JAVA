package Day02.test7;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * ********概述：
 * 区分list中remove(int index)和remove(Object obj)区别
 *
 */
public class ListExe {

    @Test
    public void test4(){
        List list=new ArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        updateList(list);
        System.out.println(list);

    }
    private void updateList(List list){
        //list.remove(2);删除索引为2的元素   并未自动装箱
        list.remove(Integer.valueOf(2));//删除数据2
    }
}
