package Day04.test10;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * ********概述：lambda表达式使用
 *
 */
public class LambdaTest {

    @Test
    public void test1(){
        Runnable r1=new Runnable() {
            @Override
            public void run() {
                System.out.println("kksk");
            }
        };
        r1.run();

        System.out.println("**********************");

        Runnable r2=()-> System.out.println("wtxkksk");
        r2.run();
    }

    @Test
    public void test2(){
        Comparator<Integer> com1 = new Comparator<>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;
            }
        };
        int c1=com1.compare(1,2);
        System.out.println(c1);

        System.out.println("***************");
        //lambda表达式的写法
        Comparator<Integer> com2=(o1,o2)->Integer.compare(o1,o2);

        int c2=com2.compare(12,21);
        System.out.println(c2);

        System.out.println("******************");
        //方法引用的写法
        Comparator<Integer> com3=Integer::compare;
        int c3=com3.compare(12,221);
        System.out.println(c3);

    }

}
