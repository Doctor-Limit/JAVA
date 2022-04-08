package Day02.test7;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Collection;

/**
 * ********概述：jdk foreach循环用来遍历集合
 *
 */
public class ForTest {

    @Test
    public void test1(){
        Collection c1= Arrays.asList("Tom",123,45,false);

        //for(集合中元素类型  局部变量 : 数组对象)
        //内部任然调用迭代器
        for(Object obj :c1){
            System.out.println(obj);
        }
        int []arr=new int[]{1,2,5,3};
        for(int i:arr){
            System.out.println(i);
        }
    }

    @Test
    public void test2(){
        String []arr=new String[]{"MM","MM","MM"};

        //方式一：
//        for (int i = 0; i < arr.length; i++) {
//            arr[i]="GG";
//        }
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }

        //foreach循环
        for(String s:arr){//不会改变原有数组元素
            s="GG";
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }


}
