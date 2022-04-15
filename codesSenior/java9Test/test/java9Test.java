package java9Test.test;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

/**
 * ********概述：
 */
public class java9Test {

    //钻石操作符的升级
    @Test
    public void test1(){

        Comparator<Object> comparator = new Comparator<>(){
            @Override
            public int compare(Object o1, Object o2) {
                return 0;
            }
        };


    }




}
