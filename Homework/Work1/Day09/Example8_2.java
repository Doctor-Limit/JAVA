package Work1.Day09;

/**
 * ********概述：
 */
public class Example8_2 {
    public static void main(String[] args) {
        String s1, s2;
        s1 = new String("天道酬勤");
        s2 = new String("天道酬勤");
        System.out.println(s1);
        System.out.println(s2);
        System.out.println("二者的实体相同吗:" + s1.equals(s2));
        int address1 = System.identityHashCode(s1);
        int address2 = System.identityHashCode(s2);
        System.out.printf("String对象s1和s2的引用分别是%x，%x\n", address1, address2);
        System.out.printf("二者引用相同吗:%b\n", s1 == s2);
        String s3, s4;
        s3 = "we are students";
        s4 = new String("we are students");
        System.out.println(s3);
        System.out.println(s4);
        System.out.println("二者的实体相同吗:" + s1.equals(s2));
        int address3 = System.identityHashCode(s3);
        int address4 = System.identityHashCode(s4);
        System.out.printf("String对象s3和s4的引用分别是%x，%x\n", address3, address4);
        System.out.printf("二者引用相同吗:%b\n", s3 == s4);
        String s5, s6;
        s5 = "勇者无敌";
        s6 = "勇者无敌";
        System.out.println(s5);
        System.out.println(s6);
        System.out.println("二者的实体相同吗:" + s5.equals(s6));
        int address5 = System.identityHashCode(s5);
        int address6 = System.identityHashCode(s6);
        System.out.printf("String对象s5和s6的引用分别是%x，%x\n", address5, address6);
        System.out.printf("二者引用相同吗:%b\n", s5 == s6);

    }
}
