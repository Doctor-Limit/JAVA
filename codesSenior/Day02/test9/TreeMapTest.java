package Day02.test9;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * ********概述：
 */
public class TreeMapTest {
    //向TreeMap添加key-value，要求key必须是由同一个类创建的对象
    //可按key进行排序：自然排序、定制排序
    @Test
    public void test1(){
        TreeMap map=new TreeMap();
        map.put("BB","dd");
        map.put("DD","bb");
        map.put("AA","cc");

        Set entrySet=map.entrySet();
        Iterator iterator=entrySet.iterator();
        while (iterator.hasNext()){
           Object obj=iterator.next();
            Map.Entry entry=(Map.Entry) obj;
            System.out.println(entry.getKey()+"--->"+entry.getValue());


        }


    }

}
