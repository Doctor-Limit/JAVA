package Day03.test1;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * ********概述：泛型的使用：确定输入数据的类型，不匹配的数据类型无法成功操作
 * jdk5.0新增的特性
 *
 * 在集合中使用泛型：（1）集合接口或集合类在jdk5.0都修改为带泛型的结构
 *               （2）在实例化集合时，可以指明具体的泛型类型
 *               （3）指明完后，在集合类或接口中凡是定义类或接口时，内部结构（比如:方法、构造器、属性等）
 *                    使用到类的泛型的位置，都指定为实例化的泛型类型
 *                                      add(E e)  --->实例化后，add(Integer e)
 *               （4）泛型的类型必须是类，不能是基本数据类型，需要用到基本数据类型的位置都拿包装类替换
 *               （5）若实例化时，未指明泛型类型，默认为Object类型
 *
 * 自定义泛型结构：泛型类，泛型接口：泛型方法
 *
 *
 */
public class GenericTest {

    //集合中使用泛型:以HashMap举例
    @Test
    public void test3(){
        Map<String, Integer> map = new HashMap<String,Integer>();
        map.put("Tom",89);
        map.put("Jack",90);

        //类型固定，无法放入其他类型数据
        //map.put(123,"abc");

        //泛型的嵌套
        Set<Map.Entry<String,Integer>> entry =map.entrySet();
        Iterator<Map.Entry<String,Integer>> iterator= entry.iterator();
        while (iterator.hasNext()){
            Map.Entry<String,Integer> e=iterator.next();
            String key=e.getKey();
            Integer value=e.getValue();
            System.out.println(key+" "+value);
        }
    }

    //集合中使用泛型:以ArrayList举例
    @Test
    public void test2(){
        //不能是基本数据类型
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(23);
        list.add(45);
        list.add(32);
        //编译时就会进行类型检查，保证数据安全
        //list.add("Tom");

        //方式一：
//        for (Integer score :list) {
//            int stuScore=score;
//            System.out.println(stuScore);
//        }

        //方式二：
        Iterator<Integer> iterator=list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test1(){
        ArrayList list=new ArrayList();
        //存放学生成绩
        list.add(78);
        list.add(89);
        list.add(70);
        list.add(96);
        //问题一：类型不安全
        list.add("Tom");

        for (Object score :list) {
            //问题二：强转时，可能出现类型转换异常
            int stuScore=(int) score;
            System.out.println(stuScore);
        }
    }
}
