package Day02.test3;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Comparator;

/**
 * ********概述：
 *  自然排序:Comparable
 * 1、对自定义类而言，若需要排序，可自定义类实现Comparable接口，重写compareTo()方法
 *    在compareTo(obj)指明如何排序
 *
 *  定制排序：Comparator
 * 1、重写compare(Object o1,Object o2),比较o1，o2大小，正整数o1>o2,负整数o1<o2
 *
 *
 * 二者对比
 * Comparable接口的方式一旦指定，保证Comparable接口实现类的对象在任何位置都可以比较大小
 * Comparator接口属于临时性比较
 *
 */
public class GoodsTest {
    @Test
    public void test1(){

        Goods[] arr=new Goods[4];
        arr[0]=new Goods("1ge",16);
        arr[1]=new Goods("1uw",22);
        arr[2]=new Goods("1fe",22);
        arr[3]=new Goods("1se",11);

        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    @Test
    public void test2(){
        String[] str1=new String[]{"AA","DD","EE","JJ","GG","ZZ","MM"};
        //按照字符串从大到小排序（定制规则）
        Arrays.sort(str1,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof String&&o2 instanceof String){
                    String s1=(String) o1,s2=(String) o2;
                    return -s1.compareTo(s2);
                }

                throw new RuntimeException("输入数据类型不一致");
            }
        });
        System.out.println(Arrays.toString(str1));
    }
    @Test
    public void test3(){
        Goods[] arr=new Goods[5];
        arr[0]=new Goods("1ge",16);
        arr[1]=new Goods("1uw",22);
        arr[2]=new Goods("1fe",22);
        arr[3]=new Goods("1se",11);
        arr[4]=new Goods("1se",33);

        //compare默认从低到高，加上负号来使其从高到低
        //指明比较商品方式：先按产品名称从高到低，再按价格从高到低
        Arrays.sort(arr,new Comparator(){
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Goods&&o2 instanceof Goods){
                    Goods g1=(Goods) o1,g2=(Goods) o2;
                    if(g1.getName().equals(g2.getName())){
                     return -Double.compare(g1.getPrice(),g2.getPrice());
                    }else{
                     return g1.getName().compareTo(g2.getName());
                    }
                }
                throw new RuntimeException("传入数据不匹配");
            }
        });
        System.out.print(Arrays.toString(arr)+" ");
    }
}
