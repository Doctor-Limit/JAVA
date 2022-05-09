package Work1.Day09.Example8_5;


import java.util.Date;

/**
 * ********概述：
 */
public class Example8_5 {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date.toString());
        int address = System.identityHashCode(date);
        System.out.printf("date对象的引用:%x\n", address);
        TV tv = new TV();
        tv.setPrice(5897.98);
        System.out.println(tv.toString());
        address = System.identityHashCode(tv);
        System.out.printf("tv对象的引用:%x\n", address);
    }
}
