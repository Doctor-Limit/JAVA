package Work1.Day09;

/**
 * ********概述：
 */
public class Example8_1 {
    public static void main(String[] args) {
        String hello = "你好";
        String testOne = "你" + "好";
        int address = System.identityHashCode("你好");
        System.out.printf("\"你好\"的引用:%x\n",address);
        address = System.identityHashCode(hello);
        System.out.printf("hello的引用:%x\n",address);
        address = System.identityHashCode(testOne);
        System.out.printf("testOne的引用:%x\n",address);
        System.out.println(hello == testOne);
        System.out.println("你好" == testOne);
        System.out.println("你好" == hello);
        String you = "你";
        String hi = "好";
        String testTwo = you + hi;
        address = System.identityHashCode("你");
        System.out.printf("\"你\"的引用:%x\n",address);
        address = System.identityHashCode("好");
        System.out.printf("好的引用:%x\n",address);
        address = System.identityHashCode(testTwo);
        System.out.printf("testTwo的引用:%x\n",address);
        System.out.println(hello == testTwo);
    }
}
